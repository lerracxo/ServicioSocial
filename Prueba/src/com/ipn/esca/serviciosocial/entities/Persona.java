package com.ipn.esca.serviciosocial.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_persona")
	private Integer idPersona;

	@Column(name="a_materno")
	private String aMaterno;

	@Column(name="a_paterno")
	private String aPaterno;

	private String nacionalidad;

	private String nombres;

	//bi-directional one-to-one association to CatUsuario
	@OneToOne(mappedBy="persona")
	private CatUsuario catUsuario;

	//bi-directional one-to-one association to Contacto
	@OneToOne(mappedBy="persona")
	private Contacto contacto;

	//bi-directional one-to-one association to Profesor
	@OneToOne(mappedBy="persona")
	private Profesor profesor;

	public Persona() {
	}

	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getaMaterno() {
		return this.aMaterno;
	}

	public void setaMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
	}

	public String getaPaterno() {
		return this.aPaterno;
	}

	public void setaPaterno(String aPaterno) {
		this.aPaterno = aPaterno;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public CatUsuario getCatUsuario() {
		return this.catUsuario;
	}

	public void setCatUsuario(CatUsuario catUsuario) {
		this.catUsuario = catUsuario;
	}

	public Contacto getContacto() {
		return this.contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}