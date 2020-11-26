
/**
 * Clase ListaNotas: contiene una lista enlazada de un objeto tipo notas.
 * 
 * @author Josué Retana Rodríguez - C06440 
 * @version 25/11/2020
 */

public class ListaNotas {
    //Atributos de la lista tipo notas
    private NodoNotas inicio;
    private int tamanio;
    float sumaNotas = 0;
    float cantidadNotas = 0;
    float promedio = 0;

    /**
     * Constructor de la clase
     */
    public void Lista() {
        inicio = null;
        tamanio = 0;
    }

    /**
     * Método de tipo boolean que indica si la lista se enceuntra vacía o no
     */
    public boolean esVacia() {
        return inicio == null;
    }

    /**
     * Método de tipo int que indica el tamaño de la lista
     */
    public int getTamanio() {
        return tamanio;
    }

    /**
     * Método que agrega notas a la lista (funciona como una cola)
     */
    public void agregarNota(float notaMateria) {
        NodoNotas nuevoNodo = new NodoNotas();
        nuevoNodo.setNotaMateria(notaMateria);

        if(esVacia()) {
            inicio = nuevoNodo;
        }
        else {
            NodoNotas auxiliar = inicio;

            while(auxiliar.getSiguiente() != null) {
                auxiliar = auxiliar.getSiguiente();
            }

            auxiliar.setSiguiente(nuevoNodo);
        }
        tamanio++;
    }

    /**
     * Método que calcula un promedio de notas de un lista de notas de forma recursiva
     */
    public float calcularPromedioRecursivo(NodoNotas auxiliar) {
        if(esVacia()) {
            return 0;
        }
        else if (auxiliar == null) {
            return promedio;
        }
        else {
            cantidadNotas++;
            sumaNotas += auxiliar.getNotaMateria();
            promedio = sumaNotas/cantidadNotas;
            auxiliar = auxiliar.getSiguiente();
            return calcularPromedioRecursivo(auxiliar);
        }
    }
    
    /**
     * Método que retornar un promedio de un grupo de notas
     */
    public float retornarPromedio() {
        NodoNotas auxiliar = inicio;
        return calcularPromedioRecursivo(auxiliar);
    }
}

