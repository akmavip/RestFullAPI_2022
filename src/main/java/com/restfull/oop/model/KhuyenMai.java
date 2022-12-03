package com.restfull.oop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "KhuyenMai")
//@Data
@Getter
@Setter
public class KhuyenMai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="maKM")
    private Long maKM;

    @Column(name="ngayApDung")
    private Instant ngayApDung;

    @Column(name="ngayKetThuc")
    private Instant ngayKetThuc;

    @Column(name="mota")
    private String mota;

    @OneToMany(mappedBy = "khuyenMai", fetch = FetchType.EAGER)
    private List<CTKhuyenMai> ctKhuyenMais;

    @ManyToOne
    @JoinColumn(name = "maNV")
    private NhanVien nhanVien;

}
