package com.restfull.oop.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "GioHang")
@Data
public class GioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGio")
    private Long idGio;

    @ManyToOne
    @JoinColumn(name = "maKH")
    private KhachHang khachHang;

    @Column(name = "hoTen")
    private String hoTen;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "email")
    private String email;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "ngayGiao")
    private Date ngayGiao;

    @Column(name = "moTa")
    private String moTa;

    @Column(name = "trangThai")
    private int trangThai;

    @JoinColumn(name = "maNVDuyet")
    private String maNVDuyet;

//    @ManyToOne
    @Column(name = "maNVGiao")
    private String maNVGiao;

    @OneToMany(mappedBy = "gioHang", fetch = FetchType.EAGER)
    List<CTGioHang> ctGioHangs;

    @Transient
    private CTGioHang detail;

    public void setDetail(CTGioHang detail) {
        this.detail = detail;
    }

    public Long getIdGio() {
        return idGio;
    }
}
