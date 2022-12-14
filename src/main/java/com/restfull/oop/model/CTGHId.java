package com.restfull.oop.model;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CTGHId  implements Serializable {
    private static final Long SerialVersionUID = 1L;

    @Column(name = "idGio")
    private Long idGio;

    @Column(name = "maCTSP")
    private Long maCTSP;


}