package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the profesores database table.
 * 
 */
@Entity
@Table(name="profesores")
@NamedQuery(name="Profesore.findAll", query="SELECT p FROM Profesore p")
public class Profesore implements Serializable {
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
	@OneToOne(mappedBy="profesore")
	private ExOposicion exOposicion;

	//bi-directional one-to-one association to Experiencia
	@OneToOne(mappedBy="profesore")
	private Experiencia experiencia;

	//bi-directional one-to-one association to Persona
	@OneToOne
	@JoinColumn(name="id_profesor")
	private Persona persona;

	//bi-directional many-to-one association to RProfCalif
	@OneToMany(mappedBy="profesore")
	private List<RProfCalif> RProfCalifs;

	//bi-directional many-to-one association to RProfCurso
	@OneToMany(mappedBy="profesore")
	private List<RProfCurso> RProfCursos;

	//bi-directional many-to-one association to RProfEspecialidad
	@OneToMany(mappedBy="profesore")
	private List<RProfEspecialidad> RProfEspecialidads;

	//bi-directional many-to-one association to RProfMateria
	@OneToMany(mappedBy="profesore")
	private List<RProfMateria> RProfMaterias;

	public Profesore() {
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
		RProfCalif.setProfesore(this);

		return RProfCalif;
	}

	public RProfCalif removeRProfCalif(RProfCalif RProfCalif) {
		getRProfCalifs().remove(RProfCalif);
		RProfCalif.setProfesore(null);

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
		RProfCurso.setProfesore(this);

		return RProfCurso;
	}

	public RProfCurso removeRProfCurso(RProfCurso RProfCurso) {
		getRProfCursos().remove(RProfCurso);
		RProfCurso.setProfesore(null);

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
		RProfEspecialidad.setProfesore(this);

		return RProfEspecialidad;
	}

	public RProfEspecialidad removeRProfEspecialidad(RProfEspecialidad RProfEspecialidad) {
		getRProfEspecialidads().remove(RProfEspecialidad);
		RProfEspecialidad.setProfesore(null);

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
		RProfMateria.setProfesore(this);

		return RProfMateria;
	}

	public RProfMateria removeRProfMateria(RProfMateria RProfMateria) {
		getRProfMaterias().remove(RProfMateria);
		RProfMateria.setProfesore(null);

		return RProfMateria;
	}

}