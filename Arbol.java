
/**
 * Clase Arbol: contiene un arbol binario, de tipo Estudiante. Contiene atributos y funciones relacionadas
 * 
 * @author Josué Retana Rodríguez - C06440 
 * @version 25/11/2020
 */

public class Arbol {
    //Raiz del arbol tipo estudiante
    Estudiante raiz;

    /**
     * Constructor de la clase
     */
    public Arbol() {
        raiz = null;
    }

    /**
     * Getter de la raiz del arbol
     */
    public Estudiante getRaiz() {
        return raiz;
    }
    
    /**
     * Método que agrega de forma recursiva un estudiante a un hijo según el caso
     */
    private Estudiante agregarRecursivo(Estudiante actual, Estudiante estudiante) {
        if(actual == null) {
            return new Estudiante(estudiante.getNombre(), estudiante.getCarnet(), estudiante.getNotas(), estudiante.getPromedio());
        }
        else if( estudiante.getPromedio() < actual.getPromedio() ) {
            actual.setHijoIzquierdo(agregarRecursivo(actual.getHijoIzquierdo(), estudiante));
        }
        else if( estudiante.getPromedio() > actual.getPromedio() ) {
            actual.setHijoDerecho(agregarRecursivo(actual.getHijoDerecho(), estudiante));
        }
        else {
            return actual;
        }
        return actual;
    }
    
    /**
     * Método que se encarga de crear/actualizar la raiz del arbol 
     * Realiza un llamado al método recursivo anterior
     */
    public void agregarHijo(Estudiante estudiante) {
        raiz = agregarRecursivo(raiz, estudiante);
    }
}
