package com.restfull.oop.vm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restfull.oop.model.CTKhuyenMai;
import com.restfull.oop.model.Size;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class CTSanPhamVM {

    private Long maCT;

    private Size size;

    private int gia;

    private int slTon;

    private String moTa;

    private int phanTramGiam;

    @JsonIgnore
    private List<CTKhuyenMaiVM> ctKhuyenMais;

    public int getPhanTramGiam() {
        try {
            return ctKhuyenMais.get(0).getPhanTramGiam();
        }
        catch (Exception e){
            return 0;
        }
    }
}
