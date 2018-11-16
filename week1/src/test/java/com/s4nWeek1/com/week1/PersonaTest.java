package com.s4nWeek1.com.week1;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
public class PersonaTest {
	static Persona persona;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		persona = new Persona();
	}

	@Test
	public void agregarViajeTest() {
		persona.agregarViaje((long)0,"miami",20.0,"12/12/12");
		assertTrue("error. El el arraylist viajes se encuentra vacio despues de hacer la solicitud de ingresar un viaje"
				,persona.getViajes().size() > 0);
	}

}
