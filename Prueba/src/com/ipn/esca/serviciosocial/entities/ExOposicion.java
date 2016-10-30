package com.ipn.esca.serviciosocial.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ex_oposicion database table.
 * 
 */
@Entity
@Table(name="ex_oposicion")
@NamedQuery(name="ExOposicion.findAll", query="SELECT e FROM ExOposicion e")
public class ExOposicion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_profesor")
	private Integer idProfesor;

	@Column(name="exam_oposicion")
	private Boolean examOposicion;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_realizado")
	private Date fecRealizado;

	//bi-directional one-to-one association to Profesor
	@OneToOne
	@JoinColumn(name="id_profesor")
	private Profesor profesor;

	public ExOposicion() {
	}

	public Integer getIdProfesor() {
		return this.idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	public Boolean getExamOposicion() {
		return this.examOposicion;
	}

	public void setExamOposicion(Boolean examOposicion) {
		this.examOposicion = examOposicion;
	}

	public Date getFecRealizado() {
		return this.fecRealizado;
	}

	public void setFecRealizado(Date fecRealizado) {
		this.fecRealizado = fecRealizado;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}