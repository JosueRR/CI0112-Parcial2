
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
            System.out.println("Entró 1");
            return new Estudiante(estudiante.getNombre(), estudiante.getCarnet(), estudiante.getNotas(), estudiante.getPromedio());
        }
        else if( estudiante.getPromedio() < actual.getPromedio() ) {
            System.out.println("Entró 2");
            actual.setHijoIzquierdo(agregarRecursivo(actual.getHijoIzquierdo(), estudiante));
        }
        else if( estudiante.getPromedio() > actual.getPromedio() ) {
            System.out.println("Entró 3");
            actual.setHijoDerecho(agregarRecursivo(actual.getHijoDerecho(), estudiante));
        }
        else {
            System.out.println("Entró 4");
            return actual;
        }
        System.out.println("Entró 5");
        return actual;
    }

    public void agregarHijo(Estudiante estudiante) {
        System.out.println("Agrego hijo");
        raiz = agregarRecursivo(raiz, estudiante);
    }

    public void recorrerEnOrden(Estudiante nodoActual) {
        if( nodoActual != null)
        {
            recorrerEnOrden(nodoActual.getHijoIzquierdo());
            System.out.println("El nombre es: " + nodoActual.getNombre() 
            + " y el promedio corresponde a: " + nodoActual.getPromedio());
            recorrerEnOrden(nodoActual.getHijoDerecho());
        }
    }
}
