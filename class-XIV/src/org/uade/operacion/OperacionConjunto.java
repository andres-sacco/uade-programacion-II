package org.uade.operacion;

import org.uade.api.ConjuntoTDA;
import org.uade.impl.ConjuntoTDAImpl;

public class OperacionConjunto {

    public void mostrarConjunto(ConjuntoTDA conjunto) {
        ConjuntoTDA aux = new ConjuntoTDAImpl(); // Conjunto auxiliar para no perder los elementos
        aux.inicializarConjunto();

        System.out.print("Elementos del conjunto: ");
        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir(); // Obtener un elemento del conjunto
            System.out.print(elemento + " ");  // Mostrar el elemento
            conjunto.sacar(elemento);          // Sacar el elemento del conjunto original
            aux.agregar(elemento);             // Guardar el elemento en el conjunto auxiliar
        }
        System.out.println(); // Salto de línea después de mostrar los elementos

        // Restaurar el conjunto original
        while (!aux.conjuntoVacio()) {
            int elemento = aux.elegir();
            aux.sacar(elemento);
            conjunto.agregar(elemento);
        }
    }


    public ConjuntoTDA copiarConjunto(ConjuntoTDA conjuntoOriginal) {
        ConjuntoTDA copia = new ConjuntoTDAImpl();
        copia.inicializarConjunto();

        ConjuntoTDA conjuntoTemp = new ConjuntoTDAImpl(); // Temporal para iterar sin modificar el original
        conjuntoTemp.inicializarConjunto();

        while (!conjuntoOriginal.conjuntoVacio()) {
            int elemento = conjuntoOriginal.elegir();
            conjuntoOriginal.sacar(elemento);
            copia.agregar(elemento);
            conjuntoTemp.agregar(elemento);
        }

        while (!conjuntoTemp.conjuntoVacio()) {
            int elemento = conjuntoTemp.elegir();
            conjuntoTemp.sacar(elemento);
            conjuntoOriginal.agregar(elemento);
        }

        return copia;
    }
}
