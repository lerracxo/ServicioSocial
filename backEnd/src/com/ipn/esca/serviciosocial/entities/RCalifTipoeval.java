package com.ipn.esca.serviciosocial.entities;

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

	//bi-directional many-to-one association to Calificacion
	@ManyToOne
	@JoinColumn(name="id_calificacion")
	private Calificacion calificacion;

	//bi-directional many-to-one association to CatTipoevaluacion
	@ManyToOne
	@JoinColumn(name="id_tipoevaluaciones")
	private CatTipoevaluacion catTipoevaluacion;

	public RCalifTipoeval() {
	}

	public Integer getIdRelacion() {
		return this.idRelacion;
	}

	public void setIdRelacion(Integer idRelacion) {
		this.idRelacion = idRelacion;
	}

	public Calificacion getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}

	public CatTipoevaluacion getCatTipoevaluacion() {
		return this.catTipoevaluacion;
	}

	public void setCatTipoevaluacion(CatTipoevaluacion catTipoevaluacion) {
		this.catTipoevaluacion = catTipoevaluacion;
	}

}