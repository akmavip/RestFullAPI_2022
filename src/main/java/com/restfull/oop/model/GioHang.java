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

    @OneToMany(mappedBy = "gioHang")
    private List<CTGioHang> ctGioHangs;

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

    @Column(name = "trangThai")
    private int trangThai;

    @JoinColumn(name = "maNVDuyet")
    private String maNVDuyet;

    @ManyToOne
    @JoinColumn(name = "maNVGiao")
    private NhanVien nhanVien;


    public Long getIdGio() {
        return idGio;
    }
}
