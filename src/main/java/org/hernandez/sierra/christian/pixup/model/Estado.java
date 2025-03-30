package org.hernandez.sierra.christian.pixup.model;

import org.hernandez.sierra.christian.pixup.util.ReadUtil;
import org.hernandez.sierra.christian.pixup.vista.Ejecutable;
import org.hernandez.sierra.christian.pixup.vista.Menu;

import java.util.ArrayList;

public class Estado implements Ejecutable {

    private Integer id;
    private String nombre;

    private static Estado estado;
    private ArrayList<Estado> listaestado= new ArrayList<>();

    public Estado(){

    }


    public Estado(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public ArrayList<Estado> getListaestado() {
        return listaestado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static Estado getInstance(){
        if (estado==null){
            estado= new Estado();
        }
        return estado;
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
                    System.out.println("Que id tiene el estado?");
                    int newid=ReadUtil.getInstance().leerInt();
                    System.out.println("Que nombre tiene el estado?");
                    String newnombre= ReadUtil.getInstance().leer();
                    Estado estado1=new Estado(newid, newnombre);
                    listaestado.add(estado1);
                    System.out.println("Estado añadido!");
                break;
                case 2:
                    busqueda=false;
                    System.out.println("Que id tiene el estado que deseas dar de baja?");
                    util= ReadUtil.getInstance().leerInt();
                    System.out.println("Seguro que desea la eliminacion? si/no");
                    String confirmacion= ReadUtil.getInstance().leer();
                    if (confirmacion.equals("Si") || confirmacion.equals("si"))
                    {
                        for(int i=0; i<listaestado.size(); i++){
                            if(listaestado.get(i).getId()==util){
                                listaestado.remove(i);
                                System.out.println("El estado fue eliminado");
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
                    System.out.println("Que id tiene el estado donde desea realizar cambios? ");
                    util=ReadUtil.getInstance().leerInt();
                    for (int i=0; i<listaestado.size(); i++)
                    {
                        if(listaestado.get(i).getId()==util)
                        {
                            System.out.println("Que desea cambiar?");
                            menu.atributos1();
                            int opcion2 = ReadUtil.getInstance().leerInt();
                                switch (opcion2)
                                {
                                    case 1:
                                        System.out.println("Escriba el nuevo id");
                                        newid=ReadUtil.getInstance().leerInt();
                                        listaestado.get(i).setId(newid);
                                        System.out.println("Cambios realizados correctamente");
                                        break;
                                    case 2:
                                        System.out.println("Escriba el nuevo nombre");
                                        newnombre=ReadUtil.getInstance().leer();
                                        listaestado.get(i).setNombre(newnombre);
                                        System.out.println("Cambios realizados correctamente");
                                        break;
                                    case 3:
                                        break;
                                    default:
                                        menu.invalido();
                                }
                            busqueda=true;
                        }
                    }
                    if(busqueda!=true)
                    {
                        System.out.println("No se encontro el estado");
                        System.out.println("Regresando al menu...");
                    }
                    break;
                case 4:
                    busqueda=false;
                    System.out.println("Que id tiene el estado que desea saber sus datos?");
                    util=ReadUtil.getInstance().leerInt();
                    for (int i=0; i<listaestado.size(); i++){
                        if(listaestado.get(i).getId()==util){
                            System.out.println("Nombre "+ listaestado.get(i).getNombre());
                            System.out.println("Id " + listaestado.get(i).getId());
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
