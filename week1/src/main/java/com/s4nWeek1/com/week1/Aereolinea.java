package com.s4nWeek1.com.week1;
import static java.lang.Math.toIntExact;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Aereolinea {
 private static Persona persona = new Persona();
 private static List < Persona > Personas = new ArrayList < > ();
 Integer idVuelo;
 String destino;
 double precio;
 String fecha;
 long i = 0;
 Scanner sc = new Scanner(System.in);



 public Aereolinea() {}

 //**********************************
 //*********** inserciones **********
 //**********************************
 //  testeado    
 public void agregarViaje(Long cedula, String destino, Double precio, String fecha) {

  this.Personas.get(getIdByCedula(cedula))
   .agregarViaje(cedula, destino, precio, fecha);


 }

 public void agregarPersona(String nombre, String genero, long cedula) {

  this.Personas.add(new Persona(i, nombre, genero, cedula));
  System.out.println(nombre + " ha sido agregado con exito!");
  i++;

 }

 //**********************************
 //*********** consultas ************
 //**********************************


 public void mostrarTodasPersonas() {
  
  getPersonas().forEach(b -> System.out.println(
   b.getPid() + "- " +
   b.getnombre() + " " +
   b.getgenero() + " " + b.getCedula()));


 }

 //  testeado 
 public List < Viaje > mostrarTodosLosViajes() {


  List < Viaje > viajes = new ArrayList < > ();
  for (Persona i: Personas) {
   for (Viaje j: i.getViajes()) {
    viajes.add(j);
   }

  }

  return viajes;

 }

 //  testeado 
 public int getIdByCedula(long cedula) {
  int idP = 0;
  for (Persona i: Personas) {
   if (i.getCedula() == cedula) {
    idP = toIntExact(i.getPid());
   }
  }
  return idP;
 }



 //  testeado  
 public List < Viaje > mostrarViajePorId(long Id) {
  System.out.println("*****los viajes de la persona con numero de cédula " + Id + " son: *****");

  List < Viaje > viajes = null;
  for (Persona i: Personas) {
   if (i.getCedula() == Id) {
    viajes = i.getViajes();
   }
  }


  return viajes;
 }
 //	testeado
 public long mostrarcantViajesPorId(long pid) {
  int countViajes = 0;
  for (Persona i: Personas) {
   if (i.getCedula() == pid) {
    for (Viaje j: i.getViajes()) {
     countViajes++;
    }
   }
  }
  return countViajes;
 }

 //	testeado	
 public double mostrarCantidadDineroVendidos() {

  double cantDinero = 0;
  for (Persona i: Personas) {
   for (Viaje j: i.getViajes()) {
    cantDinero += j.getPrecio();
   }
  }


  return cantDinero;
 }
 //	testeado	
 public long mostrarCantidadViajesVendidos() {
  long cantViajesVendidos = 0;
  for (Persona i: Personas) {
   cantViajesVendidos = cantViajesVendidos + i.getViajes().size();
  }

  return cantViajesVendidos;
 }



 //    testeado
 public boolean verificarPersona(long pid) {
  boolean personaExiste = false;
  for (Persona i: Personas) {
   if (i.getCedula() == pid) {
    personaExiste = true;
   }
  }

  return personaExiste;
 }

 public List < Persona > getPersonas() {
  return Personas;
 }



}