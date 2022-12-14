package com.restfull.oop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Quyen")
//@Data
@Getter
@Setter
public class Quyen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maQuyen")
    private Long maQuyen;

    @Column(name = "tenQuyen")
    private String tenQuyen;

    @OneToMany(mappedBy = "quyen", fetch = FetchType.EAGER)
    List<TaiKhoan> taiKhoans;
}
