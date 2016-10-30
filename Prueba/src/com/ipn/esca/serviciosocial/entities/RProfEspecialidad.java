package com.ipn.esca.serviciosocial.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the r_prof_especialidad database table.
 * 
 */
@Entity
@Table(name="r_prof_especialidad")
@NamedQuery(name="RProfEspecialidad.findAll", query="SELECT r FROM RProfEspecialidad r")
public class RProfEspecialidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_relacion")
	private Integer idRelacion;

	//bi-directional many-to-one association to CatEspecialidad
	@ManyToOne
	@JoinColumn(name="id_especialidad")
	private CatEspecialidad catEspecialidad;

	//bi-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="id_profesor")
	private Profesor profesor;

	public RProfEspecialidad() {
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

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}