package org.uade.app;

import org.uade.api.ConjuntoTDA;
import org.uade.api.GrafoTDA;
import org.uade.impl.ConjuntoTDAImpl;
import org.uade.impl.GrafoTDAImpl;

/*
Dado un GrafoTDA y un nodo raíz, verifica si existe un camino que siga una estructura de árbol
Implementar un metodo que recorra el grafo y determine si es posible encontrar dicha estructura de camino.
*/
public class EjercicioDos {

    public static void main(String[] args) {
        EjercicioDos app = new EjercicioDos();
        app.execute();
    }

    private void execute() {
        GrafoTDA grafo = new GrafoTDAImpl();
        grafo.inicializarGrafo();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);

        grafo.agregarArista(1, 2, 1);
        grafo.agregarArista(1, 3, 1);
        grafo.agregarArista(3, 4, 1);

        System.out.println("¿El grafo contiene una estructura de árbol?: " + esEstructuraArbol(grafo, 1)); // true

        grafo.agregarArista(2, 4, 1); // Crear un ciclo
        System.out.println("¿El grafo contiene una estructura de árbol?: " + esEstructuraArbol(grafo, 1)); // false
    }

    public boolean esEstructuraArbol(GrafoTDA grafo, int raiz) {
        ConjuntoTDA visitados = new ConjuntoTDAImpl();
        visitados.inicializarConjunto();

        if (!esArbolDFS(grafo, raiz, -1, visitados)) {
            return false;
        }

        // Verificar que todos los vértices sean alcanzables desde la raíz
        ConjuntoTDA vertices = grafo.vertices();
        while (!vertices.conjuntoVacio()) {
            int vertice = vertices.elegir();
            vertices.sacar(vertice);
            if (!visitados.pertenece(vertice)) {
                return false; // Hay nodos desconectados
            }
        }

        return true;
    }

    private boolean esArbolDFS(GrafoTDA grafo, int actual, int padre, ConjuntoTDA visitados) {
        if (visitados.pertenece(actual)) {
            return false; // Encontramos un ciclo
        }

        visitados.agregar(actual);

        ConjuntoTDA vertices = grafo.vertices();
        while (!vertices.conjuntoVacio()) {
            int vecino = vertices.elegir();
            vertices.sacar(vecino);

            if (grafo.existeArista(actual, vecino)) {
                // Evitar volver al nodo padre en un grafo no dirigido
                if (vecino != padre && !esArbolDFS(grafo, vecino, actual, visitados)) {
                    return false; // El subgrafo no es un árbol
                }
            }
        }

        return true;
    }



}