package com.restfull.oop.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;

//@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CTKMId implements Serializable {

    private static final Long SerialVersionUID = 1L;

    @Column(name = "maCTSP")
    private Long maCTSP;

    @Column(name = "maKM")
    private Long maKm;

}
