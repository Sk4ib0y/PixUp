package org.hernandez.sierra.christian.pixup.inicio;

import org.hernandez.sierra.christian.pixup.util.ReadUtil;
import org.hernandez.sierra.christian.pixup.vista.Consola;
import org.hernandez.sierra.christian.pixup.vista.Ejecutable;
import org.hernandez.sierra.christian.pixup.vista.Menu;
import org.hernandez.sierra.christian.pixup.vista.Ventana;

public class Principal
{

    public Principal()
    {
    }

    public static void main (String[]args)
    {
        boolean flag=true;
        Menu menu = new Menu();
        int opcion=0;
        Ejecutable ejecutable=null;
        while (flag)
        {
            ejecutable=null;
            menu.principal();
            opcion= ReadUtil.getInstance().leerInt();
            switch (opcion){
                case 1:
                    ejecutable= Consola.getInstance();
                    break;
                case 2:
                    ejecutable= Ventana.getInstance();
                    break;
                case 3:
                    flag=false;
                    break;
                default:
                    menu.invalido();
                    break;
            }
            System.out.println("---------------------------------------");
            if (ejecutable !=null)
            {
                ejecutable.run();
            }
        }
    }
}
