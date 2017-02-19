package com.ipn.esca.serviciosocial.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cat_usuario database table.
 * 
 */
@Entity
@Table(name="cat_usuario")
@NamedQuery(name="CatUsuario.findAll", query="SELECT c FROM CatUsuario c")
public class CatUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_persona")
	private Integer idPersona;

	@Column(name="contra_cifrada")
	private String contraCifrada;

	private String usuario;

	//bi-directional many-to-one association to CatPerfil
	@ManyToOne
	@JoinColumn(name="id_perfil")
	private CatPerfil catPerfil;

	//bi-directional one-to-one association to Persona
	@OneToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	public CatUsuario() {
	}

	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getContraCifrada() {
		return this.contraCifrada;
	}

	public void setContraCifrada(String contraCifrada) {
		this.contraCifrada = contraCifrada;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public CatPerfil getCatPerfil() {
		return this.catPerfil;
	}

	public void setCatPerfil(CatPerfil catPerfil) {
		this.catPerfil = catPerfil;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}