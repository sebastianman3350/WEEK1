package com.s4nWeek1.com.week1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.Test;

public class AereolineaOptionalTest {

	 static Aereolinea aereolinea;
	 static Persona persona;
	 static List < Persona > Personas;

	 @BeforeClass
	 public static void setUpBeforeClass() throws Exception {
	  aereolinea = new Aereolinea();
	  persona = new Persona();
	  Personas = new ArrayList <> ();

	  aereolinea.agregarPersona("Sebastian", "masc", (long) 123,(long)7686880,null,
			  Optional.ofNullable("Soltero"),Optional.ofNullable(4),null);
	  aereolinea.agregarViaje((long) 123, "miami", 22.0, "12/12/12");
	  aereolinea.agregarViaje((long) 123, "miami", 23.0, "12/12/12");

	  aereolinea.agregarPersona("johann", "masc", (long) 456,null,
			  null,Optional.ofNullable("Casado"),Optional.ofNullable(0),null);
	  aereolinea.agregarViaje((long) 456, "miami", 1.0, "12/12/12");
	  aereolinea.agregarViaje((long) 456, "miami", 2.0, "12/12/12");

	 }
	 
	 @Test
		public void getEducacionByIdTest() {
		    Optional<String> educacion = aereolinea.getEducacionById((long)123);
		    assertEquals("Esta persona no registró nivel educativo","null", educacion+"");
		}
		
	
//	se ejecuta siempre, en caso de que el telefono sea null envia el valor por defecto 0
	@Test
		public void getTelefonoByIdorElseTest() {
		 	Long telefono = aereolinea.getTelefonoByCedula((long)123);
		 	Long telefonoP = Optional.ofNullable(telefono).orElse((long)0);
		 	if (telefono == null) {
				 assertEquals(0, telefonoP,0.001);
			}else {
				 assertEquals(7686880, telefonoP,0.001);
			}
		}
	
//	se ejecuta el orElseGet solo si no se ingreso el telefono, en este caso envia el valor por defecto 0
	@Test
		public void getTelefonoByIdorElseGetTest() {
		Long telefono = aereolinea.getTelefonoByCedula((long)123);
		Long telefonoP = Optional.ofNullable(telefono).orElseGet(() -> (long)0);
			if (telefono == null) {
				 assertEquals(0, telefonoP,0.001);
			}else {
				 assertEquals(7686880, telefonoP,0.001);
			}
		   
		}
	
 
	@Test
	public void  getestadoCivilByIdTest() {
		   Optional<String> estado = aereolinea.getestadoCivilById((long)123);
		   assertTrue("Esta persona no registró teléfono",estado.isPresent());
	}
	
	@Test
	public void getestadoCivilByIdGetTest() {
	    Optional<String> estado = aereolinea.getestadoCivilById((long)456);
	    String est = estado.get();
	 
	    assertEquals("Casado", est);
	}
	
	@Test
	public void getTieneHijosByIdTest() {
	    boolean TieneHijos = aereolinea.getNumHijosById((long)123).filter(y -> y > 0).isPresent();
	    assertTrue(TieneHijos);
	    
	    boolean noTieneHijos = aereolinea.getNumHijosById((long)456).filter(y -> y > 0).isPresent();
	    assertFalse(noTieneHijos);
	}	

	
	@Test
	public void getConcuerdaHijosByIdTest() {
	    List<String> Nombrehijos = Arrays.asList(
	      "ricardo", "maria", "esteban",  "alex");
	    Optional<List<String>> listOptional = Optional.of(Nombrehijos);
	 
	    int tamanoList = listOptional
	      .map(List::size)
	      .orElse(0);
	    
	    Integer numeroHijos = aereolinea.getNumHijosById((long)123).get();
	    
	    assertEquals(numeroHijos, tamanoList,0.0001);
	}
	
	
}
