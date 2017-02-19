package com.ipn.esca.serviciosocial.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the r_prof_materia database table.
 * 
 */
@Entity
@Table(name="r_prof_materia")
@NamedQuery(name="RProfMateria.findAll", query="SELECT r FROM RProfMateria r")
public class RProfMateria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_relacion")
	private Integer idRelacion;

	//bi-directional many-to-one association to CatMateria
	@ManyToOne
	@JoinColumn(name="id_materia")
	private CatMateria catMateria;

	//bi-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="id_profesor")
	private Profesor profesor;

	public RProfMateria() {
	}

	public Integer getIdRelacion() {
		return this.idRelacion;
	}

	public void setIdRelacion(Integer idRelacion) {
		this.idRelacion = idRelacion;
	}

	public CatMateria getCatMateria() {
		return this.catMateria;
	}

	public void setCatMateria(CatMateria catMateria) {
		this.catMateria = catMateria;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}