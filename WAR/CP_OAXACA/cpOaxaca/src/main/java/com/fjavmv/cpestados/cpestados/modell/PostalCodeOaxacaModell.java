package com.fjavmv.cpestados.cpestados.modell;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "oaxacacps")
@Getter
@Setter
@ToString
public class PostalCodeOaxacaModell {
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idcpoaxaca;
	private int d_codigo;
	private String d_estado;
	private String d_mnpio;
	private String d_asenta;
}
