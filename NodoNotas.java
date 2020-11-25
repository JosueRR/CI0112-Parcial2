
/**
 * Write a description of class NodoNotas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class NodoNotas {
    //Variables del objeto nodo notas
    private float notaMateria;
    private NodoNotas siguiente;

    /**
     * Constructor de la clase  
     */
    public void Nodo()
    {
        this.notaMateria = 0;
        this.siguiente = null;
    }
    
    //Setters y getters de nota
    public float getNotaMateria()
    {
        return notaMateria;
    }
    
    public void setNotaMateria(float notaMateria)
    {
        this.notaMateria = notaMateria;
    }
    
    //Métodos para obtener siguientes a un nodo de tipo notas
    public NodoNotas getSiguiente()
    {
        return siguiente;
    }
    
    public void setSiguiente(NodoNotas siguiente)
    {
        this.siguiente = siguiente;
    }
}
