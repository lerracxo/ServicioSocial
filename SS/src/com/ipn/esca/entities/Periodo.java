package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the periodos database table.
 * 
 */
@Entity
@Table(name="periodos")
@NamedQuery(name="Periodo.findAll", query="SELECT p FROM Periodo p")
public class Periodo implements Serializable {
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

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="periodo")
	private List<Curso> cursos;

	public Periodo() {
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

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso addCurso(Curso curso) {
		getCursos().add(curso);
		curso.setPeriodo(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setPeriodo(null);

		return curso;
	}

}