package com.restfull.oop.vm;

import com.restfull.oop.model.CTSanPham;
import com.restfull.oop.model.Size;
import lombok.Data;

@Data
public class CTSanPhamVM {

    private Long maCTSP;

    private Size size;

    private int gia;

    private int slTon;

    private String moTa;
}
