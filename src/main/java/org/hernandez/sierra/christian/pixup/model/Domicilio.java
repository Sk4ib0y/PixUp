package org.hernandez.sierra.christian.pixup.model;

import org.hernandez.sierra.christian.pixup.util.ReadUtil;
import org.hernandez.sierra.christian.pixup.vista.Ejecutable;
import org.hernandez.sierra.christian.pixup.vista.Menu;

import java.util.ArrayList;

public class Domicilio implements Ejecutable
{
    private Integer id;
    private String calle;
    private String numint;
    private String numext;
    private Colonia colonia;
    private Colonia coloniafound;

    public Domicilio(){

    }

    public Domicilio(Colonia colonia){
        this.colonia=colonia.getInstance();
    }

    public Domicilio(Integer id, String calle, String numext, String numint, Colonia colonia)
    {
        this.id=id;
        this.calle=calle;
        this.numext=numext;
        this.numint=numint;
        this.colonia=colonia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumint() {
        return numint;
    }

    public void setNumint(String numint) {
        this.numint = numint;
    }

    public String getNumext() {
        return numext;
    }


    public void setNumext(String numext) {
        this.numext = numext;
    }

    public Colonia getColonia() {
        return colonia;
    }

    public void setColonia(Colonia colonia) {
        this.colonia = colonia;
    }

    private static Domicilio domicilio;
    private ArrayList<Domicilio> listadomicilio=new ArrayList<>();

    public static Domicilio getInstance()
    {
        if(domicilio==null)
        {
            domicilio=new Domicilio();
        }
        return domicilio;
    }

    @Override
    public void run()
    {
        int opcion;
        boolean flag=true;
        boolean busqueda=false;
        Menu menu=new Menu();

        while (flag)
        {
            menu.opciones();
            opcion= ReadUtil.getInstance().leerInt();
            int util;
            switch (opcion)
            {
                case 1:
                    busqueda=false;
                    System.out.println("Que id tiene el domicilio?");
                    int newid=ReadUtil.getInstance().leerInt();
                    System.out.println("En que calle se encuentra el domicilio");
                    String newcalle = ReadUtil.getInstance().leer();
                    System.out.println("Que numero interior tiene el domicilio");
                    String newnumint=ReadUtil.getInstance().leer();
                    System.out.println("Que numero exterior tiene el domicilio");
                    String newnumext=ReadUtil.getInstance().leer();
                    System.out.println("Ingresa el id de la colonia donde se encuentra");

                    if (colonia == null) {
                        colonia = Colonia.getInstance();
                    }

                    int newcolonia=ReadUtil.getInstance().leerInt();
                    for(int i=0;i<colonia.getListacolonia().size();i++)
                    {
                        if(colonia.getListacolonia().get(i).getId()==newcolonia)
                        {
                            busqueda=true;
                            coloniafound=colonia.getListacolonia().get(i);
                            Domicilio domicilio1=new Domicilio(newid, newcalle, newnumext, newnumint, coloniafound);
                            listadomicilio.add(domicilio1);
                            System.out.println("Domicilio añadido!");
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
                    System.out.println("Que id tiene el domicilio que deseas dar de baja?");
                    util= ReadUtil.getInstance().leerInt();
                    System.out.println("Seguro que desea la eliminacion? si/no");
                    String confirmacion= ReadUtil.getInstance().leer();
                    if (confirmacion.equals("Si") || confirmacion.equals("si"))
                    {
                        for(int i=0; i<listadomicilio.size(); i++){
                            if(listadomicilio.get(i).getId()==util){
                                listadomicilio.remove(i);
                                System.out.println("El domicilio fue eliminado");
                                busqueda=true;
                                break;
                            }
                        }
                        if (busqueda!=true)
                        {
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
                    System.out.println("Que id tiene el domicilio donde desea realizar cambios? ");
                    util=ReadUtil.getInstance().leerInt();
                    for (int i=0; i<listadomicilio.size(); i++)
                    {
                        if(listadomicilio.get(i).getId()==util)
                        {
                            System.out.println("Que desea cambiar?");
                            menu.atributos4();
                            int opcion2 = ReadUtil.getInstance().leerInt();
                            switch (opcion2)
                            {
                                case 1:
                                    System.out.println("Escriba el nuevo id");
                                    newid=ReadUtil.getInstance().leerInt();
                                    listadomicilio.get(i).setId(newid);
                                    System.out.println("Cambios realizados correctamente");
                                    break;
                                case 2:
                                    System.out.println("Escriba la nueva calle");
                                    newcalle=ReadUtil.getInstance().leer();
                                    listadomicilio.get(i).setCalle(newcalle);
                                    System.out.println("Cambios realizados correctamente");
                                    break;
                                case 3:
                                    System.out.println("Escriba el nuevo numero exterior");
                                    newnumext=ReadUtil.getInstance().leer();
                                    listadomicilio.get(i).setNumext(newnumext);
                                    System.out.println("Cambios realizados correctamente");
                                    break;
                                case 4:
                                    System.out.println("Escriba el nuevo numero interior");
                                    newnumint=ReadUtil.getInstance().leer();
                                    listadomicilio.get(i).setNumint(newnumint);
                                    System.out.println("Cambios realizados correctamente");
                                    break;
                                case 5:
                                    boolean busqueda2=false;
                                    System.out.println("Escriba el id del nuevo municipio (existente)");
                                    newcolonia=ReadUtil.getInstance().leerInt();
                                    for(int j=0; j<colonia.getListacolonia().size(); j++)
                                    {
                                        if(newcolonia==colonia.getListacolonia().get(j).getId())
                                        {
                                            busqueda2=true;
                                            coloniafound=colonia.getListacolonia().get(j);
                                            listadomicilio.get(i).setColonia(coloniafound);
                                            System.out.println("Cambios realizados correctamente");
                                            break;
                                        }
                                    }
                                    if(!busqueda2)
                                    {
                                        System.out.println("No se encontro la colonia");
                                    }
                                    break;
                                case 6:
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
                    System.out.println("Que id tiene el domicilio que desea saber sus datos?");
                    util=ReadUtil.getInstance().leerInt();
                    for (int i=0; i<listadomicilio.size(); i++){
                        if(listadomicilio.get(i).getId()==util){
                            System.out.println("Calle "+ listadomicilio.get(i).getCalle());
                            System.out.println("Id " + listadomicilio.get(i).getId());
                            System.out.println("Numero Exterior "+listadomicilio.get(i).getNumext());
                            System.out.println("Numero Interior "+listadomicilio.get(i).getNumint());

                            System.out.println("Colonia");
                            System.out.println("Id de la colonia "+listadomicilio.get(i).getColonia().getId());
                            System.out.println("Nombre de la colonia "+listadomicilio.get(i).getColonia().getNombre());
                            System.out.println("Cp de la colonia "+listadomicilio.get(i).getColonia().getCp());

                            System.out.println("Municipio");
                            System.out.println("Id del municipio "+listadomicilio.get(i).getColonia().getMunicipio().getId());
                            System.out.println("Nombre del municipio "+listadomicilio.get(i).getColonia().getMunicipio().getNombre());

                            System.out.println("Estado");
                            System.out.println("Id del estado "+listadomicilio.get(i).getColonia().getMunicipio().getEstado().getId());
                            System.out.println("Nombre del Estado "+listadomicilio.get(i).getColonia().getMunicipio().getEstado().getNombre());
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
            }
        }
    }
}
