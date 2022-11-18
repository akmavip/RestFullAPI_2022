package com.restfull.oop.model;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "TheLoai")
@Data
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maTL")
    private Long maTL;

    @Column(name = "tenTL")
    private String tenTL;
}
