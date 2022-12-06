package com.restfull.oop.vm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.Instant;

@Data
public class CTKhuyenMaiVM {

    private Long maCTSP;

    private Long maKM;

    private int phanTramGiam;

//    @JsonIgnore
    private KhuyenMaiVM khuyenMai;

    public int getPhanTramGiam() {
        if (!(Instant.now().isAfter(khuyenMai.getNgayApDung()) && khuyenMai.getNgayKetThuc().isAfter(Instant.now()))) {
            this.phanTramGiam = 0;
        } else
            this.phanTramGiam = phanTramGiam;
        return phanTramGiam;
    }
}
