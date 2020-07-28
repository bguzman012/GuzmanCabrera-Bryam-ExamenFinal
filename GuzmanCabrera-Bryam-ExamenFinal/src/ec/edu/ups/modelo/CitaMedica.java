package ec.edu.ups.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CitaMedica
 *
 */
@Entity

public class CitaMedica implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String fecha;
	private String hora;
	private String sintomas;
	private String alergias;
	private String enfermedadePrevias;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "citaMedica")
	private SignoVital signoVital;
	@ManyToOne
	@JoinColumn
	private Paciente paciente;
	
	
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public CitaMedica() {
		super();
	}

	public CitaMedica(String fecha, String hora, String sintomas, String alergias, String enfermedadePrevias) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.sintomas = sintomas;
		this.alergias = alergias;
		this.enfermedadePrevias = enfermedadePrevias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getEnfermedadePrevias() {
		return enfermedadePrevias;
	}

	public void setEnfermedadePrevias(String enfermedadePrevias) {
		this.enfermedadePrevias = enfermedadePrevias;
	}

	public SignoVital getSignoVital() {
		return signoVital;
	}

	public void setSignoVital(SignoVital signoVital) {
		this.signoVital = signoVital;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alergias == null) ? 0 : alergias.hashCode());
		result = prime * result + ((enfermedadePrevias == null) ? 0 : enfermedadePrevias.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + id;
		result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
		result = prime * result + ((signoVital == null) ? 0 : signoVital.hashCode());
		result = prime * result + ((sintomas == null) ? 0 : sintomas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CitaMedica other = (CitaMedica) obj;
		if (alergias == null) {
			if (other.alergias != null)
				return false;
		} else if (!alergias.equals(other.alergias))
			return false;
		if (enfermedadePrevias == null) {
			if (other.enfermedadePrevias != null)
				return false;
		} else if (!enfermedadePrevias.equals(other.enfermedadePrevias))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (id != other.id)
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		if (signoVital == null) {
			if (other.signoVital != null)
				return false;
		} else if (!signoVital.equals(other.signoVital))
			return false;
		if (sintomas == null) {
			if (other.sintomas != null)
				return false;
		} else if (!sintomas.equals(other.sintomas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CitaMedica [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", sintomas=" + sintomas + ", alergias="
				+ alergias + ", enfermedadePrevias=" + enfermedadePrevias + ", signoVital=" + signoVital + ", paciente="
				+ paciente + "]";
	}
	
	
   
	
}
