package org.uade.operacion;

import org.uade.api.ConjuntoTDA;
import org.uade.api.GrafoTDA;

public class OperacionGrafo {

    public void mostrarGrafo(GrafoTDA grafo) {
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
