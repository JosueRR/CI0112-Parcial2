
/**
 * Clase Grupo: clase principal del proyecto (contiene el main para el llamado) y métodos de impresión.
 * 
 * @author Josué Retana Rodríguez - C06440 
 * @version 25/11/2020
 */

import javax.swing.JOptionPane;

public class GrupoMain {
    //Varaibles que se utilizan para almacenar y hacer llamadas a otras clases
    static ListaNotas listaNotas = new ListaNotas();
    static ListaEstudiante listaEstudiantes = new ListaEstudiante();
    static Arbol arbolBinario = new Arbol();
    static String listaEstudiantesFiltrados;
    
    /**
     * Clase Main del protoyecto
     */
    public static void main (String args[]) {
        //Varaibles tipo String de clase (almacenan entradas y listas)
        String listaEstudiantesString;
        String entrada = "";
        String nombreEstudiante;
        //Varaibles tipo float e int de la clase (almacenan el promedio, las notas y promedio que el usuario desea comparar)
        int carnetEstudiante;
        float notasEstudiante;
        float entradaPromedio;
        float promedio;
        
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
                //Se crea y agrega el nodo a la lista
                promedio = listaNotas.retornarPromedio();
                listaEstudiantes.agregarEstudiante(nombreEstudiante, carnetEstudiante, listaNotas, promedio);
                break;
                
                //No se desea agregar más estudiantes a la lista (mensaje informativo)
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

        //Condicional que se repite hasta que usuario desee salir del programa (comparaciones e imprisiones)                                       
        while (! "s".equals (entrada)) {
            entrada= JOptionPane.showInputDialog ( "¿Qué desea hacer?\n"               
                + "a. Mostrar todos los estudiantes que tengan un promedio mayor al ingresado.\n"
                + "b. Mostrar todos los estudiantes que tengan un promedio menor al ingresado.\n"
                + "c. Mostrar todos los estudiantes que tengan un promedio igual al ingresado. \n"
                + "d. Mostrar todos los estudiantes con su promedio. \n"
                + "s. Salir.\n");
            //Dependiendo del caso (comparar algún promedio o salir)    
            switch (entrada.toLowerCase()) {
                //En cada caso se llama el método que corresponda 
                //Los condicionales verifican si hubo o no coincidencias, según el caso lo informa o imprime el resultado 
                
                
                case "a":
                listaEstudiantesFiltrados = "";
                entradaPromedio = Float.parseFloat(JOptionPane.showInputDialog("Digite el promedio que desea utilizar"));
                listaEstudiantesFiltrados = imprimirMayores(entradaPromedio, arbolBinario.getRaiz());
                if (listaEstudiantesFiltrados == "") {
                    JOptionPane.showMessageDialog(null,"No hay concidencias");
                }
                else {
                    JOptionPane.showMessageDialog(null,listaEstudiantesFiltrados);
                }
                break;

                case "b":
                listaEstudiantesFiltrados = "";
                entradaPromedio = Float.parseFloat(JOptionPane.showInputDialog("Digite el promedio que desea utilizar"));
                listaEstudiantesFiltrados = imprimirMenores(entradaPromedio, arbolBinario.getRaiz());
                if (listaEstudiantesFiltrados == "") {
                    JOptionPane.showMessageDialog(null,"No hay concidencias");
                }
                else {
                    JOptionPane.showMessageDialog(null,listaEstudiantesFiltrados);
                }
                break;

                case "c":
                listaEstudiantesFiltrados = "";
                entradaPromedio = Float.parseFloat(JOptionPane.showInputDialog("Digite el promedio que desea utilizar"));
                listaEstudiantesFiltrados = imprimirIguales(entradaPromedio, arbolBinario.getRaiz());
                if (listaEstudiantesFiltrados == "") {
                    JOptionPane.showMessageDialog(null,"No hay concidencias");
                }
                else {
                    JOptionPane.showMessageDialog(null,listaEstudiantesFiltrados);
                }
                break;

                case "d":
                listaEstudiantesFiltrados = "";
                listaEstudiantesFiltrados = imprimirTodos(arbolBinario.getRaiz());
                if (listaEstudiantesFiltrados == "") {
                    JOptionPane.showMessageDialog(null,"No hay concidencias");
                }
                else {
                    JOptionPane.showMessageDialog(null,listaEstudiantesFiltrados);
                }
                break;
                
                case "s":
                JOptionPane.showMessageDialog(null,"¡Gracias por utilizar el programa!");
                break;        
            }    
        }
    }

    /**
     * Método que crea un arbol con base a una lista de estudiantes
     * El arbol se organiza de menor a mayor
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
    public static String imprimirMenores(float promedio, Estudiante nodoActual) {
        if(nodoActual != null) {
            imprimirMenores(promedio, nodoActual.getHijoIzquierdo());
            if (nodoActual.getPromedio() < promedio) {
                listaEstudiantesFiltrados += "El nombre es: " + nodoActual.getNombre() 
                + " y el promedio corresponde a: " + nodoActual.getPromedio() + "\n";
            }
            imprimirMenores(promedio, nodoActual.getHijoDerecho());
            return listaEstudiantesFiltrados;
        }
        return listaEstudiantesFiltrados;
    }

    /**
     * Método que recibe un promedio e imprime los datos de los Estudiantes que tienen un promedio igual al
     * indicado
     */
    public static String imprimirIguales(float promedio, Estudiante nodoActual) {
        if( nodoActual != null) {
            imprimirIguales(promedio, nodoActual.getHijoIzquierdo());
            if (nodoActual.getPromedio() == promedio) {
                listaEstudiantesFiltrados += "El nombre es: " + nodoActual.getNombre() 
                + " y el promedio corresponde a: " + nodoActual.getPromedio() + "\n";
            }
            imprimirIguales(promedio, nodoActual.getHijoDerecho());
            return listaEstudiantesFiltrados;
        }
        return listaEstudiantesFiltrados;
    }

    /**
     * Método recibe un promedio e imprime los datos de los Estudiantes que tienen un promedio mayor al
     * indicado
     */
    public static String  imprimirMayores(float promedio, Estudiante nodoActual) {
        if( nodoActual != null) {
            imprimirMayores(promedio, nodoActual.getHijoIzquierdo());
            if (nodoActual.getPromedio() > promedio) {
                listaEstudiantesFiltrados += "El nombre es: " + nodoActual.getNombre() 
                + " y el promedio corresponde a: " + nodoActual.getPromedio() + "\n";
            }
            imprimirMayores(promedio, nodoActual.getHijoDerecho());
            return listaEstudiantesFiltrados;
        }
        return listaEstudiantesFiltrados;
    }

    /**
     * Método que imprime todos los promedios con sus respectivos estudiantes
     */
    public static String imprimirTodos(Estudiante nodoActual) {
        if( nodoActual != null) {
            imprimirTodos(nodoActual.getHijoIzquierdo());
            listaEstudiantesFiltrados += "El nombre es: " + nodoActual.getNombre() 
            + " y el promedio corresponde a: " + nodoActual.getPromedio() + "\n";
            imprimirTodos(nodoActual.getHijoDerecho());
        }
        return listaEstudiantesFiltrados;
    }
}