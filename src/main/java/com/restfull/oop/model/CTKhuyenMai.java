package com.restfull.oop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="CT_KhuyenMai")
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CTKMId.class)
public class CTKhuyenMai {

//    @EmbeddedId
//    private CTKMId id;

    @Id
    private Long maCTSP;

    @Id
    private Long maKm;

    @ManyToOne
    @MapsId("maCTSP")
    @JoinColumn(name = "maCTSP")
    private CTSanPham ctSanPham;

    @ManyToOne
    @MapsId("maKM")
    @JoinColumn(name = "maKM")
    private KhuyenMai khuyenMai;

    @Column(name = "phanTramGiam")
    private int phanTramGiam;

}
