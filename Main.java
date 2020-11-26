
/**
 * Clase Main: clase principal del proyecto.
 * 
 * @author Josué Retana Rodríguez - C06440 
 * @version 1
 */

import javax.swing.JOptionPane;

public class Main {

    static ListaNotas listaNotas = new ListaNotas();
    static ListaEstudiante listaEstudiantes = new ListaEstudiante();
    static Arbol arbolBinario = new Arbol();

    public static void main (String args[]) {

        float promedio;
        String listaEstudiantesString;
        String entrada = "";
        String nombreEstudiante;
        int carnetEstudiante;
        float notasEstudiante;

        //Ciclo que se repite hasta que el usuario decida no ingresar más alumnos
        while (! "b".equals (entrada)){
            listaNotas = new ListaNotas();
            entrada= JOptionPane.showInputDialog ( "¿Desea ingresar un estudiante?\n"               
                + "a. Sí.\n"
                + "b. No.\n");

            //Dependiendo del caso (ingresar más alumnos o no)
            switch (entrada.toLowerCase()){
                case "a":
                nombreEstudiante = JOptionPane.showInputDialog("Escriba el nombre del estudiante");
                carnetEstudiante = Integer.parseInt(JOptionPane.showInputDialog("Escriba el carnet del estudiante"));
                notasEstudiante = Float.parseFloat(JOptionPane.showInputDialog("Digite una nota del estudiante"));
                listaNotas.agregarNota(notasEstudiante);
                //Ciclo que se repite hasta que el usuario decida no ingresar más notas 
                while (! "d".equals (entrada)) {
                    entrada= JOptionPane.showInputDialog ( "¿Desea ingresar una nota más?\n"               
                        + "c. Sí.\n"
                        + "d. No.\n");

                    //Dependiendo del caso (ingresar más notas o no)
                    switch (entrada.toLowerCase()) {
                        case "c":
                        notasEstudiante = Float.parseFloat(JOptionPane.showInputDialog("Digite una nota del estudiante"));
                        listaNotas.agregarNota(notasEstudiante);
                        break;

                        case "d":
                        JOptionPane.showMessageDialog(null,"No serán añadidas más notas para este estudiante");
                        break;
                    }
                }
                promedio = listaNotas.retornarPromedio();
                listaEstudiantes.agregarEstudiante(nombreEstudiante, carnetEstudiante, listaNotas, promedio);
                break;

                case "b":
                JOptionPane.showMessageDialog(null,"No serán añadidos más estudiantes");
                break;
            }
        }  
        listaEstudiantesString = listaEstudiantes.toString(listaEstudiantes);
        JOptionPane.showMessageDialog(null,listaEstudiantesString);

        crearArbol(listaEstudiantes);
        //arbolBinario.recorrerEnOrden(arbolBinario.getRaiz());
        imprimirMenores(1, arbolBinario.getRaiz(), arbolBinario);
    }

    /**
     * Método qeu crea un arbol con base a una lista
     */
    public static void crearArbol(ListaEstudiante listaEstudiantes) {
        Estudiante auxiliar = listaEstudiantes.getInicio();
        System.out.println("El inico es: " + listaEstudiantes.getInicio().getNombre());
        for (int posicion = 0; posicion < listaEstudiantes.getTamanio(); posicion++ ) {
            arbolBinario.agregarHijo(auxiliar);
            auxiliar = auxiliar.getSiguiente();
        }
    }

    /**
     * Método  recibe un promedio e imprime los datos de los Estudiantes que tienen un promedio menor al
     * indicado
     */
    public static void imprimirMenores(float promedio, Estudiante nodoActual, Arbol arbolBinario) {
        if( nodoActual != null)
        {
            arbolBinario.recorrerEnOrden(nodoActual.getHijoIzquierdo());
            System.out.println("El nombre es: " + nodoActual.getNombre() 
            + " y el promedio corresponde a: " + nodoActual.getPromedio());
            arbolBinario.recorrerEnOrden(nodoActual.getHijoDerecho());
        }
    }

    /**
     * Método que recibe un promedio e imprime los datos de los Estudiantes que tienen un promedio igual al
     * indicado
     */
    public static void imprimirIguales(float promedio) {
    }

    /**
     * Método recibe un promedio e imprime los datos de los Estudiantes que tienen un promedio mayor al
     * indicado
     */
    public static void  imprimirMayores(float promedio) {
    }
}
