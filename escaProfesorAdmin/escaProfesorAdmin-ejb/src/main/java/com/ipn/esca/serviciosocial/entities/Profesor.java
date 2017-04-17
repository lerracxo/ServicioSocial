package com.ipn.esca.serviciosocial.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the profesor database table.
 * 
 */
@Entity
@NamedQuery(name="Profesor.findAll", query="SELECT p FROM Profesor p")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_profesor")
	private Integer idProfesor;

	private String cedula;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_ingreso")
	private Date fecIngreso;

	private String rfc;


	//bi-directional one-to-one association to Persona
	@OneToOne
	@PrimaryKeyJoinColumn(name="id_profesor")
	private Persona persona;


	public Profesor() {
	}

	public Integer getIdProfesor() {
		return this.idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Date getFecIngreso() {
		return this.fecIngreso;
	}

	public void setFecIngreso(Date fecIngreso) {
		this.fecIngreso = fecIngreso;
	}

	public String getRfc() {
		return this.rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}