package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cat_usuarios database table.
 * 
 */
@Entity
@Table(name="cat_usuarios")
@NamedQuery(name="CatUsuario.findAll", query="SELECT c FROM CatUsuario c")
public class CatUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_personas")
	private Integer idPersonas;

	@Column(name="contra_cifrada")
	private String contraCifrada;

	private String usuario;

	//bi-directional many-to-one association to CatPerfile
	@ManyToOne
	@JoinColumn(name="id_perfil")
	private CatPerfile catPerfile;

	//bi-directional one-to-one association to Persona
	@OneToOne(mappedBy="catUsuario")
	private Persona persona;

	public CatUsuario() {
	}

	public Integer getIdPersonas() {
		return this.idPersonas;
	}

	public void setIdPersonas(Integer idPersonas) {
		this.idPersonas = idPersonas;
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

	public CatPerfile getCatPerfile() {
		return this.catPerfile;
	}

	public void setCatPerfile(CatPerfile catPerfile) {
		this.catPerfile = catPerfile;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}