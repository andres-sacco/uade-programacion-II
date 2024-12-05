package org.uade.app;

import org.uade.api.ConjuntoTDA;
import org.uade.api.DiccionarioSimpleTDA;
import org.uade.api.GrafoTDA;
import org.uade.impl.DiccionarioSimpleTDAImpl;
import org.uade.impl.GrafoTDAImpl;
import org.uade.operacion.OperacionGrafo;

/*
Dado un diccionario simple se lo quiere cconvertir en un grafo considerando:
- Las claves representan a los vertices
- Los valores son con que vertices se conectan
- Todas las aristas tienen un valor de 1
*/
public class EjercicioCuatro {

    public static void main(String[] args) {
        EjercicioCuatro app = new EjercicioCuatro();
        app.execute();
    }

    private void execute() {
        DiccionarioSimpleTDA diccionario = new DiccionarioSimpleTDAImpl();
        diccionario.inicializarDiccionario();
        diccionario.agregar(1, 2); // Clave 1 se conecta con 2
        diccionario.agregar(1, 3); // Clave 1 se conecta con 3
        diccionario.agregar(2, 3); // Clave 2 se conecta con 3

        GrafoTDA grafo = convertirDiccionarioAGrafo(diccionario);

        // Imprimir los vértices y aristas del grafo
        OperacionGrafo operacion = new OperacionGrafo();
        operacion.mostrarGrafo(grafo);
    }


    // Metodo que convierte un Diccionario Simple en un Grafo
    public GrafoTDA convertirDiccionarioAGrafo(DiccionarioSimpleTDA diccionario) {
        GrafoTDA grafo = new GrafoTDAImpl();
        grafo.inicializarGrafo();

        // Recorrer todas las claves del diccionario
        ConjuntoTDA claves = diccionario.claves();
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            claves.sacar(clave);

            // Agregar el vértice correspondiente a la clave
            grafo.agregarVertice(clave);

            // Obtener el valor (único vértice al que está conectada la clave)
            int verticeConectado = diccionario.recuperar(clave);

            // Agregar el vértice al grafo si no está agregado ya
            grafo.agregarVertice(verticeConectado);

            // Agregar una arista entre la clave y el vértice conectado con peso 1
            grafo.agregarArista(clave, verticeConectado, 1);
        }

        return grafo;
    }

}