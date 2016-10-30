package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the r_materia_escuela database table.
 * 
 */
@Entity
@Table(name="r_materia_escuela")
@NamedQuery(name="RMateriaEscuela.findAll", query="SELECT r FROM RMateriaEscuela r")
public class RMateriaEscuela implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_relacion")
	private Integer idRelacion;

	//bi-directional many-to-one association to CatEscuela
	@ManyToOne
	@JoinColumn(name="id_escuela")
	private CatEscuela catEscuela;

	//bi-directional many-to-one association to CatMateria
	@ManyToOne
	@JoinColumn(name="id_materia")
	private CatMateria catMateria;

	public RMateriaEscuela() {
	}

	public Integer getIdRelacion() {
		return this.idRelacion;
	}

	public void setIdRelacion(Integer idRelacion) {
		this.idRelacion = idRelacion;
	}

	public CatEscuela getCatEscuela() {
		return this.catEscuela;
	}

	public void setCatEscuela(CatEscuela catEscuela) {
		this.catEscuela = catEscuela;
	}

	public CatMateria getCatMateria() {
		return this.catMateria;
	}

	public void setCatMateria(CatMateria catMateria) {
		this.catMateria = catMateria;
	}

}