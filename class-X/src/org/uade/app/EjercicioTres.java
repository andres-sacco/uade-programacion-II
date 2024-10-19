package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.impl.ABBTDAImpl;

/*
Se recibe un arbol binario y se devuelve el nivel con mas nodos, desde el nivel 1 hasta nivelHasta.
En caso de que el árbol sea vacio se debera retornar cero.
Ante un empate debera retornar el número de nivel mas pequeño.

Ejemplo entrada
        4
      /   \
     2     6
    / \   / \
   1   3 5   7
 */
public class EjercicioTres {

    public static void main(String[] args) {
        EjercicioTres app = new EjercicioTres();
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

        int nivelHasta = 3; // Definimos hasta qué nivel contar

        int nivelConMasNodos = nivelConMasNodos(arbol, nivelHasta);
        System.out.println("El nivel con más nodos hasta el nivel " + nivelHasta + " es: " + nivelConMasNodos);
    }

    // Metodo que devuelve el nivel con más nodos
    // Internamente hace esto:
    //  - Verifica si el árbol está vacío; si es así, retorna 0.
    //  - Crea un arreglo (contadorNodosPorNivel) para contar el número de nodos en cada nivel.
    //  - Llama al metodo contarNodosPorNivel para llenar el arreglo con el conteo de nodos.
    //  - Recorre el arreglo para determinar cuál nivel tiene el mayor número de nodos, teniendo en cuenta los empates.
    public int nivelConMasNodos(ABBTDA arbol, int nivelHasta) {
        if (arbol.arbolVacio()) {
            return 0; // Si el árbol es vacío, retornamos 0
        }

        int[] contadorNodosPorNivel = new int[nivelHasta + 1];
        contarNodosPorNivel(arbol, 1, contadorNodosPorNivel, nivelHasta);

        // Encontrar el nivel con más nodos
        int nivelMaximo = 1;
        int maxNodos = contadorNodosPorNivel[1];

        for (int i = 2; i <= nivelHasta; i++) {
            if (contadorNodosPorNivel[i] > maxNodos) {
                maxNodos = contadorNodosPorNivel[i];
                nivelMaximo = i;
            }
        }

        return nivelMaximo; // Retornamos el nivel con más nodos
    }

    // Metodo recursivo para contar los nodos en cada nivel
    private void contarNodosPorNivel(ABBTDA nodo, int nivelActual, int[] contador, int nivelHasta) {
        if (nivelActual > nivelHasta || nodo.arbolVacio()) {
            return; // Salimos si hemos alcanzado el nivel máximo o el nodo es vacío
        }

        contador[nivelActual]++; // Incrementamos el contador para el nivel actual

        // Recursión en los hijos izquierdo y derecho
        contarNodosPorNivel(nodo.hijoIzq(), nivelActual + 1, contador, nivelHasta);
        contarNodosPorNivel(nodo.hijoDer(), nivelActual + 1, contador, nivelHasta);
    }

}