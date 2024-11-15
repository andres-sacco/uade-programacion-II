package org.uade.app;

import org.uade.api.ConjuntoTDA;
import org.uade.api.GrafoTDA;
import org.uade.impl.GrafoTDAImpl;
import org.uade.operacion.OperacionConjunto;
import org.uade.operacion.OperacionGrafo;

/*
Dados dos grafos, crear un nuevo con los elementos en comun entre
ambos siempre que la relacion entre vertices y el peso sea igual.
*/
public class EjercicioTres {

    public static void main(String[] args) {
        EjercicioTres app = new EjercicioTres();
        app.execute();
    }

    private void execute() {
        GrafoTDA grafo1 = new GrafoTDAImpl();
        grafo1.inicializarGrafo();
        grafo1.agregarVertice(0);
        grafo1.agregarVertice(1);
        grafo1.agregarVertice(2);
        grafo1.agregarArista(0, 1, 5);
        grafo1.agregarArista(1, 2, 10);

        GrafoTDA grafo2 = new GrafoTDAImpl();
        grafo2.inicializarGrafo();
        grafo2.agregarVertice(1);
        grafo2.agregarVertice(2);
        grafo2.agregarVertice(3);
        grafo2.agregarArista(1, 2, 10);
        grafo2.agregarArista(1, 3, 15);

        // Crear un nuevo grafo con los elementos en común
        GrafoTDA grafoComun = grafoComun(grafo1, grafo2);

        OperacionGrafo operacionGrafo = new OperacionGrafo();
        operacionGrafo.mostrarGrafo(grafoComun);

    }

    public GrafoTDA grafoComun(GrafoTDA grafo1, GrafoTDA grafo2) {
        GrafoTDA nuevoGrafo = new GrafoTDAImpl(); // Suponemos que Grafo es la implementación de GrafoTDA
        nuevoGrafo.inicializarGrafo();

        // Obtener los vértices de ambos grafos
        ConjuntoTDA verticesGrafo1 = grafo1.vertices();
        ConjuntoTDA verticesGrafo2 = grafo2.vertices();

        // Iterar sobre los vértices del primer grafo
        OperacionConjunto operacionConjunto = new OperacionConjunto();
        ConjuntoTDA copiaVerticesGrafo1 = operacionConjunto.copiarConjunto(verticesGrafo1);
        while (!copiaVerticesGrafo1.conjuntoVacio()) {
            int vertice = copiaVerticesGrafo1.elegir();
            copiaVerticesGrafo1.sacar(vertice);

            // Verificar si el vértice existe en el segundo grafo
            if (verticesGrafo2.pertenece(vertice)) {
                nuevoGrafo.agregarVertice(vertice);
            }

            // Iterar sobre los vértices del segundo grafo para encontrar aristas comunes
            ConjuntoTDA copiaVerticesGrafo2 = operacionConjunto.copiarConjunto(verticesGrafo2);
            while (!copiaVerticesGrafo2.conjuntoVacio()) {
                int destino = copiaVerticesGrafo2.elegir();
                copiaVerticesGrafo2.sacar(destino);

                // Verificar si hay una arista en ambos grafos con el mismo peso
                if (grafo1.existeArista(vertice, destino) && grafo2.existeArista(vertice, destino)) {
                    int peso1 = grafo1.pesoArista(vertice, destino);
                    int peso2 = grafo2.pesoArista(vertice, destino);

                    if (peso1 == peso2) {
                        nuevoGrafo.agregarArista(vertice, destino, peso1);
                    }
                }
            }
        }

        return nuevoGrafo;
    }

}