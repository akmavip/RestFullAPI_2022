package com.restfull.oop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Quyen")
@Data
public class Quyen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maQuyen")
    private Long maQuyen;

    @Column(name = "tenQuyen")
    private String tenQuyen;

    @JsonIgnore
    @OneToMany(mappedBy = "quyen", fetch = FetchType.EAGER)
    List<TaiKhoan> taiKhoans;
}
