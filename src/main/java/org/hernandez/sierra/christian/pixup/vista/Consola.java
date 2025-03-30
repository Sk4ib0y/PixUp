package org.hernandez.sierra.christian.pixup.vista;

import org.hernandez.sierra.christian.pixup.model.Catalogos;
import org.hernandez.sierra.christian.pixup.util.ReadUtil;

public class Consola implements Ejecutable {

    private static Consola consola;

    private Consola()
    {
    }

    public static Consola getInstance()
    {
        if (consola==null){
            consola=new Consola();
        }
        return consola;
    }

    @Override
    public void run() {
        Ejecutable ejecutable=null;
        Menu menu=new Menu();
        boolean flag=true;
        int opcion;

        while(flag)
        {
            menu.principal2();
            opcion= ReadUtil.getInstance().leerInt();
            switch (opcion)
            {
                case 1:
                    ejecutable= Catalogos.getInstance();
                    break;
                case 2:
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
