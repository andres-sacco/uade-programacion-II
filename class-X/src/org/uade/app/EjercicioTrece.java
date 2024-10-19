package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.impl.ABBTDAImpl;
import org.uade.operacion.OperacionArbol;

/*
Eliminar nodos en niveles específicos y retornar el árbol modificado
Dado un árbol binario y un nivel k, elimina todos los nodos en ese nivel y retorna el árbol modificado.

Ejemplo entrada:
        10
      /    \
     5     15
    / \   /  \
   3   7 12  18
 */
public class EjercicioTrece {

    public static void main(String[] args) {
        EjercicioTrece app = new EjercicioTrece();
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
        eliminarNodosEnNivel(arbol, 3);

        OperacionArbol operacion = new OperacionArbol();
        operacion.mostrarArbolInorden(arbol);
    }

    // Metodo principal para eliminar los nodos en el nivel k
    private void eliminarNodosEnNivel(ABBTDA arbol, int k) {
        if (arbol.arbolVacio() || k <= 0) {
            return;  // Si el árbol está vacío o el nivel es inválido, no hacemos nada
        }

        if (k == 1) {
            // Si estamos en el nivel 1, eliminamos la raíz
            arbol.inicializarArbol();  // Re-inicializamos el árbol para eliminar la raíz
        } else {
            eliminarNodosRec(arbol, 1, k);  // Comenzamos el proceso recursivo
        }
    }

    // Metodo recursivo para eliminar los nodos en el nivel k
    private void eliminarNodosRec(ABBTDA arbol, int nivelActual, int k) {
        if (arbol.arbolVacio()) {
            return;
        }

        if (nivelActual == k - 1) {
            // Si estamos en el nivel anterior a k, eliminamos los hijos (nivel k)
            if (!arbol.hijoIzq().arbolVacio()) {
                arbol.hijoIzq().inicializarArbol();  // Eliminamos el hijo izquierdo
            }
            if (!arbol.hijoDer().arbolVacio()) {
                arbol.hijoDer().inicializarArbol();  // Eliminamos el hijo derecho
            }
        } else {
            // Continuamos recorriendo hacia los hijos
            eliminarNodosRec(arbol.hijoIzq(), nivelActual + 1, k);
            eliminarNodosRec(arbol.hijoDer(), nivelActual + 1, k);
        }
    }

}