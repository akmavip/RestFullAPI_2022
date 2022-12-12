package com.restfull.oop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CT_GioHang")
@Data
public class CTGioHang {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "maCTGH")
    private Long maCTGH;

    @ManyToOne
    @JoinColumn(name = "idGio")
    private GioHang gioHang;

    @Column(name = "maCTSP")
    private Long maCTSP;

    @Column(name = "gia")
    private int gia;

    @Column(name = "soLuong")
    private int soLuong;
}
