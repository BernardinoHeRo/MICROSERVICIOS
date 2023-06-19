package com.fjavmv.cpestados.cpestados.modell;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "oaxacacp")
@Getter @Setter @ToString
public class CodigoPostal {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idcpoaxaca;

    private int d_codigo;

    private String d_ciudad;

    private String d_estado;

    private String d_mnpio;

    private String d_asenta;

}
