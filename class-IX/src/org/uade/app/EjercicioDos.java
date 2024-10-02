package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.impl.ABBTDAImpl;

/*
Dado un arbol se pide saber la cantidad de nodos internos que posee.

Considerandos:
- Un nodo interno es aquel que no es una hoja.
- Excluya la raiz como nodo interno.
- Use el siguiente arbol
        10
       /  \
      5    20
     / \   / \
    3   7 15 25
 */
public class EjercicioDos {

    public static void main(String[] args) {
        EjercicioDos app = new EjercicioDos();
        app.execute();
    }

    public void execute() {
        ABBTDA arbol = new ABBTDAImpl();
        arbol.inicializarArbol();
        arbol.agregar(10);
        arbol.agregar(5);
        arbol.agregar(20);
        arbol.agregar(3);
        arbol.agregar(7);
        arbol.agregar(15);
        arbol.agregar(25);

        System.out.println("Nodos internos: " + contarNodosInternos(arbol));
    }


    private int contarNodosInternos(ABBTDA arbol) {
        // Si el árbol está vacío o es una hoja, no hay nodos internos
        if (arbol.arbolVacio() || (arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio())) {
            return 0;
        }

        // Verificar si es la raíz. Como la raíz no se cuenta, empezamos desde los hijos.
        int countIzq = contarNodosInternos(arbol.hijoIzq());
        int countDer = contarNodosInternos(arbol.hijoDer());

        // Si el nodo actual no es hoja, entonces es un nodo interno.
        if (!arbol.hijoIzq().arbolVacio() || !arbol.hijoDer().arbolVacio()) {
            return 1 + countIzq + countDer; // Sumar 1 por el nodo actual.
        } else {
            return countIzq + countDer - 1;
        }
    }
}