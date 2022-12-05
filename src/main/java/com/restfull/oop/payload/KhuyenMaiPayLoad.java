package com.restfull.oop.payload;
import lombok.Data;

import java.sql.Date;
import java.util.List;
@Data
public class KhuyenMaiPayLoad {
    private Long maKM;

    private String maNV;

    private Date ngayApDung;

    private Date ngayKetThuc;

    private String moTa;

    private List<SanPhamPayLoad> dssp;

    private int phanTramGiam;
}
