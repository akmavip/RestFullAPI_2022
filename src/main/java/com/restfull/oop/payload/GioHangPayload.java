package com.restfull.oop.payload;

import com.restfull.oop.model.CTGioHang;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class GioHangPayload {
    private Long idGio;

    private Long maKH;

    private String hoTen;

    private String sdt;

    private String email;

    private String diaChi;

    private Date ngayTao;

    private Date ngayGiao;

    private int trangThai;

    private String moTa;
    private String maNVDuyet;

    private String maNVGiao;

    private List<CTGioHangPayLoad> arr;


}
