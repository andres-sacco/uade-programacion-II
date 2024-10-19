package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.impl.ABBTDAImpl;

/*
Dado un arbol binario, retornar la suma los valores de los niveles pares y resta los valores de los impares.
La raíz se encuentra en el nivel 1.

Ejemplo entrada:
        4
      /   \
     2     6
    / \   / \
   1   3 5   7
 */
public class EjercicioSeis {

    public static void main(String[] args) {
        EjercicioSeis app = new EjercicioSeis();
        app.execute();
    }

    public void execute() {
        ABBTDA arbol = new ABBTDAImpl();
        arbol.inicializarArbol();

        // Agregar algunos valores al árbol
        arbol.agregar(4);
        arbol.agregar(2);
        arbol.agregar(6);
        arbol.agregar(1);
        arbol.agregar(3);
        arbol.agregar(5);
        arbol.agregar(7);

        int resultado = calcularSumaYResta(arbol, 1); // La raíz está en el nivel 1
        System.out.println("El resultado es: " + resultado);
    }

    // Metodo recursivo para recorrer el árbol y sumar/restar según el nivel
    private int calcularSumaYResta(ABBTDA arbol, int nivel) {
        if (arbol.arbolVacio()) {
            return 0; // Si el árbol es vacío, retornamos 0
        }

        // Tomamos el valor de la raíz
        int valor = arbol.raiz();

        // Si el nivel es impar, restamos; si es par, sumamos
        int resultado = (nivel % 2 == 0) ? valor : -valor;

        // Recurre en el hijo izquierdo y derecho, aumentando el nivel
        resultado += calcularSumaYResta(arbol.hijoIzq(), nivel + 1);
        resultado += calcularSumaYResta(arbol.hijoDer(), nivel + 1);

        return resultado;
    }
}