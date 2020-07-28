package ec.edu.ups.modelo;

import java.io.Serializable;
import ec.edu.ups.modelo.*;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: SignoVital
 *
 */
@Entity

public class SignoVital implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private double presion;
	private double frecuenciaCardiaca;
	private double frecuenciaRespiratoria;
	private double temperatura;
	private double saturacion;
	@OneToOne
	@JoinColumn
	private CitaMedica citaMedica;
	
	public SignoVital() {
		super();
	}

	public SignoVital(int id, double presion, double frecuenciaCardiaca, double frecuenciaRespiratoria,
			double temperatura, double saturacion) {
		super();
		this.id = id;
		this.presion = presion;
		this.frecuenciaCardiaca = frecuenciaCardiaca;
		this.frecuenciaRespiratoria = frecuenciaRespiratoria;
		this.temperatura = temperatura;
		this.saturacion = saturacion;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPresion() {
		return presion;
	}

	public void setPresion(double presion) {
		this.presion = presion;
	}

	public double getFrecuenciaCardiaca() {
		return frecuenciaCardiaca;
	}

	public void setFrecuenciaCardiaca(double frecuenciaCardiaca) {
		this.frecuenciaCardiaca = frecuenciaCardiaca;
	}

	public double getFrecuenciaRespiratoria() {
		return frecuenciaRespiratoria;
	}

	public void setFrecuenciaRespiratoria(double frecuenciaRespiratoria) {
		this.frecuenciaRespiratoria = frecuenciaRespiratoria;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getSaturacion() {
		return saturacion;
	}

	public void setSaturacion(double saturacion) {
		this.saturacion = saturacion;
	}

	public CitaMedica getCitaMedica() {
		return citaMedica;
	}

	public void setCitaMedica(CitaMedica citaMedica) {
		this.citaMedica = citaMedica;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citaMedica == null) ? 0 : citaMedica.hashCode());
		long temp;
		temp = Double.doubleToLongBits(frecuenciaCardiaca);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(frecuenciaRespiratoria);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		temp = Double.doubleToLongBits(presion);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(saturacion);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(temperatura);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		SignoVital other = (SignoVital) obj;
		if (citaMedica == null) {
			if (other.citaMedica != null)
				return false;
		} else if (!citaMedica.equals(other.citaMedica))
			return false;
		if (Double.doubleToLongBits(frecuenciaCardiaca) != Double.doubleToLongBits(other.frecuenciaCardiaca))
			return false;
		if (Double.doubleToLongBits(frecuenciaRespiratoria) != Double.doubleToLongBits(other.frecuenciaRespiratoria))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(presion) != Double.doubleToLongBits(other.presion))
			return false;
		if (Double.doubleToLongBits(saturacion) != Double.doubleToLongBits(other.saturacion))
			return false;
		if (Double.doubleToLongBits(temperatura) != Double.doubleToLongBits(other.temperatura))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SignoVital [id=" + id + ", presion=" + presion + ", frecuenciaCardiaca=" + frecuenciaCardiaca
				+ ", frecuenciaRespiratoria=" + frecuenciaRespiratoria + ", temperatura=" + temperatura
				+ ", saturacion=" + saturacion + ", citaMedica=" + citaMedica + "]";
	}
	
   
}
