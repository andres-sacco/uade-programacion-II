package org.uade.app;

import org.uade.api.ConjuntoTDA;
import org.uade.api.GrafoTDA;
import org.uade.impl.GrafoTDAImpl;
import org.uade.operacion.OperacionConjunto;

/*
Dado un nodo inicial y uno final en el grafo, implementa un metodo que encuentre
el camino de mayor longitud posible entre ellos.
*/
public class EjercicioUno {

    public static void main(String[] args) {
        EjercicioUno app = new EjercicioUno();
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
        grafo.agregarArista(0, 1, 1);  // Peso 1 (peso uniforme)
        grafo.agregarArista(0, 3, 1);
        grafo.agregarArista(1, 2, 1);
        grafo.agregarArista(1, 4, 1);
        grafo.agregarArista(3, 4, 2);
        grafo.agregarArista(4, 5, 10);


        int inicio = 0; // Nodo de inicio
        int fin = 4;    // Nodo final
        int resultado = caminoMasLargo(grafo, inicio, fin);
        System.out.println("El camino de mayor longitud es: " + resultado);

    }


    public int caminoMasLargo(GrafoTDA grafo, int inicio, int fin) {
        int maxVertice = obtenerMaximoVertice(grafo);  // Determinar el mayor índice de vértice
        boolean[] visitado = new boolean[maxVertice + 1];  // Ajustar el tamaño del arreglo dinámicamente
        return dfs(grafo, inicio, fin, visitado);
    }

    private static int dfs(GrafoTDA grafo, int actual, int fin, boolean[] visitado) {
        if (actual == fin) return 0;  // Llegamos al nodo final, retornamos 0

        OperacionConjunto operacionConjunto = new OperacionConjunto();

        visitado[actual] = true;
        int maxPeso = -1;

        ConjuntoTDA conjuntoVertices = grafo.vertices();
        ConjuntoTDA copiaVertices = operacionConjunto.copiarConjunto(conjuntoVertices);  // Copia para preservar el conjunto original

        while (!copiaVertices.conjuntoVacio()) {
            int destino = copiaVertices.elegir();
            copiaVertices.sacar(destino);

            if (grafo.existeArista(actual, destino) && !visitado[destino]) {
                int pesoArista = grafo.pesoArista(actual, destino);
                int pesoCamino = dfs(grafo, destino, fin, visitado);

                if (pesoCamino != -1) {
                    maxPeso = Math.max(maxPeso, pesoArista + pesoCamino);
                }
            }
        }

        visitado[actual] = false;
        return maxPeso;
    }


    private int obtenerMaximoVertice(GrafoTDA grafo) {

        OperacionConjunto operacionConjunto = new OperacionConjunto();

        int max = -1;
        ConjuntoTDA vertices = grafo.vertices();
        ConjuntoTDA copiaVertices = operacionConjunto.copiarConjunto(vertices);

        while (!copiaVertices.conjuntoVacio()) {
            int vertice = copiaVertices.elegir();
            copiaVertices.sacar(vertice);
            if (vertice > max) {
                max = vertice;
            }
        }
        return max;
    }

}