package com.restfull.oop.model;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CT_SanPham")
@Data
public class CTSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maCTSP")
    private Long maCTSP;

//    @OneToMany(mappedBy = "CTSanPham")
//    private List<CTGioHang> ctGioHangs;

    @ManyToOne
    @JoinColumn(name = "maSP")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "maSize")
    private Size size;

    @Column(name = "gia")
    private int gia;

    @Column(name = "slTon")
    private int slTon;

    @Column(name = "moTa")
    private String moTa;

}
