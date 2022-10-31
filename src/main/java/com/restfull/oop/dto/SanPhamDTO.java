package com.restfull.oop.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class SanPhamDTO {
    private int maSP;
    private String tenSP;
    private int maTL;
    private int tongSLTon;
    private int luotXem;
    private Date ngayTao;
    private Date ngayCapNhat;
    private String hinhAnh;
}
