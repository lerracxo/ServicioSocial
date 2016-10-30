package com.ipn.esca.serviciosocial.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the r_prof_cursos database table.
 * 
 */
@Entity
@Table(name="r_prof_cursos")
@NamedQuery(name="RProfCurso.findAll", query="SELECT r FROM RProfCurso r")
public class RProfCurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_relacion")
	private Integer idRelacion;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="id_cursos")
	private Curso curso;

	//bi-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="id_profesor")
	private Profesor profesor;

	public RProfCurso() {
	}

	public Integer getIdRelacion() {
		return this.idRelacion;
	}

	public void setIdRelacion(Integer idRelacion) {
		this.idRelacion = idRelacion;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}