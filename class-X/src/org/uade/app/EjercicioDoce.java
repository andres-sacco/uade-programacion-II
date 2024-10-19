package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.impl.ABBTDAImpl;

/*
Encontrar la suma de los elementos en el nivel más profundo del árbol
Dado un árbol binario, encuentra el nivel más profundo y devuelve la suma de todos los nodos en ese nivel.

Ejemplo entrada:
        10
      /    \
     5     15
    / \   /  \
   3   7 12  18
 */
public class EjercicioDoce {

    public static void main(String[] args) {
        EjercicioDoce app = new EjercicioDoce();
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

        // Suma de los nodos en el nivel más profundo
        int suma = sumaNivelMasProfundo(arbol);
        System.out.println("Suma en el nivel más profundo: " + suma);


    }

    // Metodo principal para encontrar la suma de los nodos en el nivel más profundo
    public int sumaNivelMasProfundo(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;  // Si el árbol está vacío, la suma es 0
        }

        int profundidadMaxima = encontrarProfundidadMaxima(arbol, 1);  // Encontramos la profundidad máxima
        return sumarNodosEnNivel(arbol, 1, profundidadMaxima);  // Sumamos los nodos en el nivel más profundo
    }

    // Metodo para encontrar la profundidad máxima del árbol
    private int encontrarProfundidadMaxima(ABBTDA arbol, int nivelActual) {
        if (arbol.arbolVacio()) {
            return nivelActual - 1;  // Si llegamos a un nodo vacío, retornamos el nivel anterior
        }

        // Encontramos la profundidad máxima en los subárboles izquierdo y derecho
        int profundidadIzq = encontrarProfundidadMaxima(arbol.hijoIzq(), nivelActual + 1);
        int profundidadDer = encontrarProfundidadMaxima(arbol.hijoDer(), nivelActual + 1);

        // Retornamos la mayor profundidad encontrada
        return Math.max(profundidadIzq, profundidadDer);
    }

    // Metodo para sumar los nodos en un nivel dado
    private int sumarNodosEnNivel(ABBTDA arbol, int nivelActual, int nivelObjetivo) {
        if (arbol.arbolVacio()) {
            return 0;  // Si llegamos a un nodo vacío, no suma nada
        }

        if (nivelActual == nivelObjetivo) {
            return arbol.raiz();  // Si estamos en el nivel objetivo, retornamos el valor del nodo
        }

        // Sumamos los nodos en los subárboles izquierdo y derecho
        int sumaIzq = sumarNodosEnNivel(arbol.hijoIzq(), nivelActual + 1, nivelObjetivo);
        int sumaDer = sumarNodosEnNivel(arbol.hijoDer(), nivelActual + 1, nivelObjetivo);

        return sumaIzq + sumaDer;  // Retornamos la suma total
    }

}