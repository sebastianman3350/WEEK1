package com.s4nWeek1.com.week1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class qqq {

	static Aereolinea aereolinea ;
	static Persona persona ;
	static List<Persona> Personas;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		aereolinea = new Aereolinea();
		persona = new Persona();
		Personas = new ArrayList<>();
		
		aereolinea.agregarPersona("Sebastian", "masc", (long) 123);
		Personas.get(aereolinea.getIdByCedula(123))
		.agregarViaje((long)123, "miami", 22.0, "12/12/12");
		
	}

	@Test
	public void mostrarcantViajesPorIdTest() {
		
		long collect =
    			Personas.stream()
    					.filter(element -> element.getCedula().equals(123))
                        .map(x -> x.getViajes())  
                        .flatMap(x -> x.stream()).count();
		
		System.out.println("hay:" + collect);
		
		assertEquals(1,1);
		
	}
}
