package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ec.edu.ups.ejb.CitaFacade;
import ec.edu.ups.ejb.PacienteFacade;
import ec.edu.ups.modelo.*;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class CitaBean implements Serializable {
	
	@EJB
	private CitaFacade ejbCita;
	@EJB
	private PacienteFacade ejbPaciente;
	private String fecha;
	private String hora;
	private String sintomas;
	private String alergias;
	private String enfermedadesPrevias;
	private String cedula;
	private List<CitaMedica> listarCitas;
	
	@PostConstruct
	public void init() {
		this.setListarCitas(ejbCita.findAll());
	}
	
	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public List<Paciente> getPaciente() {
		return paciente;
	}


	public void setPaciente(List<Paciente> paciente) {
		this.paciente = paciente;
	}

	private List<Paciente> paciente;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public CitaFacade getEjbCita() {
		return ejbCita;
	}


	public void setEjbCita(CitaFacade ejbCita) {
		this.ejbCita = ejbCita;
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


	public String getEnfermedadesPrevias() {
		return enfermedadesPrevias;
	}


	public void setEnfermedadesPrevias(String enfermedadesPrevias) {
		this.enfermedadesPrevias = enfermedadesPrevias;
	}
	
	public String add() {
		boolean ok = false;
		FacesContext context = FacesContext.getCurrentInstance();
		String nav = null;
		List<CitaMedica> citas = null;
		citas = ejbCita.findAll();
		for (CitaMedica citaMedica : citas) {
			if (this.fecha.equals(citaMedica.getFecha()) && this.hora.equals(citaMedica.getHora())){
				ok = true;
			}
		}
		
		if(ok) {
			context.addMessage("mi_form", new FacesMessage("Horario no disponible"));
		}else {
			CitaMedica cita = new CitaMedica(this.fecha, this.hora, this.sintomas, this.alergias, this.enfermedadesPrevias);
			Paciente paciente = ejbPaciente.find(this.cedula);
			System.out.println(paciente);
			cita.setPaciente(paciente);
			ejbCita.create(cita);
			this.setListarCitas(ejbCita.findAll());
			
			
		}
		return null;
		
				
	}
	
	public String buscarPaciente() {
		System.out.println(this.cedula);
		this.paciente = ejbPaciente.readPacienteByCedula(this.cedula);
		System.out.println(this.paciente);
		return null;
	}

	public List<CitaMedica> getListarCitas() {
		return listarCitas;
	}

	public void setListarCitas(List<CitaMedica> listarCitas) {
		this.listarCitas = listarCitas;
	}

}
