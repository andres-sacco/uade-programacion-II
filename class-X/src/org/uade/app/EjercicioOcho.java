package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.impl.ABBTDAImpl;

/*
Verificar si el árbol es un árbol completo hasta un nivel k
Dado un árbol binario y un entero k, verifica si el árbol está completo hasta el nivel k.
Un árbol completo tiene todos los nodos llenos en todos sus niveles.

Ejemplo entrada:
        4
      /   \
     2     6
    / \   / \
   1   3 5   7
 */
public class EjercicioOcho {

    public static void main(String[] args) {
        EjercicioOcho app = new EjercicioOcho();
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

        // Verificamos si el árbol es completo hasta el nivel 2
        System.out.println("Es completo hasta el nivel 3: " + esCompletoHastaNivel(arbol, 3));

        // Verificamos si el árbol es completo hasta el nivel 3
        System.out.println("Es completo hasta el nivel 4: " + esCompletoHastaNivel(arbol, 4));
    }


    private boolean esCompletoHastaNivel(ABBTDA arbol, int k) {
        if (arbol.arbolVacio()) {
            return true;  // Un árbol vacío se considera completo
        }
        return esCompletoHastaNivelRec(arbol, 1, k);
    }

    // Metodo recursivo para verificar si el árbol es completo hasta el nivel k
    private boolean esCompletoHastaNivelRec(ABBTDA arbol, int nivelActual, int k) {
        if (arbol.arbolVacio()) {
            return true;  // Si llegamos a un nodo vacío, no afecta la completitud
        }

        if (nivelActual > k) {
            return true;  // No necesitamos verificar niveles más allá de k
        }

        // Si estamos en un nivel menor a k, ambos hijos deben existir
        if (nivelActual < k) {
            if (arbol.hijoIzq().arbolVacio() || arbol.hijoDer().arbolVacio()) {
                return false;  // Un nodo en nivel menor a k debe tener ambos hijos
            }
        }

        // Verificamos los subárboles izquierdo y derecho
        return esCompletoHastaNivelRec(arbol.hijoIzq(), nivelActual + 1, k)
                && esCompletoHastaNivelRec(arbol.hijoDer(), nivelActual + 1, k);
    }
}