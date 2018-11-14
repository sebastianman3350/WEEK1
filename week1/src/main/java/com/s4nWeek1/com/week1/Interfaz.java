package com.s4nWeek1.com.week1;

import java.util.Scanner;

public class Interfaz {
	
	Aereolinea aereolinea = new Aereolinea();
	Scanner sc = new Scanner(System.in);
	
	private int ch = 0;
	public Interfaz () {
		menuPrincipal();
    }
	public void opcionesMenuPrincipal () {
        System.out.println(" \n1. Listar");
        System.out.println("2. Insertar");
        System.out.println("0. salir");
    }
	public void opcionesListar () {
        System.out.println("\n1. Mostrar Todos Los Clientes");
        System.out.println("2. Mostrar Todos Los Viajes");
        System.out.println("3. Mostrar Los Viajes Por Numero de cedula");
        System.out.println("4. Mostrar La Cantidad De Viajes Por Numero de cedula");
        System.out.println("5. Cantidad de dinero vendido por la aereolinea");
        System.out.println("6. Cantidad de viajes vendidos por la aereolinea");
        System.out.println("99. Atras");
        System.out.println("0. salir");
    }
	
	public void opcionesIngresar () {
        System.out.println("\n1. Ingresar Persona");
        System.out.println("2. Ingresar Viaje");
        System.out.println("99. Atras");
        System.out.println("0. salir");
    }
	
    public void menuPrincipal () {
        do {
            opcionesMenuPrincipal();
            getEntradaUsuario();
            switch (ch) {
                case 1: 
                	menuListar();
                    break;
                case 2:
                	menuIngresar();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    
                    break;
            }
        } while (ch != 0);
    }
    
    public void menuListar () {
        do {
        	opcionesListar();
            getEntradaUsuario();
            switch (ch) {
                case 1: 
                	System.out.println("*****Clientes de la Aereolinea*****");
                	aereolinea.mostrarTodasPersonas();
                    break;
                case 2: 
                	System.out.println("*****Viajes de la Aereolinea*****");
                	aereolinea.mostrarTodosLosViajes().forEach(x -> System.out.println(
	           		 x.getId() + "- con destino: " +
	           		 x.getDestino() + " para la fecha:"+
	           		 x.getFecha()
                		  ));
                	
                    break;
                case 3: 
                	System.out.println("Por favor ingrese el número de cedula:");
                    id = sc.nextLong();
                	
                	aereolinea.mostrarViajePorId(id).forEach(x -> System.out.println(
                   		 x.getId() + "- con destino: " +
                   		 x.getDestino() + " para la fecha:"+
                   		 x.getFecha() + " con el precio:" + x.getPrecio()
                   ));  
                    break; 
                case 4: 
                	System.out.println("Por favor ingrese el número de cedula:");
                    id = sc.nextLong();
                	System.out.println("*****"+id+" Tiene "+aereolinea.mostrarcantViajesPorId(id)
                	+" Viajes Asignados****\n"); 
                    break;
                case 5: 
                	System.out.println("Cantidad de dinero vendido por la aereolinea: $" + aereolinea.mostrarCantidadDineroVendidos()); 
                    break;    
                case 6: 
                	System.out.println("La aereolinea a vendido " + aereolinea.mostrarCantidadViajesVendidos()
                	+ " viajes"); 
                    break;    
                case 99:
                	menuPrincipal();
                    break;                    
                case 0:
                    System.exit(0);
                    break;
                default:
                    
                    break;
            }
        } while (ch != 0);
    }
    long id ;
    String nombre;
    String genero;
    Integer pid;
    public void menuIngresar () {
        do {
        	opcionesIngresar();
            getEntradaUsuario();
            switch (ch) {
                case 1: 
                	
                	System.out.println("Por favor ingrese el número de cedula:");
                    id = sc.nextLong();
                    System.out.println("Por favor ingrese el nombre:");
                    nombre = sc.next();
                    System.out.println("Por favor ingrese el género:");
                    genero = sc.next();
                	aereolinea.agregarPersona(nombre,genero,id);
                    break;
                case 2: 
                	System.out.println("Por favor ingrese el número de cedula:");
                    id = sc.nextLong();
                    
                    if (aereolinea.verificarPersona(id)) {
                        System.out.println("Por favor ingrese el destino:");
                        String destino = sc.next();
                        System.out.println("Por favor ingrese precio del vuelo:");
                        Double precio = sc.nextDouble();
                        System.out.println("Por favor ingrese la fecha del vuelo:");
                        String fecha = sc.next();
                        
                        aereolinea.agregarViaje(id,destino,precio,fecha);
                        
                	}else {
                		System.out.println("La persona no existe, por lo que no es posible asignar un vuelo" );   
                	}
                    
                    
                	
                    break;
                case 99:
                	menuPrincipal();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    
                    break;
            }
        } while (ch != 0);
    }

    private int getEntradaUsuario() throws NumberFormatException {
        Scanner in = new Scanner (System.in);
        ch = Integer.parseInt(in.nextLine());
        return ch;
    }
    
    
}
