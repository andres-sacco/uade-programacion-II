package org.uade.app;

import org.uade.api.ConjuntoTDA;
import org.uade.api.GrafoTDA;
import org.uade.impl.ConjuntoTDAImpl;
import org.uade.impl.GrafoTDAImpl;
import org.uade.operacion.OperacionConjunto;
import org.uade.operacion.OperacionGrafo;

/*
Dado un nodo implementar un metodo que devuelva los adyacentes
*/
public class EjercicioCuatro {

    public static void main(String[] args) {
        EjercicioCuatro app = new EjercicioCuatro();
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

        ConjuntoTDA adyacentes = obtenerAdyacentes(grafo, 1);

        OperacionConjunto op = new OperacionConjunto();
        op.mostrarConjunto(adyacentes);

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