/*
@authores : Eli y Dina
 */

package presentacion.components;

/**
 *
 * @author Administrador
 */
public class ComboItem {
    int id;
    String nombre;
    public ComboItem(int Id, String Nombre){
        this.id= Id;
        this.nombre = Nombre;
    }
    @Override
    public String toString() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
