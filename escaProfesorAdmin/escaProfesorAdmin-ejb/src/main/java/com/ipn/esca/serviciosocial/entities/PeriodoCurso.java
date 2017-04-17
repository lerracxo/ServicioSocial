package com.ipn.esca.serviciosocial.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the periodo_curso database table.
 * 
 */
@Entity
@Table(name="periodo_curso")
@NamedQuery(name="PeriodoCurso.findAll", query="SELECT p FROM PeriodoCurso p")
public class PeriodoCurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_periodo")
	private Integer idPeriodo;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_fin")
	private Date fecFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_inicio")
	private Date fecInicio;

	private BigDecimal horas;

	//bi-directional many-to-one association to CatTipocurso
	@ManyToOne
	@JoinColumn(name="id_tipocurso")
	private CatTipocurso catTipocurso;

	public PeriodoCurso() {
	}

	public Integer getIdPeriodo() {
		return this.idPeriodo;
	}

	public void setIdPeriodo(Integer idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public Date getFecFin() {
		return this.fecFin;
	}

	public void setFecFin(Date fecFin) {
		this.fecFin = fecFin;
	}

	public Date getFecInicio() {
		return this.fecInicio;
	}

	public void setFecInicio(Date fecInicio) {
		this.fecInicio = fecInicio;
	}

	public BigDecimal getHoras() {
		return this.horas;
	}

	public void setHoras(BigDecimal horas) {
		this.horas = horas;
	}

	public CatTipocurso getCatTipocurso() {
		return this.catTipocurso;
	}

	public void setCatTipocurso(CatTipocurso catTipocurso) {
		this.catTipocurso = catTipocurso;
	}

}