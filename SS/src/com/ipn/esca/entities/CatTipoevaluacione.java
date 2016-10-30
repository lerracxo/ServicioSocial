package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_tipoevaluaciones database table.
 * 
 */
@Entity
@Table(name="cat_tipoevaluaciones")
@NamedQuery(name="CatTipoevaluacione.findAll", query="SELECT c FROM CatTipoevaluacione c")
public class CatTipoevaluacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipoevaluaciones")
	private Integer idTipoevaluaciones;

	private String descripcion;

	@Column(name="tipo_evaluacion")
	private String tipoEvaluacion;

	//bi-directional many-to-one association to RCalifTipoeval
	@OneToMany(mappedBy="catTipoevaluacione")
	private List<RCalifTipoeval> RCalifTipoevals;

	public CatTipoevaluacione() {
	}

	public Integer getIdTipoevaluaciones() {
		return this.idTipoevaluaciones;
	}

	public void setIdTipoevaluaciones(Integer idTipoevaluaciones) {
		this.idTipoevaluaciones = idTipoevaluaciones;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoEvaluacion() {
		return this.tipoEvaluacion;
	}

	public void setTipoEvaluacion(String tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}

	public List<RCalifTipoeval> getRCalifTipoevals() {
		return this.RCalifTipoevals;
	}

	public void setRCalifTipoevals(List<RCalifTipoeval> RCalifTipoevals) {
		this.RCalifTipoevals = RCalifTipoevals;
	}

	public RCalifTipoeval addRCalifTipoeval(RCalifTipoeval RCalifTipoeval) {
		getRCalifTipoevals().add(RCalifTipoeval);
		RCalifTipoeval.setCatTipoevaluacione(this);

		return RCalifTipoeval;
	}

	public RCalifTipoeval removeRCalifTipoeval(RCalifTipoeval RCalifTipoeval) {
		getRCalifTipoevals().remove(RCalifTipoeval);
		RCalifTipoeval.setCatTipoevaluacione(null);

		return RCalifTipoeval;
	}

}