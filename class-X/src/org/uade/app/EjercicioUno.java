package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.impl.ABBTDAImpl;
/*
Recibe un árbol (a) y dos enteros (desde y hasta) mayores a 0.
Retorna la cantidad de nodos ubicados entre los niveles desde y hasta del árbol a.

En caso de no haber ningún nodo entre los niveles dados o que éstos no sean válidos (desde>hasta), se deberá
retornar 0. Recordar que (en caso de existir) la raíz de un árbol ocupa el nivel 1.

Ejemplo Entrada:
        4
      /   \
     2     5
    / \     \
   1   3     6
Salida: 5
*/

public class EjercicioUno {

    public static void main(String[] args) {
        EjercicioUno app = new EjercicioUno();
        app.execute();
    }

    public void execute() {
        ABBTDA arbol = new ABBTDAImpl();
        arbol.inicializarArbol();

        arbol.agregar(4);
        arbol.agregar(2);
        arbol.agregar(5);
        arbol.agregar(6);
        arbol.agregar(1);
        arbol.agregar(3);

        int valor = contarNodosEntreNiveles(arbol, 2, 4);
        System.out.println("La suma de valores es: " + valor);
    }

    public int contarNodosEntreNiveles(ABBTDA a, int desde, int hasta) {
        // Validación de los parámetros
        if (desde > hasta || desde <= 0 || hasta <= 0 || a.arbolVacio()) {
            return 0;
        }

        // Iniciamos el recorrido en profundidad a partir de la raíz en el nivel 1
        return contarNodosRecursivo(a, 1, desde, hasta);
    }

    // Metodo recursivo para contar los nodos entre los niveles "desde" y "hasta"
    private int contarNodosRecursivo(ABBTDA a, int nivelActual, int desde, int hasta) {
        // Si el árbol está vacío, no hay nodos que contar
        if (a.arbolVacio()) {
            return 0;
        }

        int contador = 0;

        // Si el nivel actual está entre "desde" y "hasta", contamos el nodo actual
        if (nivelActual >= desde && nivelActual <= hasta) {
            contador++;
        }

        // Continuamos el recorrido en el subárbol izquierdo e incrementamos el nivel
        contador += contarNodosRecursivo(a.hijoIzq(), nivelActual + 1, desde, hasta);

        // Continuamos el recorrido en el subárbol derecho e incrementamos el nivel
        contador += contarNodosRecursivo(a.hijoDer(), nivelActual + 1, desde, hasta);

        // Retornamos la cantidad total de nodos contados en este nivel y en los subárboles
        return contador;
    }


}