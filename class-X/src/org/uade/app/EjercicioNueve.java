package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.impl.ABBTDAImpl;

/*
Encontrar el nodo con el valor más grande en un nivel dado
Dado un árbol binario y un nivel k, encuentra el valor máximo presente en ese nivel.

Ejemplo entrada:
        4
      /   \
     2     6
    / \   / \
   1   3 5   7
 */
public class EjercicioNueve {

    public static void main(String[] args) {
        EjercicioNueve app = new EjercicioNueve();
        app.execute();
    }

    public void execute() {
        ABBTDA arbol = new ABBTDAImpl();
        arbol.inicializarArbol();

        // Agregar algunos valores al árbol
        arbol.agregar(4);
        arbol.agregar(2);
        arbol.agregar(6);
        arbol.agregar(1);
        arbol.agregar(3);
        arbol.agregar(5);
        arbol.agregar(7);

        // Buscar el valor máximo en el nivel 2
        int maxValorNivel2 = maxEnNivel(arbol, 2);
        System.out.println("Valor máximo en el nivel 2: " + maxValorNivel2);

        // Buscar el valor máximo en el nivel 3
        int maxValorNivel3 = maxEnNivel(arbol, 3);
        System.out.println("Valor máximo en el nivel 3: " + maxValorNivel3);
    }


    public int maxEnNivel(ABBTDA arbol, int k) {
        if (arbol.arbolVacio()) {
            return Integer.MIN_VALUE;  // Si el árbol está vacío, devolvemos el menor entero posible.
        }
        return maxEnNivelRec(arbol, 1, k);
    }

    // Método recursivo para encontrar el valor máximo en el nivel k
    private int maxEnNivelRec(ABBTDA arbol, int nivelActual, int k) {
        if (arbol.arbolVacio()) {
            return Integer.MIN_VALUE;  // Si llegamos a un nodo vacío, devolvemos el menor valor posible
        }

        if (nivelActual == k) {
            return arbol.raiz();  // Si llegamos al nivel k, devolvemos el valor del nodo actual
        }

        // Buscamos en los subárboles izquierdo y derecho
        int maxIzq = maxEnNivelRec(arbol.hijoIzq(), nivelActual + 1, k);
        int maxDer = maxEnNivelRec(arbol.hijoDer(), nivelActual + 1, k);

        // Retornamos el mayor valor entre los dos subárboles
        return Math.max(maxIzq, maxDer);
    }
}