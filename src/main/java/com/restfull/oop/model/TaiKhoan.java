package com.restfull.oop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "TaiKhoan")
//@Data
@Getter
@Setter
public class TaiKhoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maTK")
    private Long maTK;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "maQuyen")
    private Quyen quyen;

    @OneToMany(mappedBy = "taiKhoan", fetch = FetchType.EAGER)
    List<NhanVien> nhanViens;
}
