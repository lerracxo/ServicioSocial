package com.ipn.esca.serviciosocial.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the experiencia database table.
 * 
 */
@Entity
@NamedQuery(name="Experiencia.findAll", query="SELECT e FROM Experiencia e")
public class Experiencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_profesor")
	private Integer idProfesor;

	private String experiencia;

	@Column(name="trabajos_inv")
	private String trabajosInv;

	//bi-directional one-to-one association to Profesor
	@OneToOne
	@JoinColumn(name="id_profesor")
	private Profesor profesor;

	public Experiencia() {
	}

	public Integer getIdProfesor() {
		return this.idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getExperiencia() {
		return this.experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String getTrabajosInv() {
		return this.trabajosInv;
	}

	public void setTrabajosInv(String trabajosInv) {
		this.trabajosInv = trabajosInv;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}