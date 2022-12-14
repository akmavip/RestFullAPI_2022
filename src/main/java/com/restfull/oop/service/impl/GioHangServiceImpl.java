package com.restfull.oop.service.impl;

import com.restfull.oop.dto.GioHangDTO;
import com.restfull.oop.mapper.CTGioHangMapper;
import com.restfull.oop.mapper.GioHangMapper;
import com.restfull.oop.model.*;
import com.restfull.oop.payload.CTGioHangPayLoad;
import com.restfull.oop.payload.GioHangPayload;
import com.restfull.oop.payload.SanPhamPayLoad;
import com.restfull.oop.repository.CTGioHangRepository;
import com.restfull.oop.repository.GioHangRepository;
import com.restfull.oop.repository.KhachHangRepository;
import com.restfull.oop.repository.NhanVienRepository;
import com.restfull.oop.service.GioHangService;
import com.restfull.oop.vm.GioHangVM;
import com.restfull.oop.vm.KhuyenMaiVM;
import com.restfull.oop.vm.mapper.GioHangMapperVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class GioHangServiceImpl implements GioHangService {
    @Autowired
    private GioHangRepository gioHangRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private CTGioHangRepository ctGioHangRepository;

    @Autowired
    private GioHangMapper gioHangMapper;

    @Autowired
    private GioHangMapperVM gioHangMapperVM;

    @Autowired
    private CTGioHangMapper ctGioHangMapper;

    @Override
    public List<GioHangVM> getCart() {

        return gioHangRepository.findAll().stream().map(gioHangMapperVM::toDto).collect(Collectors.toList());

    }
    @Override
    public List<GioHangVM> getCartByMaKH(Long maKH) {
        System.out.println("makh " + maKH);
        KhachHang kh = new KhachHang();
        kh.setMaKH(maKH);
        List <GioHang> ds = gioHangRepository.findCartByMa(kh);
        System.out.println("Ds " + ds.stream().map(gioHangMapperVM::toDto).collect(Collectors.toList()));
        return ds.stream().map(gioHangMapperVM::toDto).collect(Collectors.toList());

    }

    @Override
    public GioHangPayload create(GioHangPayload gioHangPayload) {

        GioHang gioHang = new GioHang();
        KhachHang khachHangNew = new KhachHang();
        khachHangNew.setMaKH(gioHangPayload.getMaKH());
        gioHang.setKhachHang(khachHangNew);
        gioHang.setHoTen(gioHangPayload.getHoTen());
        gioHang.setSdt(gioHangPayload.getSdt());
        gioHang.setEmail(gioHangPayload.getEmail());
        gioHang.setDiaChi(gioHangPayload.getDiaChi());
        gioHang.setNgayTao(gioHangPayload.getNgayTao());
        gioHang.setTrangThai(gioHangPayload.getTrangThai());
        gioHang.setMoTa(gioHangPayload.getMoTa());

        gioHangRepository.save(gioHang);
        GioHang gioHangnew = new GioHang();
        gioHangnew.setIdGio(gioHangRepository.findNewestCart(khachHangNew));

        List <CTGioHangPayLoad> arr = gioHangPayload.getArr();
            for (int j = 0; j < arr.size(); j++) {

                CTSanPham ctSanPham = new CTSanPham();
                ctSanPham.setMaCTSP(arr.get(j).getMaCTSP());


                CTGioHang ctGioHang = new CTGioHang();
                ctGioHang.setMaCTSP(arr.get(j).getMaCTSP());
                ctGioHang.setGia(arr.get(j).getGia());
                ctGioHang.setSoLuong(arr.get(j).getSoLuong());
                ctGioHang.setGioHang(gioHangnew);
                System.out.println("ct gh " + ctGioHang);
                ctGioHangRepository.save(ctGioHang);
            }

        gioHangRepository.save(gioHang);

        return gioHangPayload;
    }

    public GioHangPayload update(GioHangPayload gioHangPayload) {

        GioHang gioHang = gioHangRepository.findCartToUpdate(gioHangPayload.getIdGio());


        gioHang.setNgayGiao(gioHangPayload.getNgayGiao());
        gioHang.setMaNVGiao(gioHangPayload.getMaNVGiao());
        gioHang.setMaNVDuyet(gioHangPayload.getMaNVDuyet());
        gioHang.setTrangThai(gioHangPayload.getTrangThai());

        System.out.println("gh " + gioHang.getDiaChi());
        gioHangRepository.save(gioHang);

        return gioHangPayload;
    }
}