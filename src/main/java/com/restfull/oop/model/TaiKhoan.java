package com.restfull.oop.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "TaiKhoan")
@Data
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
}
