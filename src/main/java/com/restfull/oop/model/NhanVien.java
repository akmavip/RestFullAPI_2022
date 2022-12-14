package com.restfull.oop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "NhanVien")
@Data
public class NhanVien {
    @Id
    @Column(name = "maNV")
    private String maNV;

    @Column(name = "hoTen")
    private String hoTen;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "email")
    private String email;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "cmnd")
    private String cmnd;

    @Column(name = "maTK")
    private Long maTK;

}
