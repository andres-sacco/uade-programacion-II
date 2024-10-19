package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.api.ConjuntoTDA;
import org.uade.impl.ABBTDAImpl;
import org.uade.impl.ConjuntoTDAImpl;

/*
Recibe un árbol binario de búsqueda (ABB).
Queremos una funcion que devuelva true si existen dos naturales en el ABB tales que sumados son equivalentes a n.
*/
public class EjercicioDos {

    public static void main(String[] args) {
        EjercicioDos app = new EjercicioDos();
        app.execute();
    }

    public void execute() {
        ABBTDA arbol = new ABBTDAImpl();
        arbol.inicializarArbol();

        // Agregar valores al árbol
        arbol.agregar(4);
        arbol.agregar(2);
        arbol.agregar(5);
        arbol.agregar(1);
        arbol.agregar(3);
        arbol.agregar(6);

        int n = 8;

        if (existenDosNaturalesQueSuman(arbol, n)) {
            System.out.println("Existen dos números que suman " + n);
        } else {
            System.out.println("No existen dos números que sumen " + n);
        }

    }

    public boolean existenDosNaturalesQueSuman(ABBTDA arbol, int n) {
        ConjuntoTDA numeros = new ConjuntoTDAImpl();
        numeros.inicializarConjunto();
        obteniendoValores(arbol, numeros);

        //Conjunto para almacenar números vistos
        ConjuntoTDA numerosVistos = new ConjuntoTDAImpl();
        numerosVistos.inicializarConjunto();

        // Recorremos los elementos del conjunto de entrada
        while (!numeros.conjuntoVacio()) {
            int numero = numeros.elegir();
            numeros.sacar(numero); // Sacamos el número del conjunto de entrada

            int complemento = n - numero; // Calculamos el complemento

            // Verificamos si el complemento ya fue visto
            if (numerosVistos.pertenece(complemento)) {
                return true; // Encontramos dos números que suman n
            }

            // Agregamos el número actual al conjunto de números vistos
            numerosVistos.agregar(numero);
        }

        return false; // No se encontraron dos números que sumen n
    }

    // Metodo recursivo para recorrer el árbol y buscar pares
    private void obteniendoValores(ABBTDA nodo, ConjuntoTDA conjunto) {
        // Si el nodo es vacío, terminamos la búsqueda
        if (nodo.arbolVacio()) {
            return;
        }

        // Agregar el valor actual al conjunto
        conjunto.agregar(nodo.raiz());

        // Buscar en el subárbol izquierdo
        obteniendoValores(nodo.hijoIzq(), conjunto);

        // Buscar en el subárbol derecho
        obteniendoValores(nodo.hijoDer(), conjunto);
    }

}