/*
 * clase que tiene las funciones 
 * que interactuan con las clases Persona
 * y viaje, permite realizar las consultas e inserciones
 */


package com.s4nWeek1.com.week1;
import static java.lang.Math.toIntExact;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Aereolinea {
 private List < Persona > Personas = new ArrayList < > ();
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

// permite agregar personas a a lista
 public void agregarPersona(String nombre, String genero, long cedula,Long telefono,Optional<String> educacion,
	 		Optional<String> estadoCivil,Optional<Integer> cantHijos,
	 		Optional<List<String>> nombreHijos) {

		 this.Personas.add(new Persona(i, nombre, genero, cedula,telefono,educacion,estadoCivil,cantHijos,nombreHijos));
	  System.out.println(nombre + " ha sido agregado con exito!");
	  i++;

	 }
 
 
// permite agregar viajes con respecto a la persona
 public void agregarViaje(Long cedula, String destino, Double precio, String fecha) {

  this.Personas.get(getIdByCedula(cedula))
   .agregarViaje(cedula, destino, precio, fecha);


 }

 //**********************************
 //*********** consultas ************
 //**********************************

//muestra todas las personas que se han registrado en la aereolinea
 public void mostrarTodasPersonas() {
  
  getPersonas().forEach(b -> System.out.println(
   b.getPid() + "- " +
   b.getnombre() + " " +
   b.getgenero() + " " + b.getCedula()));


 }

 //  retorna una lista de objetos de tipo Viaje, 
// con los datos de todos los viajes registrados en la ereolinea
 public List < Viaje > mostrarTodosLosViajes() {

  List < Viaje > viajes = new ArrayList < > ();
  for (Persona i: Personas) {
   for (Viaje j: i.getViajes()) {
    viajes.add(j);
   }

  }

  return viajes;

 }

 //retorna el Id de una persona con respecto
// al numero de su cedula
 public int getIdByCedula(long cedula) {
  int idP = 0;
  for (Persona i: Personas) {
   if (i.getCedula() == cedula) {
    idP = toIntExact(i.getPid());
   }
  }
  return idP;
 }
 

//retorna un opcional del estado civil
//de una persona con respecto
//al numero de su cedula
public Optional<String> getestadoCivilById(long cedula) {
 Optional<String> estado = null;
 for (Persona i: Personas) {
  if (i.getCedula() == cedula) {
	   estado = i.getEstadoCivil();
  }
 }
 return estado;
}

//retorna una lista de viajes
//de una persona con respecto
//al numero de su cedula 
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


//retorna el numero de viajes
//de una persona con respecto
//al numero de su cedula
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

//	devuelve un double con la cantidad de dinero en viajes
//vendidos por la aereolinea
public double mostrarCantidadDineroVendidos() {

 double cantDinero = 0;
 for (Persona i: Personas) {
  for (Viaje j: i.getViajes()) {
   cantDinero += j.getPrecio();
  }
 }
return cantDinero;

}


//	devuelve un double con la cantidad de dinero en viajes
//vendidos por la aereolinea mediante una interface funcional
 public double mostrarCantidadDineroVendidosInterface() {
	  
	  ViajesV o = (x) -> x.stream()
			   .map(z -> z.getViajes())
			   .flatMap(z -> z.stream()).mapToDouble(y -> y.getPrecio()).sum();;
	  
	  double collect = o.mostrarCantidadDineroVendidos(getPersonas());

 return collect;
}
 
//devuelve un long con la cantidad de viajes vendidos	
public long mostrarCantidadViajesVendidos() {
 long cantViajesVendidos = 0;
 for (Persona i: Personas) {
  cantViajesVendidos = cantViajesVendidos + i.getViajes().size();
 }

 return cantViajesVendidos;
}



//devuelve un boolean indicando si una persona 
//esta registrada en la aereolinea o no
public boolean verificarPersona(long pid) {
 boolean personaExiste = false;
 for (Persona i: Personas) {
  if (i.getCedula() == pid) {
   personaExiste = true;
  }
 }

 return personaExiste;
}

 
 //retorna el telefono de una persona con respecto
//al numero de su cedula
 public Long getTelefonoByCedula(long cedula) {
  Long telefono = null;
  for (Persona i: Personas) {
   if (i.getCedula() == cedula) {
	 telefono = i.getTelefono();
   }
  }
  return telefono;
 }

//retorna un opcional del nivel de educacion
// de una persona con respecto
//al numero de su cedula
 public Optional<String> getEducacionById(long cedula) {
  Optional<String> educ = null;
  for (Persona i: Personas) {
   if (i.getCedula() == cedula) {
	   educ = i.geteducacion();
   }
  }
  return educ;
 }
 
////retorna un opcional numero de hijos
//de una persona con respecto
//al numero de su cedula
public Optional<Integer> getNumHijosById(long cedula) {
	Optional<Integer> numHijos = null;
	for (Persona i: Personas) {
	if (i.getCedula() == cedula) {
		numHijos = i.getCantHijos();
	}
	}
return numHijos;
}

 
// devuelve la lista de personas registradass
 public List < Persona > getPersonas() {
  return Personas;
 }



}