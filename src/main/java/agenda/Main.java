/*
 * Grupo        : gdam 11
 * Alumno       : Fabio
 * Numero Exp   : 
 * Fecha
 */


package agenda;

import exceptions.ContactoRepetidoException;
import java.util.ArrayList;

/**
 *
 * @author loned
 */
public class Main {

    public static void ListaAgenda(Agenda a){
    
        ArrayList<Contacto> Listado = new ArrayList<>();
        Listado = a.getContactos();
        System.out.print("AGENDA: ");
        System.out.print(a.getnombreAgenda(a));
        System.out.println("\t\tNum.Contactos:"+Listado.size());
        System.out.format("%-24s%-15s%-15s\n", "eMail","Teléfono","Nombre");
        System.out.println("-----------------------------------------------------");
        for (Contacto c : Listado){
            System.out.format("%-24s%-15s%-15s\n",c.getEmail(),c.getTelefono(),c.getNombre());
        }
        System.out.println("-----------------------------------------------------");
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Contacto c1,c2,c3;
        System.out.println("Practica5.- Pruebas Junit");
        Agenda Lista = new Agenda("ag1");
        Contacto contacto1 = new Contacto("email_1","555 555 551","empleado_1");
        Contacto contacto2 = new Contacto("rmsces2122@gmail.com","555 555 552","Ramón");
        //Contacto contacto2 = new Contacto(null,null,null);
        System.out.println("-- Añadiendo los contactos ---");
            try {
                c1=Lista.addContacto(contacto1);
                c2=Lista.addContacto(contacto2);
            } catch (ContactoRepetidoException ex) {
                 System.out.println(ex); 
            }
        System.out.println("-- Listando los contactos añadidos ---");
           System.out.println(Lista.getContactos().toString());
           ListaAgenda(Lista);
        System.out.println("-- Eliminando contacto con email_1 ...");
            Lista.eliminarContacto("email_1");
        System.out.println("-- Buscando contacto2  ..."); 
            c3 =Lista.buscarContacto(contacto2.getEmail());
            if (c3 != null){ System.out.println(c3.toString()); 
           }
            else{
                System.out.println("Contacto no encontrado!");
            }
        System.out.println("..........................");
      
        System.out.println("Cerrando la Agenda!");
    }
    }
    
