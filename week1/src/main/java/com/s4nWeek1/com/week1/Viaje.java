package com.s4nWeek1.com.week1;

import java.util.List;
 

public class Viaje {
	private Long id;
	private String destino;
    private String fecha;
    private Double Precio;
    private Double totalPrecio;
    
    
	public Viaje(Long id, String destino, Double Precio, String fecha) {
		this.id = id;
		this.destino = destino;
		this.fecha = fecha;
		this.Precio= Precio;
	}
	
    
    
    public Viaje() {

   	}
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Double getPrecio() {
		return Precio;
	}

	public void setPrecio(Double precio) {
		Precio = precio;
	}



	public Double getTotalPrecio() {
		return totalPrecio;
	}



	public void setTotalPrecio(Double totalPrecio) {
		this.totalPrecio = totalPrecio;
	}

	
    

    
    
    
    
    

}
