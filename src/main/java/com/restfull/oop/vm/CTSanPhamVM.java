package com.restfull.oop.vm;

import com.restfull.oop.model.Size;
import lombok.Data;

import java.util.List;

@Data
public class CTSanPhamVM {

    private Long maCT;

    private Size size;

    private int gia;

    private int slTon;

    private String moTa;

    private List<CTKhuyenMaiVM> ctKhuyenMais;
}
