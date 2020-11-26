
/**
 * Clase NodoNotas: contiene los atributos del nodo de la lista de tipo notas.
 * 
 * @author Josué Retana Rodríguez - C06440 
 * @version 25/11/2020
 */

public class NodoNotas {
    //Atributos del nodo notas
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
