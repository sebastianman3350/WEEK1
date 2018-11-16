package com.s4nWeek1.com.week1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static java.lang.Math.toIntExact;

public class AereolineaLamdaTest {
 static Aereolinea aereolinea;
 static Persona persona;
 static List < Persona > Personas;

 @BeforeClass
 public static void setUpBeforeClass() throws Exception {
  aereolinea = new Aereolinea();
  persona = new Persona();
  Personas = new ArrayList <> ();


  aereolinea.agregarPersona("Juan", "masc", (long) 123,(long)7686880,null,
		  Optional.ofNullable("Soltero"),Optional.ofNullable(4),null);
  aereolinea.agregarViaje((long) 123, "miami", 22.0, "12/12/12");
  aereolinea.agregarViaje((long) 123, "miami", 23.0, "12/12/12");

  aereolinea.agregarPersona("Marcos", "masc", (long) 456,null,
		  null,Optional.ofNullable("Casado"),Optional.ofNullable(0),null);
  aereolinea.agregarViaje((long) 456, "miami", 1.0, "12/12/12");
  aereolinea.agregarViaje((long) 456, "miami", 2.0, "12/12/12");

 }




 @Test
 public void mostrarcantViajesPorIdTest() {

  long collect =
   aereolinea.getPersonas().stream()
   .filter(element -> element.getCedula().equals((long) 123))
   .map(x -> x.getViajes())
   .flatMap(x -> x.stream()).count();

  assertEquals("La cantidad de viajes no corresponde a esta persona",collect, 2);

 }

 @Test
 public void mostrarCantidadDineroVendidosTest() {

  double collect =
   aereolinea.getPersonas().stream()
   .map(x -> x.getViajes())
   .flatMap(x -> x.stream()).mapToDouble(y -> y.getPrecio()).sum();


  assertEquals("la cantidad de dinero vendido no corresponde a este monto",collect, 48.0, 0.001);
 }

 @Test
 public void mostrarCantidadViajesVendidosTest() {

  long collect =
   aereolinea.getPersonas().stream()
   .map(x -> x.getViajes())
   .flatMap(x -> x.stream()).count();
  assertEquals(collect, 4, 0.001);
 }

 @Test
 public void verificarPersonaTest() {

  Stream < Persona > streamOfCollection = Personas.parallelStream();
  boolean personaExiste = streamOfCollection
   .map(x -> x.getCedula())
   .anyMatch(x -> x == (long) 123);

  assertFalse("Esta persona no esta registrada en la aereolinea",personaExiste);
 }


 @Test
 public void agregarViajeTest() {

  assertTrue("error. El el arraylist viajes se encuentra vacio despues de hacer la solicitud de ingresar un viaje", aereolinea.getPersonas().get(0).getViajes().size() > 0);
 }

 @Test
 public void mostrarViajePorIdTest() {

  List < Viaje > collect =
   aereolinea.getPersonas().stream()
   .filter(element -> element.getCedula().equals((long) 123))
   .map(x -> x.getViajes())
   .flatMap(x -> x.stream())
   .collect(Collectors.toList());


  assertThat("estos viajes no corresponden a esta persona",collect, is(aereolinea.getPersonas().get(0).getViajes()));

 }

 @Test
 public void mostrarTodosLosViajesTest() {

  List < Viaje > collect =
   aereolinea.getPersonas().stream()
   .map(x -> x.getViajes())
   .flatMap(x -> x.stream())
   .collect(Collectors.toList());

  assertThat("Estos viajes no corresponden con los agendados por la aereolinea",collect, is(aereolinea.mostrarTodosLosViajes()));

 }

 @Test
 public void getIdByCedulaTest() {
  List < Long > collect =
   aereolinea.getPersonas().stream()
   .filter(element -> element.getCedula() == (long) 456)
   .map(x -> x.getPid())
   .collect(Collectors.toList());

  assertEquals("Este Id no corresponde a esta persona",toIntExact(collect.get(0)), 1);
 }





}