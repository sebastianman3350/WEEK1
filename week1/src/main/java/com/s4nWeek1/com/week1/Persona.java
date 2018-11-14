package com.s4nWeek1.com.week1;


import java.util.ArrayList;
import java.util.List;

class Persona {
	private  List<Viaje> viajes = new ArrayList<>();
	private  Viaje viaje;
	
    private Long pid;
    private Long cedula;
    

	private String nombre;
    private String  genero;
    String String = new String();
    private Double totalPrecio;

    public Persona (Long pid, String nombre, String genero, Long cedula) {
        this.pid = pid;
        this.nombre = nombre;
        this.genero = genero;
        this.cedula = cedula;
        
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
    
    public void agregarViaje(Long id, String destino, Double precio, String fecha) {
    	
        this.viajes.add(new Viaje(id,  destino, precio,  fecha));
    }

    public List<Viaje> getViajes() {
        return viajes;
    }
     
}
