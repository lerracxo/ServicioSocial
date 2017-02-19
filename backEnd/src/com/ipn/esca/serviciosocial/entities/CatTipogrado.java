package com.ipn.esca.serviciosocial.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the cat_tipogrado database table.
 * 
 */
@Entity
@Table(name="cat_tipogrado")
@NamedQuery(name="CatTipogrado.findAll", query="SELECT c FROM CatTipogrado c")
public class CatTipogrado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipogrado")
	private Integer idTipogrado;

	private String descripcion;

	private BigDecimal prioridad;

	@Column(name="tipo_grado")
	private String tipoGrado;

	//bi-directional many-to-one association to REspTipogrado
	@OneToMany(mappedBy="catTipogrado")
	private List<REspTipogrado> REspTipogrados;

	public CatTipogrado() {
	}

	public Integer getIdTipogrado() {
		return this.idTipogrado;
	}

	public void setIdTipogrado(Integer idTipogrado) {
		this.idTipogrado = idTipogrado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrioridad() {
		return this.prioridad;
	}

	public void setPrioridad(BigDecimal prioridad) {
		this.prioridad = prioridad;
	}

	public String getTipoGrado() {
		return this.tipoGrado;
	}

	public void setTipoGrado(String tipoGrado) {
		this.tipoGrado = tipoGrado;
	}

	public List<REspTipogrado> getREspTipogrados() {
		return this.REspTipogrados;
	}

	public void setREspTipogrados(List<REspTipogrado> REspTipogrados) {
		this.REspTipogrados = REspTipogrados;
	}

	public REspTipogrado addREspTipogrado(REspTipogrado REspTipogrado) {
		getREspTipogrados().add(REspTipogrado);
		REspTipogrado.setCatTipogrado(this);

		return REspTipogrado;
	}

	public REspTipogrado removeREspTipogrado(REspTipogrado REspTipogrado) {
		getREspTipogrados().remove(REspTipogrado);
		REspTipogrado.setCatTipogrado(null);

		return REspTipogrado;
	}

}