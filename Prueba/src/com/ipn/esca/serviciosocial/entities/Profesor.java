package com.ipn.esca.serviciosocial.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the profesor database table.
 * 
 */
@Entity
@NamedQuery(name="Profesor.findAll", query="SELECT p FROM Profesor p")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_profesor")
	private Integer idProfesor;

	private String cedula;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_ingreso")
	private Date fecIngreso;

	private String rfc;

	//bi-directional one-to-one association to ExOposicion
	@OneToOne(mappedBy="profesor")
	private ExOposicion exOposicion;

	//bi-directional one-to-one association to Experiencia
	@OneToOne(mappedBy="profesor")
	private Experiencia experiencia;

	//bi-directional one-to-one association to Persona
	@OneToOne
	@JoinColumn(name="id_profesor")
	private Persona persona;

	//bi-directional many-to-one association to RProfCalif
	@OneToMany(mappedBy="profesor")
	private List<RProfCalif> RProfCalifs;

	//bi-directional many-to-one association to RProfCurso
	@OneToMany(mappedBy="profesor")
	private List<RProfCurso> RProfCursos;

	//bi-directional many-to-one association to RProfEspecialidad
	@OneToMany(mappedBy="profesor")
	private List<RProfEspecialidad> RProfEspecialidads;

	//bi-directional many-to-one association to RProfMateria
	@OneToMany(mappedBy="profesor")
	private List<RProfMateria> RProfMaterias;

	public Profesor() {
	}

	public Integer getIdProfesor() {
		return this.idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Date getFecIngreso() {
		return this.fecIngreso;
	}

	public void setFecIngreso(Date fecIngreso) {
		this.fecIngreso = fecIngreso;
	}

	public String getRfc() {
		return this.rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public ExOposicion getExOposicion() {
		return this.exOposicion;
	}

	public void setExOposicion(ExOposicion exOposicion) {
		this.exOposicion = exOposicion;
	}

	public Experiencia getExperiencia() {
		return this.experiencia;
	}

	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<RProfCalif> getRProfCalifs() {
		return this.RProfCalifs;
	}

	public void setRProfCalifs(List<RProfCalif> RProfCalifs) {
		this.RProfCalifs = RProfCalifs;
	}

	public RProfCalif addRProfCalif(RProfCalif RProfCalif) {
		getRProfCalifs().add(RProfCalif);
		RProfCalif.setProfesor(this);

		return RProfCalif;
	}

	public RProfCalif removeRProfCalif(RProfCalif RProfCalif) {
		getRProfCalifs().remove(RProfCalif);
		RProfCalif.setProfesor(null);

		return RProfCalif;
	}

	public List<RProfCurso> getRProfCursos() {
		return this.RProfCursos;
	}

	public void setRProfCursos(List<RProfCurso> RProfCursos) {
		this.RProfCursos = RProfCursos;
	}

	public RProfCurso addRProfCurso(RProfCurso RProfCurso) {
		getRProfCursos().add(RProfCurso);
		RProfCurso.setProfesor(this);

		return RProfCurso;
	}

	public RProfCurso removeRProfCurso(RProfCurso RProfCurso) {
		getRProfCursos().remove(RProfCurso);
		RProfCurso.setProfesor(null);

		return RProfCurso;
	}

	public List<RProfEspecialidad> getRProfEspecialidads() {
		return this.RProfEspecialidads;
	}

	public void setRProfEspecialidads(List<RProfEspecialidad> RProfEspecialidads) {
		this.RProfEspecialidads = RProfEspecialidads;
	}

	public RProfEspecialidad addRProfEspecialidad(RProfEspecialidad RProfEspecialidad) {
		getRProfEspecialidads().add(RProfEspecialidad);
		RProfEspecialidad.setProfesor(this);

		return RProfEspecialidad;
	}

	public RProfEspecialidad removeRProfEspecialidad(RProfEspecialidad RProfEspecialidad) {
		getRProfEspecialidads().remove(RProfEspecialidad);
		RProfEspecialidad.setProfesor(null);

		return RProfEspecialidad;
	}

	public List<RProfMateria> getRProfMaterias() {
		return this.RProfMaterias;
	}

	public void setRProfMaterias(List<RProfMateria> RProfMaterias) {
		this.RProfMaterias = RProfMaterias;
	}

	public RProfMateria addRProfMateria(RProfMateria RProfMateria) {
		getRProfMaterias().add(RProfMateria);
		RProfMateria.setProfesor(this);

		return RProfMateria;
	}

	public RProfMateria removeRProfMateria(RProfMateria RProfMateria) {
		getRProfMaterias().remove(RProfMateria);
		RProfMateria.setProfesor(null);

		return RProfMateria;
	}

}