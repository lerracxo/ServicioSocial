package model;

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

	//bi-directional many-to-one association to RCursoTipocurso
	@OneToMany(mappedBy="catTipocurso")
	private List<RCursoTipocurso> RCursoTipocursos;

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

	public List<RCursoTipocurso> getRCursoTipocursos() {
		return this.RCursoTipocursos;
	}

	public void setRCursoTipocursos(List<RCursoTipocurso> RCursoTipocursos) {
		this.RCursoTipocursos = RCursoTipocursos;
	}

	public RCursoTipocurso addRCursoTipocurso(RCursoTipocurso RCursoTipocurso) {
		getRCursoTipocursos().add(RCursoTipocurso);
		RCursoTipocurso.setCatTipocurso(this);

		return RCursoTipocurso;
	}

	public RCursoTipocurso removeRCursoTipocurso(RCursoTipocurso RCursoTipocurso) {
		getRCursoTipocursos().remove(RCursoTipocurso);
		RCursoTipocurso.setCatTipocurso(null);

		return RCursoTipocurso;
	}

}