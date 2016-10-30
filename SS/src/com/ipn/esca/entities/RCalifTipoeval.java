package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the r_calif_tipoeval database table.
 * 
 */
@Entity
@Table(name="r_calif_tipoeval")
@NamedQuery(name="RCalifTipoeval.findAll", query="SELECT r FROM RCalifTipoeval r")
public class RCalifTipoeval implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_relacion")
	private Integer idRelacion;

	//bi-directional many-to-one association to Calificacione
	@ManyToOne
	@JoinColumn(name="id_calificacion")
	private Calificacione calificacione;

	//bi-directional many-to-one association to CatTipoevaluacione
	@ManyToOne
	@JoinColumn(name="id_tipoevaluaciones")
	private CatTipoevaluacione catTipoevaluacione;

	public RCalifTipoeval() {
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

	public CatTipoevaluacione getCatTipoevaluacione() {
		return this.catTipoevaluacione;
	}

	public void setCatTipoevaluacione(CatTipoevaluacione catTipoevaluacione) {
		this.catTipoevaluacione = catTipoevaluacione;
	}

}