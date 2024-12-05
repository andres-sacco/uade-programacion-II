package org.uade.app;

import org.uade.api.GrafoTDA;
import org.uade.impl.GrafoTDAImpl;

/*

*/
public class EjercicioSeis {

    public static void main(String[] args) {
        EjercicioSeis app = new EjercicioSeis();
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


    }


}