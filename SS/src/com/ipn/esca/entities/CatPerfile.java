package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_perfiles database table.
 * 
 */
@Entity
@Table(name="cat_perfiles")
@NamedQuery(name="CatPerfile.findAll", query="SELECT c FROM CatPerfile c")
public class CatPerfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_perfil")
	private Integer idPerfil;

	private String descripcion;

	private String perfil;

	//bi-directional many-to-one association to CatUsuario
	@OneToMany(mappedBy="catPerfile")
	private List<CatUsuario> catUsuarios;

	public CatPerfile() {
	}

	public Integer getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPerfil() {
		return this.perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public List<CatUsuario> getCatUsuarios() {
		return this.catUsuarios;
	}

	public void setCatUsuarios(List<CatUsuario> catUsuarios) {
		this.catUsuarios = catUsuarios;
	}

	public CatUsuario addCatUsuario(CatUsuario catUsuario) {
		getCatUsuarios().add(catUsuario);
		catUsuario.setCatPerfile(this);

		return catUsuario;
	}

	public CatUsuario removeCatUsuario(CatUsuario catUsuario) {
		getCatUsuarios().remove(catUsuario);
		catUsuario.setCatPerfile(null);

		return catUsuario;
	}

}