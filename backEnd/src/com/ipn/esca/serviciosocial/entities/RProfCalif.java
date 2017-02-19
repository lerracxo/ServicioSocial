package com.ipn.esca.serviciosocial.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the r_prof_calif database table.
 * 
 */
@Entity
@Table(name="r_prof_calif")
@NamedQuery(name="RProfCalif.findAll", query="SELECT r FROM RProfCalif r")
public class RProfCalif implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_relacion")
	private Integer idRelacion;

	//bi-directional many-to-one association to Calificacion
	@ManyToOne
	@JoinColumn(name="id_calificacion")
	private Calificacion calificacion;

	//bi-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="id_profesor")
	private Profesor profesor;

	public RProfCalif() {
	}

	public Integer getIdRelacion() {
		return this.idRelacion;
	}

	public void setIdRelacion(Integer idRelacion) {
		this.idRelacion = idRelacion;
	}

	public Calificacion getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}