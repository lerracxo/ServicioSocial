package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the r_curso_tipocurso database table.
 * 
 */
@Entity
@Table(name="r_curso_tipocurso")
@NamedQuery(name="RCursoTipocurso.findAll", query="SELECT r FROM RCursoTipocurso r")
public class RCursoTipocurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_relacion")
	private Integer idRelacion;

	//bi-directional many-to-one association to CatTipocurso
	@ManyToOne
	@JoinColumn(name="id_tipocurso")
	private CatTipocurso catTipocurso;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="id_cursos")
	private Curso curso;

	public RCursoTipocurso() {
	}

	public Integer getIdRelacion() {
		return this.idRelacion;
	}

	public void setIdRelacion(Integer idRelacion) {
		this.idRelacion = idRelacion;
	}

	public CatTipocurso getCatTipocurso() {
		return this.catTipocurso;
	}

	public void setCatTipocurso(CatTipocurso catTipocurso) {
		this.catTipocurso = catTipocurso;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}