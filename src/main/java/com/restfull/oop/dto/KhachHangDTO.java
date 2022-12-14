package com.restfull.oop.dto;

import com.restfull.oop.model.TaiKhoan;
import lombok.Data;

@Data
public class KhachHangDTO {
    private Long maKH;

    private TaiKhoan taiKhoan;

    private String hoTen;

    private String sdt;

    private String email;

    private String diaChi;

    private String maSoThue;
}
