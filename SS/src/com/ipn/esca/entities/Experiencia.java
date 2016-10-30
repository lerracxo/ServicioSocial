package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the experiencia database table.
 * 
 */
@Entity
@NamedQuery(name="Experiencia.findAll", query="SELECT e FROM Experiencia e")
public class Experiencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_profesor")
	private Integer idProfesor;

	private String experiencia;

	@Column(name="trabajos_inv")
	private String trabajosInv;

	//bi-directional one-to-one association to Profesore
	@OneToOne
	@JoinColumn(name="id_profesor")
	private Profesore profesore;

	public Experiencia() {
	}

	public Integer getIdProfesor() {
		return this.idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getExperiencia() {
		return this.experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String getTrabajosInv() {
		return this.trabajosInv;
	}

	public void setTrabajosInv(String trabajosInv) {
		this.trabajosInv = trabajosInv;
	}

	public Profesore getProfesore() {
		return this.profesore;
	}

	public void setProfesore(Profesore profesore) {
		this.profesore = profesore;
	}

}