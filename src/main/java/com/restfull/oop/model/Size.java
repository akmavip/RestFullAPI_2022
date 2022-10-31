package com.restfull.oop.model;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "Size")
@Data
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maSize")
    private int maSize;

    @Column(name = "tenSize")
    private String tenSize;
}
