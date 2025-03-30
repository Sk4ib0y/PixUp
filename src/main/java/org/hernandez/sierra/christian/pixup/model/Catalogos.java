package org.hernandez.sierra.christian.pixup.model;

import org.hernandez.sierra.christian.pixup.util.ReadUtil;
import org.hernandez.sierra.christian.pixup.vista.Ejecutable;
import org.hernandez.sierra.christian.pixup.vista.Menu;

public class Catalogos implements Ejecutable {

    private static Catalogos catalogos;

    public Catalogos() {

    }

    public static Catalogos getInstance()
    {
        if (catalogos==null){
            catalogos=new Catalogos();
    }
        return catalogos;
    }
    @Override
    public void run() {
        Ejecutable ejecutable= null;
        boolean flag=true;
        int opcion;
        Menu menu=new Menu();

        while (flag)
        {
            menu.tipo();
            opcion= ReadUtil.getInstance().leerInt();
            switch (opcion)
            {
                case 1:
                    ejecutable=Estado.getInstance();
                    break;
                case 2:
                    ejecutable=Municipio.getInstance();
                    break;
                case 3:
                    ejecutable=Colonia.getInstance();
                    break;
                case 4:
                    ejecutable=Domicilio.getInstance();
                    break;
                case 5:
                    flag=false;
                    break;
                default:
                    menu.invalido();
                    break;
            }
            System.out.println("----------------------------");
            if (ejecutable !=null)
            {
                ejecutable.run();
            }
        }
    }
}
