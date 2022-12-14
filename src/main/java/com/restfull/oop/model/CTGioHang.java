package com.restfull.oop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CT_GioHang")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CTGHId.class)
public class CTGioHang {
    @Id
    private Long idGio;

    @Id
    private Long maCTSP;

    @ManyToOne
    @MapsId("idGio")
    @JoinColumn(name = "idGio")
    private GioHang gioHang;

    @ManyToOne
    @MapsId("maCTSP")
    @JoinColumn(name = "maCTSP")
    private CTSanPham CTSanPham;

    @Column(name = "gia")
    private int gia;

    @Column(name = "soLuong")
    private int soLuong;
}