package com.restfull.oop.service.impl;

import com.restfull.oop.dto.GioHangDTO;
import com.restfull.oop.mapper.GioHangMapper;
import com.restfull.oop.model.GioHang;
import com.restfull.oop.repository.GioHangRepository;
import com.restfull.oop.service.GioHangService;
import com.restfull.oop.vm.GioHangVM;
import com.restfull.oop.vm.mapper.GioHangMapperVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;


@Service
@Transactional
public class GioHangServiceImpl implements GioHangService {
    @Autowired
    private GioHangRepository gioHangRepository;

    @Autowired
    private GioHangMapper gioHangMapper;

    @Autowired
    private GioHangMapperVM gioHangMapperVM;

    @Override
    public GioHangVM create() {

//        GioHang gioHang = new GioHang();
//        gioHang.setIdGio(7L);
//        gioHang.setEmail("asd@gmail.com");
//        gioHang.setDiaChi("asd");
//        gioHang.setMaKH(1L);
//        gioHang.setSdt("0999999999");
//        gioHang.setHoTen("asd");
//        gioHang.setNgayTao(new Date(2022, 2, 2));
//        gioHang.setNgayGiao(new Date(2022, 2, 2));
//        gioHang.setTrangThai(0);
//        gioHang.setMaNVDuyet("employee01");
//        gioHang.setMaNVGiao("employee01");

//        gioHangRepository.save(gioHang);
//    System.out.println(gioHang);
//        return gioHangMapperVM.toDto(gioHang);
        return  null;
    }
}
