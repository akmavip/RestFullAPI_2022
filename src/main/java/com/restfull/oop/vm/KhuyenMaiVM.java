package com.restfull.oop.vm;

import lombok.Data;

import java.time.Instant;

@Data
public class KhuyenMaiVM {

    private Long maKM;

    private String maNV;

    private Instant ngayApDung;

    private Instant ngayKetThuc;

    private String mota;

}
