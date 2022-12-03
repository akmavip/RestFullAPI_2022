package com.restfull.oop.vm;

import lombok.Data;

import java.time.Instant;

@Data
public class CTKhuyenMaiVM {

    private Long maCTSP;

    private Long maKm;

    private int phanTramGiam;

    private CTSanPhamVM ctSanPham;

    private KhuyenMaiVM khuyenMai;

//    public void setKhuyenMai(KhuyenMaiVM khuyenMai) {
//        this.khuyenMai = khuyenMai;
//        if(!(Instant.now().isAfter(khuyenMai.getNgayApDung()) && khuyenMai.getNgayKetThuc().isAfter(Instant.now()))){
//            this.phanTramGiam = 0;
//        }
//    }

//    public void setPhanTramGiam(int phanTramGiam) {
//        if (khuyenMai.getNgayApDung().notNULL -----!(Instant.now().isAfter(khuyenMai.getNgayApDung()) && khuyenMai.getNgayKetThuc().isAfter(Instant.now()))) {
//            this.phanTramGiam = 0;
//        }
//        this.phanTramGiam = phanTramGiam;
//    }
}
