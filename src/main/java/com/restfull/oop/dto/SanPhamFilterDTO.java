package com.restfull.oop.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class SanPhamFilterDTO {

    private Long maSP;

    private String tenSP;

    private Date ngayTaoFrom;

    private Date ngayTaoTo;

    private Long maTL;

    private int maSize;

    private int giaFrom;

    private int giaTo;

}
