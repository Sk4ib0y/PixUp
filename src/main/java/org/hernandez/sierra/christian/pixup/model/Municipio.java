package org.hernandez.sierra.christian.pixup.model;

import org.hernandez.sierra.christian.pixup.util.ReadUtil;
import org.hernandez.sierra.christian.pixup.vista.Ejecutable;
import org.hernandez.sierra.christian.pixup.vista.Menu;

import java.util.ArrayList;

public class Municipio implements Ejecutable {
    private Integer id;
    private String nombre;
    private Estado estado;
    private Estado estadofound;
    public Municipio()
    {
    }

    public Municipio(Estado estado) {
        this.estado = Estado.getInstance();
    }

    public Municipio(Integer id, String nombre, Estado estado)
    {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public Estado getEstado()
    {
        return estado;
    }

    public void setEstado(Estado estado)
    {
        this.estado = estado;
    }


    private static Municipio municipio;
    private ArrayList<Municipio> listamunicipio=new ArrayList<>();

    public Municipio(ArrayList<Municipio> listamunicipio) {
        this.listamunicipio = listamunicipio;
    }

    public ArrayList<Municipio> getListamunicipio() {
        return listamunicipio;
    }

    public static Municipio getInstance(){
        if(municipio==null){
            municipio=new Municipio();
        }
        return municipio;
    }

    @Override
    public void run()
    {
        int opcion;
        boolean flag=true;
        boolean busqueda=false;
        Menu menu= new Menu();
        while (flag){
            menu.opciones();
            opcion= ReadUtil.getInstance().leerInt();
            int util;
            switch (opcion)
            {
                case 1:
                    busqueda=false;
                    System.out.println("Que id tiene el municipio?");
                    int newid=ReadUtil.getInstance().leerInt();
                    System.out.println("Que nombre tiene el municipio?");
                    String newnombre= ReadUtil.getInstance().leer();
                    System.out.println("Ingresa el id del estado donde se encuentra");

                    if (estado == null) {
                        estado = Estado.getInstance();
                    }

                    int newestado=ReadUtil.getInstance().leerInt();
                    for(int i=0;i<estado.getListaestado().size();i++)
                    {
                        if(estado.getListaestado().get(i).getId()==newestado)
                        {
                            busqueda=true;
                            estadofound=estado.getListaestado().get(i);
                            Municipio municipio1=new Municipio(newid, newnombre, estadofound);
                            listamunicipio.add(municipio1);
                            System.out.println("Municipio añadido!");
                            break;
                        }
                    }
                    if(busqueda!=true)
                    {
                        System.out.println("El estado no se encontro");
                    }
                    break;
                case 2:
                    busqueda=false;
                    System.out.println("Que id tiene el municipio que deseas dar de baja?");
                    util= ReadUtil.getInstance().leerInt();
                    System.out.println("Seguro que desea la eliminacion? si/no");
                    String confirmacion= ReadUtil.getInstance().leer();
                    if (confirmacion.equals("Si") || confirmacion.equals("si"))
                    {
                        for(int i=0; i<listamunicipio.size(); i++){
                            if(listamunicipio.get(i).getId()==util){
                                listamunicipio.remove(i);
                                System.out.println("El municipio fue eliminado");
                                busqueda=true;
                                break;
                            }
                        }
                        if (busqueda!=true) {
                            System.out.println("El id que escribio no fue encontrado");
                            System.out.println("Regresando al menu...");
                        }
                    }
                    else
                    {
                        System.out.println("Regresando al menu...");
                    }
                    break;
                case 3:
                    busqueda=false;
                    System.out.println("Que id tiene el municipio donde desea realizar cambios? ");
                    util=ReadUtil.getInstance().leerInt();
                    for (int i=0; i<listamunicipio.size(); i++)
                    {
                        if(listamunicipio.get(i).getId()==util)
                        {
                            System.out.println("Que desea cambiar?");
                            menu.atributos2();
                            int opcion2 = ReadUtil.getInstance().leerInt();
                            switch (opcion2)
                            {
                                case 1:
                                    System.out.println("Escriba el nuevo id");
                                    newid=ReadUtil.getInstance().leerInt();
                                    listamunicipio.get(i).setId(newid);
                                    System.out.println("Cambios realizados correctamente");
                                    break;
                                case 2:
                                    System.out.println("Escriba el nuevo nombre");
                                    newnombre=ReadUtil.getInstance().leer();
                                    listamunicipio.get(i).setNombre(newnombre);
                                    System.out.println("Cambios realizados correctamente");
                                    break;
                                case 3:
                                    boolean busqueda2=false;
                                    System.out.println("Escriba el id del nuevo estado (existente)");
                                    newestado=ReadUtil.getInstance().leerInt();
                                    for(int j=0; j<estado.getListaestado().size(); j++)
                                    {
                                        if(newestado==estado.getListaestado().get(j).getId())
                                        {
                                            busqueda2=true;
                                            estadofound=estado.getListaestado().get(j);
                                            listamunicipio.get(i).setEstado(estadofound);
                                            System.out.println("Cambios realizados correctamente");
                                            break;
                                        }
                                    }
                                    if(!busqueda2)
                                    {
                                        System.out.println("No se encontro el estado");
                                    }
                                    break;
                                case 4:
                                    break;
                                default:
                                    menu.invalido();
                                    break;
                            }
                            busqueda=true;
                        }
                    }
                    if(busqueda!=true)
                    {
                        System.out.println("No se encontro el municipio");
                        System.out.println("Regresando al menu...");
                    }
                    break;
                case 4:
                    busqueda=false;
                    System.out.println("Que id tiene el municipio que desea saber sus datos?");
                    util=ReadUtil.getInstance().leerInt();
                    for (int i=0; i<listamunicipio.size(); i++){
                        if(listamunicipio.get(i).getId()==util){
                            System.out.println("Nombre "+ listamunicipio.get(i).getNombre());
                            System.out.println("Id " + listamunicipio.get(i).getId());
                            System.out.println("Estado");

                            System.out.println("Id del estado "+listamunicipio.get(i).getEstado().getId());
                            System.out.println("Nombre del estado "+listamunicipio.get(i).getEstado().getNombre());
                            busqueda=true;
                            break;
                        }
                    }
                    if(busqueda != true)
                    {
                        System.out.println("No se encontro el estado");
                        System.out.println("Regresando al menu...");
                    }
                    break;
                case 5:
                    flag=false;
                    break;
                default:
                    menu.invalido();
                    break;
            }
            System.out.println("-------------------------------------");
        }
    }
}