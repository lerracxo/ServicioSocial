package com.ipn.esca.serviciosocial.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_tipocurso database table.
 * 
 */
@Entity
@Table(name="cat_tipocurso")
@NamedQuery(name="CatTipocurso.findAll", query="SELECT c FROM CatTipocurso c")
public class CatTipocurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipocurso")
	private Integer idTipocurso;

	private String descripcion;

	@Column(name="tipo_curso")
	private String tipoCurso;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="catTipocurso")
	private List<Curso> cursos;

	//bi-directional many-to-one association to PeriodoCurso
	@OneToMany(mappedBy="catTipocurso")
	private List<PeriodoCurso> periodoCursos;

	public CatTipocurso() {
	}

	public Integer getIdTipocurso() {
		return this.idTipocurso;
	}

	public void setIdTipocurso(Integer idTipocurso) {
		this.idTipocurso = idTipocurso;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoCurso() {
		return this.tipoCurso;
	}

	public void setTipoCurso(String tipoCurso) {
		this.tipoCurso = tipoCurso;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso addCurso(Curso curso) {
		getCursos().add(curso);
		curso.setCatTipocurso(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setCatTipocurso(null);

		return curso;
	}

	public List<PeriodoCurso> getPeriodoCursos() {
		return this.periodoCursos;
	}

	public void setPeriodoCursos(List<PeriodoCurso> periodoCursos) {
		this.periodoCursos = periodoCursos;
	}

	public PeriodoCurso addPeriodoCurso(PeriodoCurso periodoCurso) {
		getPeriodoCursos().add(periodoCurso);
		periodoCurso.setCatTipocurso(this);

		return periodoCurso;
	}

	public PeriodoCurso removePeriodoCurso(PeriodoCurso periodoCurso) {
		getPeriodoCursos().remove(periodoCurso);
		periodoCurso.setCatTipocurso(null);

		return periodoCurso;
	}

}