package com.restfull.oop.service.impl;

import com.restfull.oop.dto.GioHangDTO;
import com.restfull.oop.mapper.CTGioHangMapper;
import com.restfull.oop.mapper.GioHangMapper;
import com.restfull.oop.model.CTGioHang;
import com.restfull.oop.model.GioHang;
import com.restfull.oop.model.KhachHang;
import com.restfull.oop.model.NhanVien;
import com.restfull.oop.repository.GioHangRepository;
import com.restfull.oop.repository.KhachHangRepository;
import com.restfull.oop.repository.NhanVienRepository;
import com.restfull.oop.service.GioHangService;
import com.restfull.oop.vm.GioHangVM;
import com.restfull.oop.vm.mapper.GioHangMapperVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;


@Service
@Transactional
public class GioHangServiceImpl implements GioHangService {
    @Autowired
    private GioHangRepository gioHangRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private GioHangMapper gioHangMapper;

    @Autowired
    private GioHangMapperVM gioHangMapperVM;

    @Autowired
    private CTGioHangMapper ctGioHangMapper;

    @Override
    public GioHangVM create(GioHangDTO gioHangDTO) {

    GioHang gioHang = gioHangMapper.toEntity(gioHangDTO);
//        List<CTGioHang> x = ctGioHangMapper.toEntity(gioHangDTO.getCTGioHangs());

        KhachHang khachHang = khachHangRepository.findById(gioHangDTO.getMaKH()).get();
        NhanVien nhanVien = nhanVienRepository.findById(gioHangDTO.getMaNVGiao()).get();
        gioHang.setKhachHang(khachHang);
        gioHang.setNhanVien(nhanVien);
        gioHang.setCtGioHangs(gioHangDTO.getCTGioHangs());

        gioHangRepository.save(gioHang);



        return gioHangMapperVM.toDto(gioHang);
    }
}