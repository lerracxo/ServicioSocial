package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ex_oposicion database table.
 * 
 */
@Entity
@Table(name="ex_oposicion")
@NamedQuery(name="ExOposicion.findAll", query="SELECT e FROM ExOposicion e")
public class ExOposicion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_profesor")
	private Integer idProfesor;

	@Column(name="ex_oposicion")
	private Boolean exOposicion;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_realizado")
	private Date fecRealizado;

	//bi-directional one-to-one association to Profesore
	@OneToOne
	@JoinColumn(name="id_profesor")
	private Profesore profesore;

	public ExOposicion() {
	}

	public Integer getIdProfesor() {
		return this.idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	public Boolean getExOposicion() {
		return this.exOposicion;
	}

	public void setExOposicion(Boolean exOposicion) {
		this.exOposicion = exOposicion;
	}

	public Date getFecRealizado() {
		return this.fecRealizado;
	}

	public void setFecRealizado(Date fecRealizado) {
		this.fecRealizado = fecRealizado;
	}

	public Profesore getProfesore() {
		return this.profesore;
	}

	public void setProfesore(Profesore profesore) {
		this.profesore = profesore;
	}

}