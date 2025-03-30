package org.hernandez.sierra.christian.pixup.vista;

public class Menu {

    public Menu() {
    }

    public static void principal(){
        System.out.println("Bienvenido!");
        System.out.println("Seleccione una opcion de vista");
        System.out.println("1.- Consola");
        System.out.println("2.- Ventana");
        System.out.println("3.- Salir");
    }
    
    public static void invalido(){
        System.out.println("Opcion invalida, seleccione una del menu porfavor");
    }

    public static void principal2(){
        System.out.println("Bienvenido a Consola!");
        System.out.println("Selecciona una opcion");
        System.out.println("1.- Catalogos");
        System.out.println("3.- Salida");
    }

    public static void tipo(){
        System.out.println("1.- Estado");
        System.out.println("2.- Municipio");
        System.out.println("3.- Colonia");
        System.out.println("4.- Domicilio ");
        System.out.println("5.- Salir");
    }

    public static void opciones(){
        System.out.println("1.- Alta");
        System.out.println("2.- Baja");
        System.out.println("3.- Cambios");
        System.out.println("4.- Consultar");
        System.out.println("5.- Salir");
    }

    public static void atributos1(){
        System.out.println("1.- Id");
        System.out.println("2.- Nombre");
        System.out.println("3.- Salir");
    }

    public static void atributos2(){
        System.out.println("1.- Id");
        System.out.println("2.- Nombre");
        System.out.println("3.- Estado");
        System.out.println("4.- Salir");
    }

    public static void atributos3(){
        System.out.println("1.- Id");
        System.out.println("2.- Nombre");
        System.out.println("3.- Cp");
        System.out.println("4.- Municipio");
        System.out.println("5.- Salir");
    }

    public static void atributos4(){
        System.out.println("1.- Id");
        System.out.println("2.- Calle");
        System.out.println("3.- Numero Exterior");
        System.out.println("4.- Numero Interior");
        System.out.println("5.- Colonia");
        System.out.println("6.- Salir");
    }
}
