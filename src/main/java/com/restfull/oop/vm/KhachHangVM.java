package com.restfull.oop.vm;

import com.restfull.oop.model.TaiKhoan;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
public class KhachHangVM {
    private Long maKH;
    private TaiKhoan taiKhoan;
    private String hoTen;
    private String sdt;
    private String email;
    private String diaChi;
    private String maSoThue;
}
