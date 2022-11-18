package com.restfull.oop.vm;

import com.restfull.oop.model.Size;
import lombok.Data;

@Data
public class CTSanPhamVM {

    private Long maCT;

    private Size size;

    private int gia;

    private int slTon;

    private String moTa;
}
