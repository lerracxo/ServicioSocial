package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the personas database table.
 * 
 */
@Entity
@Table(name="personas")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_personas")
	private Integer idPersonas;

	@Column(name="a_materno")
	private String aMaterno;

	@Column(name="a_paterno")
	private String aPaterno;

	private String nacionalidad;

	private String nombres;

	//bi-directional one-to-one association to Contacto
	@OneToOne(mappedBy="persona")
	private Contacto contacto;

	//bi-directional one-to-one association to CatUsuario
	@OneToOne
	@JoinColumn(name="id_personas")
	private CatUsuario catUsuario;

	//bi-directional one-to-one association to Profesore
	@OneToOne(mappedBy="persona")
	private Profesore profesore;

	public Persona() {
	}

	public Integer getIdPersonas() {
		return this.idPersonas;
	}

	public void setIdPersonas(Integer idPersonas) {
		this.idPersonas = idPersonas;
	}

	public String getAMaterno() {
		return this.aMaterno;
	}

	public void setAMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
	}

	public String getAPaterno() {
		return this.aPaterno;
	}

	public void setAPaterno(String aPaterno) {
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

	public Contacto getContacto() {
		return this.contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public CatUsuario getCatUsuario() {
		return this.catUsuario;
	}

	public void setCatUsuario(CatUsuario catUsuario) {
		this.catUsuario = catUsuario;
	}

	public Profesore getProfesore() {
		return this.profesore;
	}

	public void setProfesore(Profesore profesore) {
		this.profesore = profesore;
	}

}