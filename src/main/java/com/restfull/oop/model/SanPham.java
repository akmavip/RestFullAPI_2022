package com.restfull.oop.model;
import lombok.Data;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "SanPham")
@Data
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maSP")
    private Long maSP;

    @Column(name = "tenSP")
    private String tenSP;

    @ManyToOne
    @JoinColumn(name = "maTL")
    private TheLoai theLoai;

    @Column(name = "tongSLTon")
    private int tongSLTon;

    @Column(name = "luotXem")
    private int luotXem;

    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "ngayCapNhat")
    private Date ngayCapNhat;

    @Column(name = "hinhAnh")
    private String hinhAnh;

    @OneToMany(mappedBy = "sanPham", fetch = FetchType.EAGER)
    List<CTSanPham> cTSanPhams;

    @Transient
    private CTSanPham detail;

    public void setDetail(CTSanPham detail) {
        this.detail = detail;
    }
}
