package org.hernandez.sierra.christian.pixup.model;

import org.hernandez.sierra.christian.pixup.util.ReadUtil;
import org.hernandez.sierra.christian.pixup.vista.Ejecutable;
import org.hernandez.sierra.christian.pixup.vista.Menu;

import java.util.ArrayList;

public class Colonia implements Ejecutable
{

    private Integer id;
    private String nombre;
    private String cp;
    private Municipio municipio;
    private Municipio municipiofound;

    public Colonia()
    {
    }

    public Colonia(Municipio municipio){
        this.municipio= Municipio.getInstance();
    }

    public Colonia(Integer id, String nombre, String cp, Municipio municipio)
    {
        this.id=id;
        this.nombre=nombre;
        this.cp=cp;
        this.municipio= municipio;
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

    public String getCp()
    {
        return cp;
    }

    public void setCp(String cp)
    {
        this.cp = cp;
    }

    public Municipio getMunicipio()
    {
        return municipio;
    }

    public void setMunicipio(Municipio municipio)
    {
        this.municipio = municipio;
    }

    private static Colonia colonia;
    private ArrayList<Colonia> listacolonia=new ArrayList<>();

    public ArrayList<Colonia> getListacolonia() {
        return listacolonia;
    }

    public static Colonia getInstance()
    {
        if(colonia==null)
        {
            colonia=new Colonia();
        }
        return colonia;
    }
    @Override
    public void run()
    {
        int opcion;
        boolean flag=true;
        boolean busqueda=false;
        Menu menu= new Menu();
        while(flag)
        {
            menu.opciones();
            opcion= ReadUtil.getInstance().leerInt();
            int util;
            switch (opcion)
            {
                case 1:
                    busqueda=false;
                    System.out.println("Que id tiene la colonia?");
                    int newid=ReadUtil.getInstance().leerInt();
                    System.out.println("Que nombre tiene la colonia?");
                    String newnombre= ReadUtil.getInstance().leer();
                    System.out.println("Que cp tiene la colonia");
                    String newcp=ReadUtil.getInstance().leer();
                    System.out.println("Ingresa el id del municipio donde se encuentra");

                    if (municipio == null) {
                        municipio = Municipio.getInstance();
                    }

                    int newmunicipio=ReadUtil.getInstance().leerInt();
                    for(int i=0;i<municipio.getListamunicipio().size();i++)
                    {
                        if(municipio.getListamunicipio().get(i).getId()==newmunicipio)
                        {
                            busqueda=true;
                            municipiofound=municipio.getListamunicipio().get(i);
                            Colonia colonia1=new Colonia(newid, newnombre, newcp, municipiofound);
                            listacolonia.add(colonia1);
                            System.out.println("Colonia añadida!");
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
                    System.out.println("Que id tiene la colonia que deseas dar de baja?");
                    util= ReadUtil.getInstance().leerInt();
                    System.out.println("Seguro que desea la eliminacion? si/no");
                    String confirmacion= ReadUtil.getInstance().leer();
                    if (confirmacion.equals("Si") || confirmacion.equals("si"))
                    {
                        for(int i=0; i<listacolonia.size(); i++){
                            if(listacolonia.get(i).getId()==util){
                                listacolonia.remove(i);
                                System.out.println("La colonia fue eliminada");
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
                    System.out.println("Que id tiene la colonia donde desea realizar cambios? ");
                    util=ReadUtil.getInstance().leerInt();
                    for (int i=0; i<listacolonia.size(); i++)
                    {
                        if(listacolonia.get(i).getId()==util)
                        {
                            System.out.println("Que desea cambiar?");
                            menu.atributos3();
                            int opcion2 = ReadUtil.getInstance().leerInt();
                            switch (opcion2)
                            {
                                case 1:
                                    System.out.println("Escriba el nuevo id");
                                    newid=ReadUtil.getInstance().leerInt();
                                    listacolonia.get(i).setId(newid);
                                    System.out.println("Cambios realizados correctamente");
                                    break;
                                case 2:
                                    System.out.println("Escriba el nuevo nombre");
                                    newnombre=ReadUtil.getInstance().leer();
                                    listacolonia.get(i).setNombre(newnombre);
                                    System.out.println("Cambios realizados correctamente");
                                    break;
                                case 3:
                                    System.out.println("Escriba el nuevo cp");
                                    newcp=ReadUtil.getInstance().leer();
                                    listacolonia.get(i).setCp(newcp);
                                    System.out.println("Cambios realizados correctamente");
                                    break;
                                case 4:
                                    boolean busqueda2=false;
                                    System.out.println("Escriba el id del nuevo municipio (existente)");
                                    newmunicipio=ReadUtil.getInstance().leerInt();
                                    for(int j=0; j<municipio.getListamunicipio().size(); j++)
                                    {
                                        if(newmunicipio==municipio.getListamunicipio().get(j).getId())
                                        {
                                            busqueda2=true;
                                            municipiofound=municipio.getListamunicipio().get(j);
                                            listacolonia.get(i).setMunicipio(municipiofound);
                                            System.out.println("Cambios realizados correctamente");
                                            break;
                                        }
                                    }
                                    if(!busqueda2)
                                    {
                                        System.out.println("No se encontro el municipio");
                                    }
                                    break;
                                case 5:
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
                    System.out.println("Que id tiene la colonia que desea saber sus datos?");
                    util=ReadUtil.getInstance().leerInt();
                    for (int i=0; i<listacolonia.size(); i++){
                        if(listacolonia.get(i).getId()==util){
                            System.out.println("Nombre "+ listacolonia.get(i).getNombre());
                            System.out.println("Id " + listacolonia.get(i).getId());
                            System.out.println("Cp "+listacolonia.get(i).getCp());
                            System.out.println("Municipio");

                            System.out.println("Id del municipio "+listacolonia.get(i).getMunicipio().getId());
                            System.out.println("Nombre del municipio "+listacolonia.get(i).getMunicipio().getNombre());

                            System.out.println("Estado");
                            System.out.println("Id del estado "+listacolonia.get(i).getMunicipio().getEstado().getId());
                            System.out.println("Nombre del Estado "+listacolonia.get(i).getMunicipio().getEstado().getNombre());
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
            System.out.println("-----------------------------------------");
        }

    }
}
