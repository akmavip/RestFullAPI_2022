package com.restfull.oop.model;
import lombok.Data;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "SanPham")
@Data
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maSP")
    private int maSP;

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

    @Transient
    private CTSanPham detail;

    public void setDetail(CTSanPham detail) {
        this.detail = detail;
    }
}
