package com.restfull.oop.vm;

import com.restfull.oop.model.CTSanPham;
import lombok.Data;

@Data
public class CTGioHangVM {
    private Long idGio;
    private CTSanPham CTSanPham;
    private int gia;
    private int soLuong;
}