package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.impl.ABBTDAImpl;

/*
Suma de todos los valores entre dos niveles
Dado un árbol binario y dos niveles desde y hasta, calcula la suma de todos los nodos ubicados entre esos niveles, inclusive.

Ejemplo entrada:
        4
      /   \
     2     6
    / \   / \
   1   3 5   7
 */
public class EjercicioDiez {

    public static void main(String[] args) {
        EjercicioDiez app = new EjercicioDiez();
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

        // Suma de los nodos entre los niveles 2 y 3
        int suma = sumaEntreNiveles(arbol, 2, 3);
        System.out.println("Suma entre los niveles 2 y 3: " + suma);
    }

    private int sumaEntreNiveles(ABBTDA arbol, int desde, int hasta) {
        if (arbol.arbolVacio() || desde > hasta) {
            return 0;  // Si el árbol está vacío o los niveles son inválidos, retornamos 0
        }
        return sumaEntreNivelesRec(arbol, 1, desde, hasta);
    }

    // Metodo recursivo para sumar los valores entre los niveles 'desde' y 'hasta'
    private int sumaEntreNivelesRec(ABBTDA arbol, int nivelActual, int desde, int hasta) {
        if (arbol.arbolVacio()) {
            return 0;  // Si llegamos a un nodo vacío, no suma nada
        }

        int suma = 0;

        // Si estamos dentro del rango de niveles, agregamos el valor del nodo actual
        if (nivelActual >= desde && nivelActual <= hasta) {
            suma += arbol.raiz();
        }

        // Continuamos recorriendo los subárboles izquierdo y derecho
        suma += sumaEntreNivelesRec(arbol.hijoIzq(), nivelActual + 1, desde, hasta);
        suma += sumaEntreNivelesRec(arbol.hijoDer(), nivelActual + 1, desde, hasta);

        return suma;
    }
}