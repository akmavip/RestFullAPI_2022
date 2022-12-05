package com.restfull.oop.payload;

import com.restfull.oop.model.Size;
import lombok.Data;

@Data
public class CTSanPhamPayLoad {

    private Long maCTSP;

    private Size size;

    private int gia;

    private int slTon;

    private String moTa;
}
