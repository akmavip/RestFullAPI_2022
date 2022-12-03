package com.restfull.oop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "NhanVien")
//@Data
@Getter
@Setter
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="maNV")
    private Long maNV;

    private String hoTen;

    private String sdt;

    private String email;

    private String diaChi;

    private String cmnd;

    @ManyToOne
    @JoinColumn(name = "maTK")
    private TaiKhoan taiKhoan;

    @OneToMany(mappedBy = "nhanVien", fetch = FetchType.EAGER)
    private List<KhuyenMai> khuyenMais;
}
