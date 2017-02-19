package com.ipn.esca.serviciosocial.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the r_esp_tipogrado database table.
 * 
 */
@Entity
@Table(name="r_esp_tipogrado")
@NamedQuery(name="REspTipogrado.findAll", query="SELECT r FROM REspTipogrado r")
public class REspTipogrado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_relacion")
	private Integer idRelacion;

	//bi-directional many-to-one association to CatEspecialidad
	@ManyToOne
	@JoinColumn(name="id_especialidad")
	private CatEspecialidad catEspecialidad;

	//bi-directional many-to-one association to CatTipogrado
	@ManyToOne
	@JoinColumn(name="id_tipogrado")
	private CatTipogrado catTipogrado;

	public REspTipogrado() {
	}

	public Integer getIdRelacion() {
		return this.idRelacion;
	}

	public void setIdRelacion(Integer idRelacion) {
		this.idRelacion = idRelacion;
	}

	public CatEspecialidad getCatEspecialidad() {
		return this.catEspecialidad;
	}

	public void setCatEspecialidad(CatEspecialidad catEspecialidad) {
		this.catEspecialidad = catEspecialidad;
	}

	public CatTipogrado getCatTipogrado() {
		return this.catTipogrado;
	}

	public void setCatTipogrado(CatTipogrado catTipogrado) {
		this.catTipogrado = catTipogrado;
	}

}