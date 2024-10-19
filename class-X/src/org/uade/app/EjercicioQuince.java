package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.api.ColaTDA;
import org.uade.impl.ABBTDAImpl;
import org.uade.impl.ColaTDAImpl;
import org.uade.operacion.OperacionArbol;

/*
Dado un array de int, que contiene los valores de un arbol en pre-orden.
Se pide que se cree y se cargue el arbol
 */
public class EjercicioQuince {

    public static void main(String[] args) {
        EjercicioQuince app = new EjercicioQuince();
        app.execute();
    }

    public void execute() {
        ABBTDA arbol = new ABBTDAImpl();
        arbol.inicializarArbol();

        // Array en postorden
        int[] postorden = {10, 5, 3, 8, 20, 15, 30};

        construirDesdePostorden(postorden, arbol);

        OperacionArbol operacion = new OperacionArbol();
        operacion.mostrarArbolInorden(arbol);
    }

    public void construirDesdePostorden(int[] postorden, ABBTDA arbol) {
        // Inicializamos el árbol
        arbol.inicializarArbol();

        // Insertamos los elementos del array en orden inverso
        for (int i = postorden.length - 1; i >= 0; i--) {
            arbol.agregar(postorden[i]);
        }
    }
}