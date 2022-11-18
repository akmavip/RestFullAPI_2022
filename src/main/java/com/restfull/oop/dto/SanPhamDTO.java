package com.restfull.oop.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class SanPhamDTO {

    private Long maSP;

    private String tenSP;

    private Long maTL;

    private int luotXem;

    private Date ngayTao;

    private Date ngayCapNhat;

    private String hinhAnh;

    private int slTon;

    private Long maSize;

    private int gia;

    private String mota;
}
