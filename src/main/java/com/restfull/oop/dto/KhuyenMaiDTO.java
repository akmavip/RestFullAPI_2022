package com.restfull.oop.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class KhuyenMaiDTO {

    private Long maKM;

    private String maNV;

    private Date ngayApDung;

    private Date ngayKetThuc;

    private String mota;
}
