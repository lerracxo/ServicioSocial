package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the calificaciones database table.
 * 
 */
@Entity
@Table(name="calificaciones")
@NamedQuery(name="Calificacione.findAll", query="SELECT c FROM Calificacione c")
public class Calificacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_calificacion")
	private Integer idCalificacion;

	private BigDecimal calificacion;

	//bi-directional many-to-one association to RCalifTipoeval
	@OneToMany(mappedBy="calificacione")
	private List<RCalifTipoeval> RCalifTipoevals;

	//bi-directional many-to-one association to RProfCalif
	@OneToMany(mappedBy="calificacione")
	private List<RProfCalif> RProfCalifs;

	public Calificacione() {
	}

	public Integer getIdCalificacion() {
		return this.idCalificacion;
	}

	public void setIdCalificacion(Integer idCalificacion) {
		this.idCalificacion = idCalificacion;
	}

	public BigDecimal getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(BigDecimal calificacion) {
		this.calificacion = calificacion;
	}

	public List<RCalifTipoeval> getRCalifTipoevals() {
		return this.RCalifTipoevals;
	}

	public void setRCalifTipoevals(List<RCalifTipoeval> RCalifTipoevals) {
		this.RCalifTipoevals = RCalifTipoevals;
	}

	public RCalifTipoeval addRCalifTipoeval(RCalifTipoeval RCalifTipoeval) {
		getRCalifTipoevals().add(RCalifTipoeval);
		RCalifTipoeval.setCalificacione(this);

		return RCalifTipoeval;
	}

	public RCalifTipoeval removeRCalifTipoeval(RCalifTipoeval RCalifTipoeval) {
		getRCalifTipoevals().remove(RCalifTipoeval);
		RCalifTipoeval.setCalificacione(null);

		return RCalifTipoeval;
	}

	public List<RProfCalif> getRProfCalifs() {
		return this.RProfCalifs;
	}

	public void setRProfCalifs(List<RProfCalif> RProfCalifs) {
		this.RProfCalifs = RProfCalifs;
	}

	public RProfCalif addRProfCalif(RProfCalif RProfCalif) {
		getRProfCalifs().add(RProfCalif);
		RProfCalif.setCalificacione(this);

		return RProfCalif;
	}

	public RProfCalif removeRProfCalif(RProfCalif RProfCalif) {
		getRProfCalifs().remove(RProfCalif);
		RProfCalif.setCalificacione(null);

		return RProfCalif;
	}

}