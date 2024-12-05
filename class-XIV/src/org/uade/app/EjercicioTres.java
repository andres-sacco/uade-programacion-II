package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.api.ConjuntoTDA;
import org.uade.api.GrafoTDA;
import org.uade.impl.ABBTDAImpl;
import org.uade.impl.ConjuntoTDAImpl;
import org.uade.impl.GrafoTDAImpl;
import org.uade.operacion.OperacionGrafo;

/*
Implementar un metodo que reciba un ABBTDA y un GrafoTDA y determine:
- Si tienen la misma cantidad de nodos.
- Si todos los nodos del árbol están presentes en el grafo.
- Si el grafo contiene las mismas conexiones padre-hijo que el árbol.
*/
public class EjercicioTres {

    public static void main(String[] args) {
        EjercicioTres app = new EjercicioTres();
        app.execute();
    }

    private void execute() {
        ABBTDA arbol = new ABBTDAImpl();
        arbol.inicializarArbol();
        arbol.agregar(10);
        arbol.agregar(5);
        arbol.agregar(15);
        arbol.agregar(3);
        arbol.agregar(7);

        GrafoTDA grafo = new GrafoTDAImpl();
        grafo.inicializarGrafo();

        grafo.agregarVertice(10);
        grafo.agregarVertice(5);
        grafo.agregarVertice(15);
        grafo.agregarVertice(3);
        grafo.agregarVertice(7);
        grafo.agregarArista(10, 5, 1);
        grafo.agregarArista(10, 15, 1);
        grafo.agregarArista(5, 3, 1);
        grafo.agregarArista(5, 7, 1);

        boolean resultado = compararArbolYGrafo(arbol, grafo);
        System.out.println("¿El árbol y el grafo son iguales? " + resultado); // Debería imprimir true
    }

    // Metodo principal que compara el árbol y el grafo
    public boolean compararArbolYGrafo(ABBTDA arbol, GrafoTDA grafo) {
        // Paso 1: Verificar la cantidad de nodos
        if (cantidadNodosArbol(arbol) != cantidadNodosGrafo(grafo)) {
            return false; // Si la cantidad de nodos no coincide
        }

        // Paso 2: Verificar que todos los nodos del árbol estén presentes en el grafo
        ConjuntoTDA nodosArbol = obtenerNodosArbol(arbol);
        ConjuntoTDA nodosGrafo = grafo.vertices();
        while (!nodosArbol.conjuntoVacio()) {
            int nodoArbol = nodosArbol.elegir();
            nodosArbol.sacar(nodoArbol);
            if (!nodosGrafo.pertenece(nodoArbol)) {
                return false; // Si algún nodo del árbol no está en el grafo
            }
        }

        // Paso 3: Verificar que las conexiones padre-hijo del árbol estén presentes en el grafo
        return verificarConexionesPadreHijo(arbol, grafo);
    }

    // Paso 1: Contar la cantidad de nodos en el árbol
    private int cantidadNodosArbol(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        }
        // Recorrido preorden del árbol para contar los nodos
        int cantidad = 1; // Contar el nodo actual
        if (!arbol.hijoIzq().arbolVacio()) {
            cantidad += cantidadNodosArbol(arbol.hijoIzq());
        }
        if (!arbol.hijoDer().arbolVacio()) {
            cantidad += cantidadNodosArbol(arbol.hijoDer());
        }
        return cantidad;
    }

    // Paso 1: Contar la cantidad de nodos en el grafo
    private int cantidadNodosGrafo(GrafoTDA grafo) {
        ConjuntoTDA nodos = grafo.vertices();
        int cantidad = 0;
        while (!nodos.conjuntoVacio()) {
            nodos.sacar(nodos.elegir());
            cantidad++;
        }
        return cantidad;
    }

    // Paso 2: Obtener los nodos del árbol como un conjunto
    private ConjuntoTDA obtenerNodosArbol(ABBTDA arbol) {
        ConjuntoTDA nodos = new ConjuntoTDAImpl();
        nodos.inicializarConjunto();
        if (!arbol.arbolVacio()) {
            agregarNodosArbol(arbol, nodos);
        }
        return nodos;
    }

    // Metodo recursivo para agregar nodos del árbol al conjunto
    private void agregarNodosArbol(ABBTDA arbol, ConjuntoTDA nodos) {
        if (arbol.arbolVacio()) {
            return;
        }
        nodos.agregar(arbol.raiz());
        if (!arbol.hijoIzq().arbolVacio()) {
            agregarNodosArbol(arbol.hijoIzq(), nodos);
        }
        if (!arbol.hijoDer().arbolVacio()) {
            agregarNodosArbol(arbol.hijoDer(), nodos);
        }
    }

    // Paso 3: Verificar que las conexiones padre-hijo del árbol estén presentes en el grafo
    private boolean verificarConexionesPadreHijo(ABBTDA arbol, GrafoTDA grafo) {
        if (arbol.arbolVacio()) {
            return true;
        }
        int valorActual = arbol.raiz();
        // Verificar las conexiones con los hijos izquierdo y derecho
        if (!arbol.hijoIzq().arbolVacio()) {
            int valorIzq = arbol.hijoIzq().raiz();
            if (!grafo.existeArista(valorActual, valorIzq)) {
                return false; // Si la arista no existe en el grafo
            }
        }
        if (!arbol.hijoDer().arbolVacio()) {
            int valorDer = arbol.hijoDer().raiz();
            if (!grafo.existeArista(valorActual, valorDer)) {
                return false; // Si la arista no existe en el grafo
            }
        }
        // Recursión en los hijos izquierdo y derecho
        return verificarConexionesPadreHijo(arbol.hijoIzq(), grafo) &&
                verificarConexionesPadreHijo(arbol.hijoDer(), grafo);
    }

}