package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.api.GrafoTDA;
import org.uade.impl.ABBTDAImpl;
import org.uade.impl.GrafoTDAImpl;
import org.uade.operacion.OperacionGrafo;

/*
Implementar un metodo que reciba un árbol binario y lo convierta en un grafo dirigido.
*/
public class EjercicioUno {

    public static void main(String[] args) {
        EjercicioUno app = new EjercicioUno();
        app.execute();
    }

    private void execute() {
        ABBTDA arbol = new ABBTDAImpl(); // Implementación de ABBTDA

        // Inicializar el árbol y agregar elementos
        arbol.inicializarArbol();
        arbol.agregar(10);
        arbol.agregar(5);
        arbol.agregar(15);
        arbol.agregar(2);
        arbol.agregar(8);

        // Convertir el árbol en un grafo dirigido
        GrafoTDA grafo = convertirArbolEnGrafo(arbol);

        // Imprimir los vértices y aristas del grafo
        OperacionGrafo operacion = new OperacionGrafo();
        operacion.mostrarGrafo(grafo);
    }


    public GrafoTDA convertirArbolEnGrafo(ABBTDA arbol) {
        GrafoTDA grafo = new GrafoTDAImpl();
        grafo.inicializarGrafo();

        // Validar que el árbol no esté vacío
        if (!arbol.arbolVacio()) {
            // Llamada recursiva para procesar los nodos
            agregarNodosYAristas(arbol, grafo);
        }
        return grafo;
    }

    private void agregarNodosYAristas(ABBTDA arbol, GrafoTDA grafo) {
        if (!arbol.arbolVacio()) {
            // Agregar el nodo actual como vértice al grafo
            int nodoActual = arbol.raiz();
            grafo.agregarVertice(nodoActual);

            // Procesar el hijo izquierdo, si existe
            if (!arbol.hijoIzq().arbolVacio()) {
                int hijoIzquierdo = arbol.hijoIzq().raiz();
                grafo.agregarVertice(hijoIzquierdo); // Agregar el hijo como vértice
                grafo.agregarArista(nodoActual, hijoIzquierdo, Math.abs(nodoActual - hijoIzquierdo)); // Agregar la arista
                agregarNodosYAristas(arbol.hijoIzq(), grafo); // Recursión para el subárbol izquierdo
            }

            // Procesar el hijo derecho, si existe
            if (!arbol.hijoDer().arbolVacio()) {
                int hijoDerecho = arbol.hijoDer().raiz();
                grafo.agregarVertice(hijoDerecho); // Agregar el hijo como vértice
                grafo.agregarArista(nodoActual, hijoDerecho, Math.abs(nodoActual - hijoDerecho)); // Agregar la arista
                agregarNodosYAristas(arbol.hijoDer(), grafo); // Recursión para el subárbol derecho
            }
        }
    }

}