
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
        arbolBinario.recorrerEnOrden(arbolBinario.getRaiz());
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
}
