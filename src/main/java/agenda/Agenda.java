
package agenda;

//import exceptions.ContactoInexistenteException;
import exceptions.ContactoRepetidoException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author loned
 */
public class Agenda {

    private HashMap<String, Contacto> contactos = new HashMap();
    private static int n = 0;
    private static int count = 0;

    Agenda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
     
    /**
     * Añade un contacto a la agenda
     * @param contacto Contacto que queremos añadir
     * @return Objeto contacto añadido o genera una excepción si ya existía
     * @throws ContactoRepetidoException Excepción programada, ver paquete excepction
     */
 
    public Contacto addContacto(Contacto contacto) throws ContactoRepetidoException {
        if (contactos.containsKey(contacto.getEmail())) {
            //
            throw new ContactoRepetidoException("Ya existe un contacto con email: " + contacto.getEmail());
        }
        n++;
        contacto.setN(n);
        contactos.put(contacto.getEmail(), contacto);
        count++;
        return contacto;
    }

    /**
     * Elimina contacto
     * @param email Contacto que queremos eliminar
     * @return Devuelve el contacto si lo eliminia y si no un null
     */
    
    public Contacto eliminarContacto(String email) { 
        Contacto contacto = buscarContacto(email);
        if (contacto != null) {
        contactos.remove(email);
        count--;
        }
        return contacto;
    }

    /**
     * Busca un contacto
     * @param email Contacto que queremos buscar
     * @return Nulo si el contacto no está, y si está te muestra el contacto
     */
    
    public Contacto buscarContacto(String email) { 
        Contacto contacto = null;
        if (!contactos.containsKey(email)) {

            return null;
        }
        else{
        return contactos.get(email);
        }
    }

    /**
     * Muestra una lista de los contactos
     * @return Una lista del objeto contacto
     */
    
    public ArrayList<Contacto> getContactos() {
        ArrayList<Contacto> contactosList = new ArrayList<>();
        contactosList.addAll(contactos.values());
        return contactosList;
    }
    
    private static String nombreAgenda="";

    public String getnombreAgenda(Agenda a){
            return this.nombreAgenda;
    }
    public void setnombreAgenda(String name){
            this.nombreAgenda=name;
    }

    public Agenda(String name){
    
        if (name != ""){
            this.nombreAgenda = name;
        }
        else this.nombreAgenda ="Untitled";
    }   
    

}
