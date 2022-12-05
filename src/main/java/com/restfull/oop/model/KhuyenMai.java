package com.restfull.oop.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "KhuyenMai")
@Data
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maKM")
    private Long maKM;

    @Column(name = "maNV")
    private String maNV;

    @Column(name = "ngayApDung")
    private Date ngayApDung;

    @Column(name = "ngayKetThuc")
    private Date ngayKetThuc;

    @Column(name = "mota")
    private String mota;

    @OneToMany(mappedBy = "khuyenMai", fetch = FetchType.EAGER)
    List<CTKhuyenMai> cTKhuyenMais;

    @Transient
    private CTKhuyenMai detail;

    public void setDetail(CTKhuyenMai detail) {
        this.detail = detail;
    }
//    @Transient
//    private CTKhuyenMai detail;
//
//    public void setDetail(CTKhuyenMai detail) {
//        this.detail = detail;
//    }

}
