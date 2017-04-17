package com.ipn.esca.serviciosocial.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the periodo_materia database table.
 * 
 */
@Entity
@Table(name="periodo_materia")
@NamedQuery(name="PeriodoMateria.findAll", query="SELECT p FROM PeriodoMateria p")
public class PeriodoMateria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_periodo")
	private Integer idPeriodo;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_fin")
	private Date fecFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_inicio")
	private Date fecInicio;

	//bi-directional many-to-one association to CatMateria
	@OneToMany(mappedBy="periodoMateria")
	private List<CatMateria> catMaterias;

	public PeriodoMateria() {
	}

	public Integer getIdPeriodo() {
		return this.idPeriodo;
	}

	public void setIdPeriodo(Integer idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public Date getFecFin() {
		return this.fecFin;
	}

	public void setFecFin(Date fecFin) {
		this.fecFin = fecFin;
	}

	public Date getFecInicio() {
		return this.fecInicio;
	}

	public void setFecInicio(Date fecInicio) {
		this.fecInicio = fecInicio;
	}

	public List<CatMateria> getCatMaterias() {
		return this.catMaterias;
	}

	public void setCatMaterias(List<CatMateria> catMaterias) {
		this.catMaterias = catMaterias;
	}

	public CatMateria addCatMateria(CatMateria catMateria) {
		getCatMaterias().add(catMateria);
		catMateria.setPeriodoMateria(this);

		return catMateria;
	}

	public CatMateria removeCatMateria(CatMateria catMateria) {
		getCatMaterias().remove(catMateria);
		catMateria.setPeriodoMateria(null);

		return catMateria;
	}

}