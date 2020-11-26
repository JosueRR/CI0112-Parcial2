
/**
 * Clase ListaEstudiante: contiene una lista enlazada de un objeto tipo Estudiante.
 * 
 * @author Josué Retana Rodríguez - C06440 
 * @version 25/11/2020
 */

public class ListaEstudiante {
    //Atributos de la lista de tipo estudiantes
    private Estudiante inicio;
    private int tamanio;

    /**
     * Constructor de la clase sin parámetros
     */
    public void Lista() {
        inicio = null;
        tamanio = 0;
    }

    //Método de tipo boolean que indica si la lista se enceuntra vacía o no
    public boolean esVacia() {
        return inicio == null;
    }

    //Método de tipo int que indica el tamaño de la lista
    public int getTamanio() {
        return tamanio;
    }
    
    //Método que retorna el inico de una lista
    public Estudiante getInicio() {
        return inicio;
    }

    /**
     * Método que agrega estudiantes a la lista (alfabéticamente)
     */
    public void agregarEstudiante(String nombre, int carnet, ListaNotas notas, float promedio) {
        Estudiante nuevoNodo = new Estudiante();
        Estudiante auxiliar = inicio;
        nuevoNodo.setNombre(nombre);
        nuevoNodo.setCarnet(carnet);
        nuevoNodo.setNotas(notas);
        nuevoNodo.setPromedio(promedio);
        
        //En caso de ser el primer nodo
        if(esVacia()) {
            inicio = nuevoNodo;
        }
        else {
            //En caso de que solo haya un nodo en la lista y se debe realizar el movimiento
            if (nuevoNodo.getNombre().compareTo(auxiliar.getNombre()) <= 0 ) {
                nuevoNodo.setSiguiente(inicio);
                inicio = nuevoNodo;
            }
            else {
                while(auxiliar.getSiguiente() != null) {
                    //En caso de que el cambio se deba realizar en mitad de la lista
                    if (nuevoNodo.getNombre().compareTo(auxiliar.getNombre()) <= 0 ) {
                        nuevoNodo.setSiguiente(auxiliar.getSiguiente());
                        auxiliar.setSiguiente(nuevoNodo);
                        break;
                    }
                    auxiliar = auxiliar.getSiguiente();
                }

                //En caso de terner que agregarlo al final
                auxiliar.setSiguiente(nuevoNodo);
            }
        }
        tamanio++;
    }

    /**
     * Método toString, convierte la lista en un String
     */
    public String toString(ListaEstudiante listaEstudiantes) {
        String listaEstudiantesString = "";
        Estudiante auxiliar = inicio;
        
        //Ciclo que repite según el tamaño de la lista
        for (int posicion = 0; posicion < listaEstudiantes.getTamanio() ; posicion++) {
            listaEstudiantesString += "Estudiante: " + auxiliar.getNombre() + "\n";
            listaEstudiantesString += "Carnet: " + auxiliar.getCarnet() + "\n";
            listaEstudiantesString += "Promedio: " + auxiliar.getPromedio() + "\n";
            listaEstudiantesString += "--------------------------" + "\n" ;
            auxiliar = auxiliar.getSiguiente();
        }

        return listaEstudiantesString;
    }
}

