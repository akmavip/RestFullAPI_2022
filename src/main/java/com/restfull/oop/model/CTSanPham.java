package com.restfull.oop.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CT_SanPham")
//@Data
@Getter
@Setter
public class CTSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maCTSP")
    private Long maCTSP;

    @ManyToOne
    @JoinColumn(name = "maSP")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "maSize")
    private Size size;

    @OneToMany(mappedBy = "ctSanPham", fetch = FetchType.EAGER)
    private List<CTKhuyenMai> ctKhuyenMais;

    @Column(name = "gia")
    private int gia;

    @Column(name = "slTon")
    private int slTon;

    @Column(name = "moTa")
    private String moTa;

}
