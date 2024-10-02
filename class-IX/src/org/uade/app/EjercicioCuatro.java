package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.api.PilaTDA;
import org.uade.impl.ABBTDAImpl;
import org.uade.impl.PilaTDAImpl;
import org.uade.operacion.OperacionPila;

/*
Dado un árbol binario, devuelva una pila que contenga los elementos de la rama más larga del árbol de entrada.

Considerandos:
- Use el siguiente arbol
            10
           /  \
          5    20
         / \   / \
        2   6 15  30
                  \
                   35
 */
public class EjercicioCuatro {

    public static void main(String[] args) {
        EjercicioCuatro app = new EjercicioCuatro();
        app.execute();
    }

    public void execute() {
        ABBTDA arbol = new ABBTDAImpl();
        arbol.inicializarArbol();
        arbol.agregar(10);
        arbol.agregar(5);
        arbol.agregar(2);
        arbol.agregar(6);
        arbol.agregar(20);
        arbol.agregar(15);
        arbol.agregar(30);
        arbol.agregar(35);

        PilaTDA ramaMasLarga = ramaMasLarga(arbol);

        System.out.println("Elementos de la rama más larga:");
        OperacionPila operacionPila = new OperacionPila();
        operacionPila.mostrar(ramaMasLarga);
        
    }

    public PilaTDA ramaMasLarga(ABBTDA arbol) {
        PilaTDA pila = new PilaTDAImpl();
        pila.inicializarPila();

        if (arbol.arbolVacio()) {
            return pila; // Si el árbol está vacío, devolvemos una pila vacía
        }

        // Llamamos al metodo recursivo que agrega los elementos a la pila
        obtenerRamaMasLarga(arbol, pila);

        return pila;
    }

    private int obtenerRamaMasLarga(ABBTDA arbol, PilaTDA pila) {
        if (arbol.arbolVacio()) {
            return 0; // Si el árbol está vacío, la longitud de esta rama es 0
        }

        // Creamos pilas temporales para cada rama
        PilaTDA pilaIzq = new PilaTDAImpl(); // Implementación de PilaTDA
        pilaIzq.inicializarPila();

        PilaTDA pilaDer = new PilaTDAImpl(); // Implementación de PilaTDA
        pilaDer.inicializarPila();

        // Obtenemos la longitud de la rama izquierda y derecha
        int longitudIzq = obtenerRamaMasLarga(arbol.hijoIzq(), pilaIzq);
        int longitudDer = obtenerRamaMasLarga(arbol.hijoDer(), pilaDer);

        OperacionPila operacionPila = new OperacionPila();

        // Verificamos cuál de las ramas es más larga
        if (longitudIzq > longitudDer) {
            operacionPila.copiarPila(pilaIzq, pila); // Si la rama izquierda es más larga, copiamos sus elementos
        } else {
            operacionPila.copiarPila(pilaDer, pila); // Si la rama derecha es más larga, copiamos sus elementos
        }

        // Agregamos el valor de la raíz actual (que está más cerca de la hoja)
        pila.apilar(arbol.raiz());

        // Devolvemos la longitud de la rama actual más 1 (el nodo actual)
        return Math.max(longitudIzq, longitudDer) + 1;
    }
}