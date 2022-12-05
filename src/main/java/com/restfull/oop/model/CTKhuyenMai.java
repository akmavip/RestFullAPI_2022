package com.restfull.oop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CT_KhuyenMai")
@Data
public class CTKhuyenMai {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "maCTKM")
    private Long maCTKM;

    @ManyToOne
    @JoinColumn(name = "maKM")
    private KhuyenMai khuyenMai;

    @Column(name = "maCTSP")
    private Long maCTSP;

    @Column(name = "phanTramGiam")
    private int phanTramGiam;
}
