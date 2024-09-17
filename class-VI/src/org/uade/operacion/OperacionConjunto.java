package org.uade.operacion;

import org.uade.api.ConjuntoTDA;
import org.uade.impl.ConjuntoTDAImpl;

public class OperacionConjunto {

    public void mostrarConjunto(ConjuntoTDA conjunto) {
        ConjuntoTDA temp = new ConjuntoTDAImpl();
        temp.inicializarConjunto();

        // Copiamos los elementos del conjunto original al conjunto temporal
        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            System.out.println(elemento); // Mostramos el elemento
            temp.agregar(elemento);
            conjunto.sacar(elemento);
        }

        // Restauramos el conjunto original
        while (!temp.conjuntoVacio()) {
            int elemento = temp.elegir();
            conjunto.agregar(elemento);
            temp.sacar(elemento);
        }
    }
}
