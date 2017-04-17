package com.ipn.esca.serviciosocial.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the grupo database table.
 * 
 */
@Entity
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_grupo")
	private Integer idGrupo;

	private String grupo;

	//bi-directional many-to-one association to CatMateria
	@OneToMany(mappedBy="grupo")
	private List<CatMateria> catMaterias;

	public Grupo() {
	}

	public Integer getIdGrupo() {
		return this.idGrupo;
	}

	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public List<CatMateria> getCatMaterias() {
		return this.catMaterias;
	}

	public void setCatMaterias(List<CatMateria> catMaterias) {
		this.catMaterias = catMaterias;
	}

	public CatMateria addCatMateria(CatMateria catMateria) {
		getCatMaterias().add(catMateria);
		catMateria.setGrupo(this);

		return catMateria;
	}

	public CatMateria removeCatMateria(CatMateria catMateria) {
		getCatMaterias().remove(catMateria);
		catMateria.setGrupo(null);

		return catMateria;
	}

}