package com.ipn.esca.serviciosocial.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cursos database table.
 * 
 */
@Entity
@Table(name="cursos")
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cursos")
	private Integer idCursos;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to CatEje
	@ManyToOne
	@JoinColumn(name="id_eje")
	private CatEje catEje;

	//bi-directional many-to-one association to CatTipocurso
	@ManyToOne
	@JoinColumn(name="id_tipocurso")
	private CatTipocurso catTipocurso;

	//bi-directional many-to-one association to RProfCurso
	@OneToMany(mappedBy="curso")
	private List<RProfCurso> RProfCursos;

	public Curso() {
	}

	public Integer getIdCursos() {
		return this.idCursos;
	}

	public void setIdCursos(Integer idCursos) {
		this.idCursos = idCursos;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CatEje getCatEje() {
		return this.catEje;
	}

	public void setCatEje(CatEje catEje) {
		this.catEje = catEje;
	}

	public CatTipocurso getCatTipocurso() {
		return this.catTipocurso;
	}

	public void setCatTipocurso(CatTipocurso catTipocurso) {
		this.catTipocurso = catTipocurso;
	}

	public List<RProfCurso> getRProfCursos() {
		return this.RProfCursos;
	}

	public void setRProfCursos(List<RProfCurso> RProfCursos) {
		this.RProfCursos = RProfCursos;
	}

	public RProfCurso addRProfCurso(RProfCurso RProfCurso) {
		getRProfCursos().add(RProfCurso);
		RProfCurso.setCurso(this);

		return RProfCurso;
	}

	public RProfCurso removeRProfCurso(RProfCurso RProfCurso) {
		getRProfCursos().remove(RProfCurso);
		RProfCurso.setCurso(null);

		return RProfCurso;
	}

}