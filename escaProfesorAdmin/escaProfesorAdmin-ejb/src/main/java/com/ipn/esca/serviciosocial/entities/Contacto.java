package com.ipn.esca.serviciosocial.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the contacto database table.
 * 
 */
@Entity
@NamedQuery(name="Contacto.findAll", query="SELECT c FROM Contacto c")
public class Contacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_persona")
	private Integer idPersona;

	@Column(name="correo_elec")
	private String correoElec;

	private BigDecimal ext;

	@Column(name="tel_fijo")
	private BigDecimal telFijo;

	@Column(name="tel_movil")
	private BigDecimal telMovil;

	@Column(name="tel_trabajo")
	private BigDecimal telTrabajo;

	//bi-directional one-to-one association to Persona
	@OneToOne
	@PrimaryKeyJoinColumn(name="id_persona")
	private Persona persona;

	public Contacto() {
	}

	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getCorreoElec() {
		return this.correoElec;
	}

	public void setCorreoElec(String correoElec) {
		this.correoElec = correoElec;
	}

	public BigDecimal getExt() {
		return this.ext;
	}

	public void setExt(BigDecimal ext) {
		this.ext = ext;
	}

	public BigDecimal getTelFijo() {
		return this.telFijo;
	}

	public void setTelFijo(BigDecimal telFijo) {
		this.telFijo = telFijo;
	}

	public BigDecimal getTelMovil() {
		return this.telMovil;
	}

	public void setTelMovil(BigDecimal telMovil) {
		this.telMovil = telMovil;
	}

	public BigDecimal getTelTrabajo() {
		return this.telTrabajo;
	}

	public void setTelTrabajo(BigDecimal telTrabajo) {
		this.telTrabajo = telTrabajo;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}