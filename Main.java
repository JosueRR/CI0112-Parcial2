
/**
 * Clase Main: clase principal del proyecto.
 * 
 * @author Josué Retana Rodríguez - C06440 
 * @version 1
 */

public class Main {
    public static void main (String args[]) {
        ListaNotas listaNotas = new ListaNotas();
        ListaEstudiante listaEstudiantes = new ListaEstudiante();
        float promedio;
        String listaEstudiantesString;
        
        listaNotas.agregarNota(2);
        listaNotas.agregarNota(5);
        listaNotas.agregarNota(6);
        listaNotas.agregarNota(8);
        
        promedio = listaNotas.retornarPromedio();
        
        listaEstudiantes.agregarEstudiante("Pepe", 06440, listaNotas, promedio);
        
        listaEstudiantesString = listaEstudiantes.toString(listaEstudiantes);
        System.out.println(listaEstudiantesString);
    }
}
