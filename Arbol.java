
/**
 * Write a description of class Arbol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arbol {
    //Varaibles del arbol binario
    Estudiante raiz;

    /**
     * Constructor de la clase
     */
    public Arbol() {
        raiz = null;
    }

    //Getter de la raiz del arbol
    public Estudiante getRaiz() {
        return raiz;
    }
    //tring nombre, int carnet, ListaNotas notas, float promedio
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

    public void agregarHijo(Estudiante estudiante) {
        raiz = agregarRecursivo(raiz, estudiante);
    }

}
