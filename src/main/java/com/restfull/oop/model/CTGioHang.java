package com.restfull.oop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CT_GioHang")
@Data
public class CTGioHang {
    @Id
    @Column(name = "idGio")
    private Long idGio;

    @ManyToOne
    @JoinColumn(name = "maCTSP")
    private CTSanPham CTSanPham;

    @Column(name = "gia")
    private int gia;

    @Column(name = "soLuong")
    private int soLuong;
}
