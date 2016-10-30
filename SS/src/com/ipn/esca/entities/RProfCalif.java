package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the r_prof_calif database table.
 * 
 */
@Entity
@Table(name="r_prof_calif")
@NamedQuery(name="RProfCalif.findAll", query="SELECT r FROM RProfCalif r")
public class RProfCalif implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_relacion")
	private Integer idRelacion;

	//bi-directional many-to-one association to Calificacione
	@ManyToOne
	@JoinColumn(name="id_calificacion")
	private Calificacione calificacione;

	//bi-directional many-to-one association to Profesore
	@ManyToOne
	@JoinColumn(name="id_profesor")
	private Profesore profesore;

	public RProfCalif() {
	}

	public Integer getIdRelacion() {
		return this.idRelacion;
	}

	public void setIdRelacion(Integer idRelacion) {
		this.idRelacion = idRelacion;
	}

	public Calificacione getCalificacione() {
		return this.calificacione;
	}

	public void setCalificacione(Calificacione calificacione) {
		this.calificacione = calificacione;
	}

	public Profesore getProfesore() {
		return this.profesore;
	}

	public void setProfesore(Profesore profesore) {
		this.profesore = profesore;
	}

}