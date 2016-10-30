package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_escuela database table.
 * 
 */
@Entity
@Table(name="cat_escuela")
@NamedQuery(name="CatEscuela.findAll", query="SELECT c FROM CatEscuela c")
public class CatEscuela implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_escuela")
	private Integer idEscuela;

	private String escuela;

	private String institucion;

	//bi-directional many-to-one association to RMateriaEscuela
	@OneToMany(mappedBy="catEscuela")
	private List<RMateriaEscuela> RMateriaEscuelas;

	public CatEscuela() {
	}

	public Integer getIdEscuela() {
		return this.idEscuela;
	}

	public void setIdEscuela(Integer idEscuela) {
		this.idEscuela = idEscuela;
	}

	public String getEscuela() {
		return this.escuela;
	}

	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}

	public String getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public List<RMateriaEscuela> getRMateriaEscuelas() {
		return this.RMateriaEscuelas;
	}

	public void setRMateriaEscuelas(List<RMateriaEscuela> RMateriaEscuelas) {
		this.RMateriaEscuelas = RMateriaEscuelas;
	}

	public RMateriaEscuela addRMateriaEscuela(RMateriaEscuela RMateriaEscuela) {
		getRMateriaEscuelas().add(RMateriaEscuela);
		RMateriaEscuela.setCatEscuela(this);

		return RMateriaEscuela;
	}

	public RMateriaEscuela removeRMateriaEscuela(RMateriaEscuela RMateriaEscuela) {
		getRMateriaEscuelas().remove(RMateriaEscuela);
		RMateriaEscuela.setCatEscuela(null);

		return RMateriaEscuela;
	}

}