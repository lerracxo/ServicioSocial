package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_eje database table.
 * 
 */
@Entity
@Table(name="cat_eje")
@NamedQuery(name="CatEje.findAll", query="SELECT c FROM CatEje c")
public class CatEje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_eje")
	private Integer idEje;

	private String descripcion;

	private String eje;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="catEje")
	private List<Curso> cursos;

	public CatEje() {
	}

	public Integer getIdEje() {
		return this.idEje;
	}

	public void setIdEje(Integer idEje) {
		this.idEje = idEje;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEje() {
		return this.eje;
	}

	public void setEje(String eje) {
		this.eje = eje;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso addCurso(Curso curso) {
		getCursos().add(curso);
		curso.setCatEje(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setCatEje(null);

		return curso;
	}

}