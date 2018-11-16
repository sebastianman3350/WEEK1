/*
 * clase que tiene los atributos de las
 * personas/clientes de la aereolinea
 */


package com.s4nWeek1.com.week1;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Persona {
	private  List<Viaje> viajes = new ArrayList<>();
    private Long pid;
    private Long cedula;
	private Long telefono;
	
	//datos Opcionales de Persona
    private Optional<String> educacion;
    private Optional<String> estadoCivil;
    private Optional<Integer> cantHijos;
    private Optional<List<String>> nombreHijos;
    
    private String nombre;
    private String  genero;
    String String = new String();

    public Persona (Long pid, String nombre, String genero, Long cedula,
    		Long telefono,Optional<String> educacion,
    		Optional<String> estadoCivil,Optional<Integer> cantHijos,
    		Optional<List<String>> nombreHijos) {
    	
        this.pid = pid;
        this.nombre = nombre;
        this.genero = genero;
        this.cedula = cedula;
        this.telefono = telefono;
        this.educacion = educacion;
        this.estadoCivil = estadoCivil;
        this.cantHijos = cantHijos;
        this.nombreHijos = nombreHijos;
        
    }
    
    public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public Optional<String> geteducacion() {
		return educacion;
	}

	public void seteducacion(Optional<String> educacion) {
		this.educacion = educacion;
	}

	public Optional<String> getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(Optional<String> estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Optional<Integer> getCantHijos() {
		return cantHijos;
	}

	public void setCantHijos(Optional<Integer> cantHijos) {
		this.cantHijos = cantHijos;
	}

	public Optional<List<String>> getNombreHijos() {
		return nombreHijos;
	}

	public void setNombreHijos(Optional<List<String>> nombreHijos) {
		this.nombreHijos = nombreHijos;
	}
    

	
    
    public Long getCedula() {
		return cedula;
	}


	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}
    
    public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getgenero() {
		return genero;
	}

	public void setgenero(String genero) {
		this.genero = genero;
	}

	public Persona () {       
    }
    
  
    public String getnombre() {
        return nombre;
    }

   
    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
    
//    Permite agregar un viaje a la respectiva persona/cliente
    public void agregarViaje(Long id, String destino, Double precio, String fecha) {
    	
        this.viajes.add(new Viaje(id,  destino, precio,  fecha));
    }

//   Retorna la lista de viajes    
    public List<Viaje> getViajes() {
        return viajes;
    }
     
}
