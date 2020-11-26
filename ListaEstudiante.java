
/**
 * Write a description of class ListaEstudiante here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaEstudiante {
    //Variables de la lista de tipo estudiantes
    private Estudiante inicio;
    private int tamanio;

    /**
     * Constructor de la clase
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

        if(esVacia()) {
            inicio = nuevoNodo;
        }
        else {
            if (nuevoNodo.getNombre().compareTo(auxiliar.getNombre()) <= 0 ) {
                nuevoNodo.setSiguiente(inicio);
                inicio = nuevoNodo;
            }
            else {
                while(auxiliar.getSiguiente() != null) {
                    if (nuevoNodo.getNombre().compareTo(auxiliar.getNombre()) <= 0 ) {
                        nuevoNodo.setSiguiente(auxiliar.getSiguiente());
                        auxiliar.setSiguiente(nuevoNodo);
                        break;
                    }
                    auxiliar = auxiliar.getSiguiente();
                }

                
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

