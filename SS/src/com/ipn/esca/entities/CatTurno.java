package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_turno database table.
 * 
 */
@Entity
@Table(name="cat_turno")
@NamedQuery(name="CatTurno.findAll", query="SELECT c FROM CatTurno c")
public class CatTurno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_turno")
	private Integer idTurno;

	private String turno;

	//bi-directional many-to-one association to RMateriaTurno
	@OneToMany(mappedBy="catTurno")
	private List<RMateriaTurno> RMateriaTurnos;

	public CatTurno() {
	}

	public Integer getIdTurno() {
		return this.idTurno;
	}

	public void setIdTurno(Integer idTurno) {
		this.idTurno = idTurno;
	}

	public String getTurno() {
		return this.turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public List<RMateriaTurno> getRMateriaTurnos() {
		return this.RMateriaTurnos;
	}

	public void setRMateriaTurnos(List<RMateriaTurno> RMateriaTurnos) {
		this.RMateriaTurnos = RMateriaTurnos;
	}

	public RMateriaTurno addRMateriaTurno(RMateriaTurno RMateriaTurno) {
		getRMateriaTurnos().add(RMateriaTurno);
		RMateriaTurno.setCatTurno(this);

		return RMateriaTurno;
	}

	public RMateriaTurno removeRMateriaTurno(RMateriaTurno RMateriaTurno) {
		getRMateriaTurnos().remove(RMateriaTurno);
		RMateriaTurno.setCatTurno(null);

		return RMateriaTurno;
	}

}