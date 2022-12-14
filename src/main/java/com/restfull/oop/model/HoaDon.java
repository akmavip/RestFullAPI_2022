package com.restfull.oop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "HoaDon")
//@Data
@Getter
@Setter
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="maHoaDon")
    private Long maHoaDon;

    @ManyToOne
    @JoinColumn(name = "idGio")
    private GioHang gioHang;

    @Column(name="ngayTao")
    private Instant ngayTao;
}
