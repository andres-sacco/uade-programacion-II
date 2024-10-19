package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.api.ColaTDA;
import org.uade.impl.ABBTDAImpl;
import org.uade.impl.ColaTDAImpl;
import org.uade.operacion.OperacionArbol;
import org.uade.operacion.OperacionCola;

/*
Crear un metodo que imprima los nodos del árbol en niveles alternos,
es decir, imprimiendo primero todos los nodos del nivel 1, luego del nivel 3,
 y así sucesivamente.

Ejemplo entrada:
        10
      /    \
     5     15
    / \   /  \
   3   7 12  18
 */
public class EjercicioCatorce {

    public static void main(String[] args) {
        EjercicioCatorce app = new EjercicioCatorce();
        app.execute();
    }

    public void execute() {
        ABBTDA arbol = new ABBTDAImpl();
        arbol.inicializarArbol();

        // Agregamos nodos al árbol
        arbol.agregar(10);
        arbol.agregar(5);
        arbol.agregar(15);
        arbol.agregar(3);
        arbol.agregar(7);
        arbol.agregar(12);
        arbol.agregar(18);

        imprimirNivelesAlternos(arbol);
    }

    public void imprimirNivelesAlternos(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return;
        }

        ColaTDA cola = new ColaTDAImpl();
        cola.inicializarCola();
        cola.acolar(arbol.raiz());

        // Usaremos un contador de nivel para determinar si estamos en un nivel par o impar
        int nivelActual = 0;

        // Recorremos el árbol por niveles
        while (!cola.colaVacia()) {
            int nodosEnNivel = 0;
            ColaTDA colaTemporal = new ColaTDAImpl(); // Cola para el siguiente nivel
            colaTemporal.inicializarCola();

            // Procesamos todos los nodos del nivel actual
            while (!cola.colaVacia()) {
                int nodo = cola.primero();
                cola.desacolar();

                if (nivelActual % 2 == 0) {
                    System.out.print(nodo + " ");
                }

                // Obtenemos los hijos del nodo actual y los acolamos en la cola temporal
                ABBTDA subArbol = buscarSubArbol(arbol, nodo); // Metodo que busca el subárbol
                if (!subArbol.hijoIzq().arbolVacio()) {
                    colaTemporal.acolar(subArbol.hijoIzq().raiz());
                    nodosEnNivel++;
                }
                if (!subArbol.hijoDer().arbolVacio()) {
                    colaTemporal.acolar(subArbol.hijoDer().raiz());
                    nodosEnNivel++;
                }
            }

            // Reemplazamos la cola original con los elementos del siguiente nivel
            cola = colaTemporal;

            // Avanzamos al siguiente nivel
            nivelActual++;
            System.out.println(); // Salto de línea después de cada nivel
        }
    }

    // Metodo para buscar un subárbol en función de su valor (raíz)
    private ABBTDA buscarSubArbol(ABBTDA arbol, int valor) {
        if (arbol.arbolVacio()) {
            return null;
        }
        if (arbol.raiz() == valor) {
            return arbol;
        }
        ABBTDA izq = buscarSubArbol(arbol.hijoIzq(), valor);
        if (izq != null) {
            return izq;
        }
        return buscarSubArbol(arbol.hijoDer(), valor);
    }
}