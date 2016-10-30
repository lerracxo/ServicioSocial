package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the r_materia_turno database table.
 * 
 */
@Entity
@Table(name="r_materia_turno")
@NamedQuery(name="RMateriaTurno.findAll", query="SELECT r FROM RMateriaTurno r")
public class RMateriaTurno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_relacion")
	private Integer idRelacion;

	//bi-directional many-to-one association to CatMateria
	@ManyToOne
	@JoinColumn(name="id_materia")
	private CatMateria catMateria;

	//bi-directional many-to-one association to CatTurno
	@ManyToOne
	@JoinColumn(name="id_turno")
	private CatTurno catTurno;

	public RMateriaTurno() {
	}

	public Integer getIdRelacion() {
		return this.idRelacion;
	}

	public void setIdRelacion(Integer idRelacion) {
		this.idRelacion = idRelacion;
	}

	public CatMateria getCatMateria() {
		return this.catMateria;
	}

	public void setCatMateria(CatMateria catMateria) {
		this.catMateria = catMateria;
	}

	public CatTurno getCatTurno() {
		return this.catTurno;
	}

	public void setCatTurno(CatTurno catTurno) {
		this.catTurno = catTurno;
	}

}