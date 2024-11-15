package org.uade.app;

import org.uade.api.ConjuntoTDA;
import org.uade.api.GrafoTDA;
import org.uade.impl.ConjuntoTDAImpl;
import org.uade.impl.GrafoTDAImpl;
import org.uade.operacion.OperacionConjunto;

/*
Dado un nodo implementar un metodo que devuelva la cantidad de nodos salientes
*/
public class EjercicioCinco {

    public static void main(String[] args) {
        EjercicioCinco app = new EjercicioCinco();
        app.execute();
    }

    private void execute() {
        GrafoTDA grafo = new GrafoTDAImpl();
        grafo.inicializarGrafo();
        grafo.agregarVertice(0);
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarArista(0, 1, 5);
        grafo.agregarArista(0, 2, 10);
        grafo.agregarArista(1, 3, 15);
        grafo.agregarArista(2, 3, 20);

        int cantidadAristas = cantidadAristasSalientes(grafo, 0);
        System.out.println("Cantidad de aristas salientes desde el nodo 0: " + cantidadAristas);

    }


    public static int cantidadAristasSalientes(GrafoTDA grafo, int nodo) {
        int contador = 0;

        // Obtener los vértices adyacentes al nodo dado
        ConjuntoTDA adyacentes = obtenerAdyacentes(grafo, nodo);

        // Contar cuántas aristas existen hacia los adyacentes
        while (!adyacentes.conjuntoVacio()) {
            int adyacente = adyacentes.elegir();
            adyacentes.sacar(adyacente);
            if (grafo.existeArista(nodo, adyacente)) {
                contador++;
            }
        }

        return contador;
    }

    private static ConjuntoTDA obtenerAdyacentes(GrafoTDA grafo, int vertice) {
        ConjuntoTDA adyacentes = new ConjuntoTDAImpl(); // Suponemos que Conjunto es una implementación de ConjuntoTDA
        adyacentes.inicializarConjunto();

        ConjuntoTDA vertices = grafo.vertices();
        OperacionConjunto operador = new OperacionConjunto();
        ConjuntoTDA copiaVertices = operador.copiarConjunto(vertices);

        while (!copiaVertices.conjuntoVacio()) {
            int destino = copiaVertices.elegir();
            copiaVertices.sacar(destino);
            if (grafo.existeArista(vertice, destino)) {
                adyacentes.agregar(destino);
            }
        }

        return adyacentes;
    }

}