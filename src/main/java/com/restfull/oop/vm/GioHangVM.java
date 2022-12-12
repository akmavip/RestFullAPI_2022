package com.restfull.oop.vm;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class GioHangVM {
    private Long idGio;

    private Long maKH;

    private String hoTen;

    private String sdt;

    private String email;

    private String diaChi;

    private Date ngayTao;

    private Date ngayGiao;

    private String moTa;

    private int trangThai;

    private String maNVDuyet;

    private String maNVGiao;

    List<CTGioHangVM> ctGioHangs;

}
