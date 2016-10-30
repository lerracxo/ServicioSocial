package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_materias database table.
 * 
 */
@Entity
@Table(name="cat_materias")
@NamedQuery(name="CatMateria.findAll", query="SELECT c FROM CatMateria c")
public class CatMateria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_materia")
	private Integer idMateria;

	private String materia;

	//bi-directional many-to-one association to RMateriaEscuela
	@OneToMany(mappedBy="catMateria")
	private List<RMateriaEscuela> RMateriaEscuelas;

	//bi-directional many-to-one association to RMateriaTurno
	@OneToMany(mappedBy="catMateria")
	private List<RMateriaTurno> RMateriaTurnos;

	//bi-directional many-to-one association to RProfMateria
	@OneToMany(mappedBy="catMateria")
	private List<RProfMateria> RProfMaterias;

	public CatMateria() {
	}

	public Integer getIdMateria() {
		return this.idMateria;
	}

	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}

	public String getMateria() {
		return this.materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public List<RMateriaEscuela> getRMateriaEscuelas() {
		return this.RMateriaEscuelas;
	}

	public void setRMateriaEscuelas(List<RMateriaEscuela> RMateriaEscuelas) {
		this.RMateriaEscuelas = RMateriaEscuelas;
	}

	public RMateriaEscuela addRMateriaEscuela(RMateriaEscuela RMateriaEscuela) {
		getRMateriaEscuelas().add(RMateriaEscuela);
		RMateriaEscuela.setCatMateria(this);

		return RMateriaEscuela;
	}

	public RMateriaEscuela removeRMateriaEscuela(RMateriaEscuela RMateriaEscuela) {
		getRMateriaEscuelas().remove(RMateriaEscuela);
		RMateriaEscuela.setCatMateria(null);

		return RMateriaEscuela;
	}

	public List<RMateriaTurno> getRMateriaTurnos() {
		return this.RMateriaTurnos;
	}

	public void setRMateriaTurnos(List<RMateriaTurno> RMateriaTurnos) {
		this.RMateriaTurnos = RMateriaTurnos;
	}

	public RMateriaTurno addRMateriaTurno(RMateriaTurno RMateriaTurno) {
		getRMateriaTurnos().add(RMateriaTurno);
		RMateriaTurno.setCatMateria(this);

		return RMateriaTurno;
	}

	public RMateriaTurno removeRMateriaTurno(RMateriaTurno RMateriaTurno) {
		getRMateriaTurnos().remove(RMateriaTurno);
		RMateriaTurno.setCatMateria(null);

		return RMateriaTurno;
	}

	public List<RProfMateria> getRProfMaterias() {
		return this.RProfMaterias;
	}

	public void setRProfMaterias(List<RProfMateria> RProfMaterias) {
		this.RProfMaterias = RProfMaterias;
	}

	public RProfMateria addRProfMateria(RProfMateria RProfMateria) {
		getRProfMaterias().add(RProfMateria);
		RProfMateria.setCatMateria(this);

		return RProfMateria;
	}

	public RProfMateria removeRProfMateria(RProfMateria RProfMateria) {
		getRProfMaterias().remove(RProfMateria);
		RProfMateria.setCatMateria(null);

		return RProfMateria;
	}

}