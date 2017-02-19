package com.ipn.esca.serviciosocial.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_materia database table.
 * 
 */
@Entity
@Table(name="cat_materia")
@NamedQuery(name="CatMateria.findAll", query="SELECT c FROM CatMateria c")
public class CatMateria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_materia")
	private Integer idMateria;

	private String escuela;

	private String materia;

	//bi-directional many-to-one association to Grupo
	@ManyToOne
	@JoinColumn(name="id_grupo")
	private Grupo grupo;

	//bi-directional many-to-one association to PeriodoMateria
	@ManyToOne
	@JoinColumn(name="id_periodo")
	private PeriodoMateria periodoMateria;

	//bi-directional many-to-one association to RProfMateria
	@OneToMany(mappedBy="catMateria")
	private List<RProfMateria> RProfMaterias;

	public CatMateria() {
	}

	public Integer getIdMateria() {
		return this.idMateria;
	}

	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}

	public String getEscuela() {
		return this.escuela;
	}

	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}

	public String getMateria() {
		return this.materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public PeriodoMateria getPeriodoMateria() {
		return this.periodoMateria;
	}

	public void setPeriodoMateria(PeriodoMateria periodoMateria) {
		this.periodoMateria = periodoMateria;
	}

	public List<RProfMateria> getRProfMaterias() {
		return this.RProfMaterias;
	}

	public void setRProfMaterias(List<RProfMateria> RProfMaterias) {
		this.RProfMaterias = RProfMaterias;
	}

	public RProfMateria addRProfMateria(RProfMateria RProfMateria) {
		getRProfMaterias().add(RProfMateria);
		RProfMateria.setCatMateria(this);

		return RProfMateria;
	}

	public RProfMateria removeRProfMateria(RProfMateria RProfMateria) {
		getRProfMaterias().remove(RProfMateria);
		RProfMateria.setCatMateria(null);

		return RProfMateria;
	}

}