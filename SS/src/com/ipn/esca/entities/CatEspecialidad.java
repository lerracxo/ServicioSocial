package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_especialidad database table.
 * 
 */
@Entity
@Table(name="cat_especialidad")
@NamedQuery(name="CatEspecialidad.findAll", query="SELECT c FROM CatEspecialidad c")
public class CatEspecialidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_especialidad")
	private Integer idEspecialidad;

	private String nombre;

	//bi-directional many-to-one association to REspTipogrado
	@OneToMany(mappedBy="catEspecialidad")
	private List<REspTipogrado> REspTipogrados;

	//bi-directional many-to-one association to RProfEspecialidad
	@OneToMany(mappedBy="catEspecialidad")
	private List<RProfEspecialidad> RProfEspecialidads;

	public CatEspecialidad() {
	}

	public Integer getIdEspecialidad() {
		return this.idEspecialidad;
	}

	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<REspTipogrado> getREspTipogrados() {
		return this.REspTipogrados;
	}

	public void setREspTipogrados(List<REspTipogrado> REspTipogrados) {
		this.REspTipogrados = REspTipogrados;
	}

	public REspTipogrado addREspTipogrado(REspTipogrado REspTipogrado) {
		getREspTipogrados().add(REspTipogrado);
		REspTipogrado.setCatEspecialidad(this);

		return REspTipogrado;
	}

	public REspTipogrado removeREspTipogrado(REspTipogrado REspTipogrado) {
		getREspTipogrados().remove(REspTipogrado);
		REspTipogrado.setCatEspecialidad(null);

		return REspTipogrado;
	}

	public List<RProfEspecialidad> getRProfEspecialidads() {
		return this.RProfEspecialidads;
	}

	public void setRProfEspecialidads(List<RProfEspecialidad> RProfEspecialidads) {
		this.RProfEspecialidads = RProfEspecialidads;
	}

	public RProfEspecialidad addRProfEspecialidad(RProfEspecialidad RProfEspecialidad) {
		getRProfEspecialidads().add(RProfEspecialidad);
		RProfEspecialidad.setCatEspecialidad(this);

		return RProfEspecialidad;
	}

	public RProfEspecialidad removeRProfEspecialidad(RProfEspecialidad RProfEspecialidad) {
		getRProfEspecialidads().remove(RProfEspecialidad);
		RProfEspecialidad.setCatEspecialidad(null);

		return RProfEspecialidad;
	}

}