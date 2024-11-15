package org.uade.app;

import org.uade.api.ConjuntoTDA;
import org.uade.api.GrafoTDA;
import org.uade.impl.GrafoTDAImpl;
import org.uade.operacion.OperacionConjunto;

/*
Dado un grafo queremos un metodo que nos permita mostrar el contenido
*/
public class EjercicioDos {

    public static void main(String[] args) {
        EjercicioDos app = new EjercicioDos();
        app.execute();
    }

    private void execute() {
        GrafoTDA grafo = new GrafoTDAImpl();
        grafo.inicializarGrafo();

        // Agregar los vértices
        grafo.agregarVertice(0);
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);

        // Agregar las aristas
        grafo.agregarArista(0, 1, 5);
        grafo.agregarArista(0, 3, 1);
        grafo.agregarArista(1, 2, 8);
        grafo.agregarArista(1, 4, 9);
        grafo.agregarArista(3, 4, 3);
        grafo.agregarArista(4, 5, 2);

        mostrarGrafo(grafo);

    }

    public static void mostrarGrafo(GrafoTDA grafo) {
        OperacionConjunto op = new OperacionConjunto();
        ConjuntoTDA vertices = grafo.vertices();
        ConjuntoTDA copiaVertices = op.copiarConjunto(vertices); // Copia para preservar el original

        System.out.println("Grafo:");
        while (!copiaVertices.conjuntoVacio()) {
            int vertice = copiaVertices.elegir();
            copiaVertices.sacar(vertice);

            // Imprimir el vértice y sus aristas de salida
            System.out.print("Vertice " + vertice + " -> ");
            ConjuntoTDA adyacentes = grafo.vertices();  // Para explorar conexiones con otros vértices
            ConjuntoTDA copiaAdyacentes = op.copiarConjunto(adyacentes);

            boolean tieneAristas = false;
            while (!copiaAdyacentes.conjuntoVacio()) {
                int destino = copiaAdyacentes.elegir();
                copiaAdyacentes.sacar(destino);

                if (grafo.existeArista(vertice, destino)) {
                    System.out.print(destino + "(peso: " + grafo.pesoArista(vertice, destino) + ") ");
                    tieneAristas = true;
                }
            }

            if (!tieneAristas) {
                System.out.print("sin aristas de salida");
            }
            System.out.println();
        }
    }

}