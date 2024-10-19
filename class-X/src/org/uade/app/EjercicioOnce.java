package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.impl.ABBTDAImpl;

/*
Calcular el producto de los nodos en los niveles pares e impares
Calcula el producto de los nodos en los niveles impares y el producto de los nodos en los niveles pares del árbol binario, luego retorna ambos productos.

Ejemplo entrada:
        10
      /    \
     5     15
    / \   /  \
   3   7 12  18
 */
public class EjercicioOnce {

    public static void main(String[] args) {
        EjercicioOnce app = new EjercicioOnce();
        app.execute();
    }

    public void execute() {
        ABBTDA arbol = new ABBTDAImpl();
        arbol.inicializarArbol();

        // Agregamos nodos al árbol
        arbol.agregar(10);
        arbol.agregar(5);
        arbol.agregar(15);
        arbol.agregar(3);
        arbol.agregar(7);
        arbol.agregar(12);
        arbol.agregar(18);

        // Obtener el producto de los nodos en niveles pares e impares
        int[] productos = productoNivelesParesImpares(arbol);
        System.out.println("Producto de niveles impares: " + productos[0]);
        System.out.println("Producto de niveles pares: " + productos[1]);

    }

    public int[] productoNivelesParesImpares(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return new int[]{1, 1};  // Si el árbol está vacío, retornamos el producto neutral para ambos
        }
        int[] productos = {1, 1}; // productos[0] para niveles impares, productos[1] para niveles pares
        productoNivelesRec(arbol, 1, productos);
        return productos;
    }

    // Metodo recursivo para calcular el producto de los nodos en niveles pares e impares
    private void productoNivelesRec(ABBTDA arbol, int nivelActual, int[] productos) {
        if (arbol.arbolVacio()) {
            return;
        }

        if (nivelActual % 2 == 1) {
            productos[0] *= arbol.raiz();  // Si el nivel es impar, multiplicamos en productos[0]
        } else {
            productos[1] *= arbol.raiz();  // Si el nivel es par, multiplicamos en productos[1]
        }

        // Continuamos recorriendo los subárboles izquierdo y derecho
        productoNivelesRec(arbol.hijoIzq(), nivelActual + 1, productos);
        productoNivelesRec(arbol.hijoDer(), nivelActual + 1, productos);
    }

}