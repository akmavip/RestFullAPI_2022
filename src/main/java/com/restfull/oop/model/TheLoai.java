package com.restfull.oop.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TheLoai")
//@Data
@Getter
@Setter
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maTL")
    private Long maTL;

    @Column(name = "tenTL")
    private String tenTL;
}
