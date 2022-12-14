package com.restfull.oop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "KhachHang")
@Data
public class KhachHang {
    @Id
    @Column(name = "maKH")
    private Long maKH;

    @Column(name = "maTK")
    private Long maTK;

    @Column(name = "hoTen")
    private String hoTen;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "email")
    private String email;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "maSoThue")
    private String maSoThue;

}
