
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
        float entradaPromedio;

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
        //Se muestra la lista ingresada al usuario y se crea el arbol binario
        listaEstudiantesString = listaEstudiantes.toString(listaEstudiantes);
        JOptionPane.showMessageDialog(null,"LISTA INGRESADA\n"
            + listaEstudiantesString);
        crearArbol(listaEstudiantes);

        //Condicional que se repite hasta que usuario desee salir del programa                                       
        while (! "s".equals (entrada)) {
            entrada= JOptionPane.showInputDialog ( "¿Qué desea hacer?\n"               
                + "a. Mostrar todos los estudiantes que tengan un promedio mayor al ingresado.\n"
                + "b. Mostrar todos los estudiantes que tengan un promedio menor al ingresado.\n"
                + "c. Mostrar todos los estudiantes que tengan un promedio igual al ingresado. \n"
                + "d. Mostrar todos los estudiantes con su promedio."
                + "s. Salir.\n");
            switch (entrada.toLowerCase()) {
                case "a":
                entradaPromedio = Float.parseFloat(JOptionPane.showInputDialog("Digite el promedio que desea utilizar"));
                imprimirMayores(entradaPromedio, arbolBinario.getRaiz());
                break;
                
                case "b":
                entradaPromedio = Float.parseFloat(JOptionPane.showInputDialog("Digite el promedio que desea utilizar"));
                imprimirMenores(entradaPromedio, arbolBinario.getRaiz());
                break;
                
                case "c":
                entradaPromedio = Float.parseFloat(JOptionPane.showInputDialog("Digite el promedio que desea utilizar"));
                imprimirIguales(entradaPromedio, arbolBinario.getRaiz());
                break;
                
                case "d":
                imprimirTodos(arbolBinario.getRaiz());
                break;
                
                case "s":
                JOptionPane.showMessageDialog(null,"¡Gracias por utilizar el programa!");
                break;        
            }    
        }
    }

    /**
     * Método que crea un arbol con base a una lista
     */
    public static void crearArbol(ListaEstudiante listaEstudiantes) {
        Estudiante auxiliar = listaEstudiantes.getInicio();
        for (int posicion = 0; posicion < listaEstudiantes.getTamanio(); posicion++ ) {
            arbolBinario.agregarHijo(auxiliar);
            auxiliar = auxiliar.getSiguiente();
        }
    }

    /**
     * Método  recibe un promedio e imprime los datos de los Estudiantes que tienen un promedio menor al
     * indicado
     */
    public static void imprimirMenores(float promedio, Estudiante nodoActual) {
        if( nodoActual != null) {
            imprimirMenores(promedio, nodoActual.getHijoIzquierdo());
            if (nodoActual.getPromedio() < promedio) {
                System.out.println("El nombre es: " + nodoActual.getNombre() 
                    + " y el promedio corresponde a: " + nodoActual.getPromedio());
            }
            imprimirMenores(promedio, nodoActual.getHijoDerecho());
        }
    }

    /**
     * Método que recibe un promedio e imprime los datos de los Estudiantes que tienen un promedio igual al
     * indicado
     */
    public static void imprimirIguales(float promedio, Estudiante nodoActual) {
        if( nodoActual != null) {
            imprimirIguales(promedio, nodoActual.getHijoIzquierdo());
            if (nodoActual.getPromedio() == promedio) {
                System.out.println("El nombre es: " + nodoActual.getNombre() 
                    + " y el promedio corresponde a: " + nodoActual.getPromedio());
            }
            imprimirIguales(promedio, nodoActual.getHijoDerecho());
        }
    }

    /**
     * Método recibe un promedio e imprime los datos de los Estudiantes que tienen un promedio mayor al
     * indicado
     */
    public static void  imprimirMayores(float promedio, Estudiante nodoActual) {
        if( nodoActual != null) {
            imprimirMayores(promedio, nodoActual.getHijoIzquierdo());
            if (nodoActual.getPromedio() > promedio) {
                System.out.println("El nombre es: " + nodoActual.getNombre() 
                    + " y el promedio corresponde a: " + nodoActual.getPromedio());
            }
            imprimirMayores(promedio, nodoActual.getHijoDerecho());
        }
    }

    /**
     * Método que imprime todos los promedios con sus respectivos estudiantes
     */
    public static void imprimirTodos(Estudiante nodoActual) {
        if( nodoActual != null) {
            imprimirTodos(nodoActual.getHijoIzquierdo());
            System.out.println("El nombre es: " + nodoActual.getNombre() 
                + " y el promedio corresponde a: " + nodoActual.getPromedio());
            imprimirTodos(nodoActual.getHijoDerecho());
        }
    }
}