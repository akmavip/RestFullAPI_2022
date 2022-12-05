package com.restfull.oop.vm;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class KhuyenMaiVM {
    private Long maKM;

    private String maNV;

    private Date ngayApDung;

    private Date ngayKetThuc;

    private String mota;

    List<CTKhuyenMaiVM> cTKhuyenMais;
}
