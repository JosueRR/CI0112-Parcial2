
/**
 * Clase Estudiante: contiene un objeto tipo estudiante. Funciona como nodo para listas y arboles.
 * 
 * @author Josué Retana Rodríguez - C06440 
 * @version 25/11/2020
 */

public class Estudiante {
    //Atributos del objeto tipo estudiante
    private String nombre;
    private int carnet;
    private ListaNotas notas;
    private float promedio;
    private Estudiante siguiente;
    //Hijos tipo Estudiante para el arbol
    Estudiante hijoIzquierdo;
    Estudiante hijoDerecho;

    /**
     * Constructor de la clase (caso sin parámetros)  
     */
    public Estudiante() {
        this.nombre = "";
        this.carnet = 000;
        this.notas = null;
        this.promedio = 0;
        this.siguiente = null;
        hijoIzquierdo = null;
        hijoDerecho = null;
    }
    
    /**
     * Constructor de la clase (caso con parámetros) 
     */
    public Estudiante(String nombre, int carnet, ListaNotas notas, float promedio) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.notas = notas;
        this.promedio = promedio;
        this.siguiente = null;
        hijoIzquierdo = null;
        hijoDerecho = null;
    }
    
    //Setters y getters de nombre
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //Setters y getters de carnet
    public int getCarnet() {
        return carnet;
    }
    
    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }
    
    //Setters y getters de notas
    public ListaNotas getNotas() {
        return notas;
    }
    
    public void setNotas(ListaNotas notas) {
        this.notas = notas;
    }
    
    //Setters y getters de notas
    public float getPromedio() {
        return promedio;
    }
    
    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }
    
    //Métodos para obtener siguientes a un nodo de tipo Estudiante 
    public Estudiante getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(Estudiante siguiente) {
        this.siguiente = siguiente;
    }
    
    //Setters y getters de los hijos del arbol
    public Estudiante getHijoIzquierdo() {
        return hijoIzquierdo;
    }
    
    public void setHijoIzquierdo(Estudiante nuevoNodo) {
        hijoIzquierdo = nuevoNodo;
    }

    public Estudiante getHijoDerecho() {
        return hijoDerecho;
    }
    
    public void setHijoDerecho(Estudiante nuevoNodo) {
        hijoDerecho = nuevoNodo;
    }
}
