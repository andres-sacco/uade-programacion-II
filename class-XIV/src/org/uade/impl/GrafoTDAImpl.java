package org.uade.impl;

import org.uade.api.ConjuntoTDA;
import org.uade.api.GrafoTDA;

public class GrafoTDAImpl implements GrafoTDA {
    private static final int MAX_VERTICES = 100;
    private static final int INFINITO = Integer.MAX_VALUE;

    private int[][] matrizAdyacencia; // Matriz de adyacencia para representar aristas
    private int[] vertices;          // Arreglo para almacenar los vértices
    private int cantidadVertices;    // Número actual de vértices en el grafo

    @Override
    public void inicializarGrafo() {
        matrizAdyacencia = new int[MAX_VERTICES][MAX_VERTICES];
        vertices = new int[MAX_VERTICES];
        cantidadVertices = 0;

        // Inicializar la matriz de adyacencia con valores "infinito" (sin aristas)
        for (int i = 0; i < MAX_VERTICES; i++) {
            for (int j = 0; j < MAX_VERTICES; j++) {
                matrizAdyacencia[i][j] = INFINITO;
            }
        }
    }

    @Override
    public void agregarVertice(int vertice) {
        if (!existeVertice(vertice) && cantidadVertices < MAX_VERTICES) {
            vertices[cantidadVertices] = vertice;
            cantidadVertices++;
        }
    }

    @Override
    public void eliminarVertice(int vertice) {
        int indice = indiceVertice(vertice);
        if (indice != -1) {
            // Eliminar aristas asociadas al vértice
            for (int i = 0; i < cantidadVertices; i++) {
                matrizAdyacencia[indice][i] = INFINITO;
                matrizAdyacencia[i][indice] = INFINITO;
            }

            // Mover los vértices en el arreglo para llenar el hueco
            for (int i = indice; i < cantidadVertices - 1; i++) {
                vertices[i] = vertices[i + 1];
            }
            cantidadVertices--;
        }
    }

    @Override
    public ConjuntoTDA vertices() {
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();
        for (int i = 0; i < cantidadVertices; i++) {
            conjunto.agregar(vertices[i]);
        }
        return conjunto;
    }

    @Override
    public void agregarArista(int v1, int v2, int peso) {
        int indice1 = indiceVertice(v1);
        int indice2 = indiceVertice(v2);
        if (indice1 != -1 && indice2 != -1) {
            matrizAdyacencia[indice1][indice2] = peso;
        }
    }

    @Override
    public void eliminarArista(int v1, int v2) {
        int indice1 = indiceVertice(v1);
        int indice2 = indiceVertice(v2);
        if (indice1 != -1 && indice2 != -1) {
            matrizAdyacencia[indice1][indice2] = INFINITO;
        }
    }

    @Override
    public boolean existeArista(int v1, int v2) {
        int indice1 = indiceVertice(v1);
        int indice2 = indiceVertice(v2);
        return indice1 != -1 && indice2 != -1 && matrizAdyacencia[indice1][indice2] != INFINITO;
    }

    @Override
    public int pesoArista(int v1, int v2) {
        int indice1 = indiceVertice(v1);
        int indice2 = indiceVertice(v2);
        if (indice1 != -1 && indice2 != -1 && matrizAdyacencia[indice1][indice2] != INFINITO) {
            return matrizAdyacencia[indice1][indice2];
        }
        throw new IllegalStateException("No existe una arista entre los vértices " + v1 + " y " + v2);
    }

    private boolean existeVertice(int vertice) {
        return indiceVertice(vertice) != -1;
    }

    private int indiceVertice(int vertice) {
        for (int i = 0; i < cantidadVertices; i++) {
            if (vertices[i] == vertice) {
                return i;
            }
        }
        return -1; // Vértice no encontrado
    }
}

