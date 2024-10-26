package org.uade.app;

import org.uade.api.ColaTDA;
import org.uade.api.ConjuntoTDA;
import org.uade.impl.ColaTDAImpl;
import org.uade.impl.ConjuntoTDAImpl;
import org.uade.operacion.OperacionCola;
import org.uade.operacion.OperacionConjunto;

/*
Dado un conjunto, se busca que se creen 2 subconjuntos cada uno tendra la mitad de los valores del conjunto original.
*/
public class EjercicioTres {

    public static void main(String[] args) {
        EjercicioTres app = new EjercicioTres();
        app.execute();
    }

    public void execute() {
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();
        conjunto.agregar(1);
        conjunto.agregar(2);
        conjunto.agregar(3);
        conjunto.agregar(4);
        conjunto.agregar(5);
        conjunto.agregar(6);
        conjunto.agregar(7);
        conjunto.agregar(8);

        ConjuntoTDA subconjunto1 = new ConjuntoTDAImpl();
        subconjunto1.inicializarConjunto();

        ConjuntoTDA subconjunto2 = new ConjuntoTDAImpl();
        subconjunto2.inicializarConjunto();

        dividirConjuntoEnMitades(conjunto, subconjunto1, subconjunto2);

        OperacionConjunto operacion = new OperacionConjunto();
        operacion.mostrarConjunto(subconjunto1);

        operacion.mostrarConjunto(subconjunto2);
    }

    public void dividirConjuntoEnMitades(ConjuntoTDA conjunto, ConjuntoTDA subconjunto1, ConjuntoTDA subconjunto2) {

        int cantidadElementos = contarElementos(conjunto);
        int mitad = cantidadElementos / 2;

        // Repartir los primeros "mitad" elementos al subconjunto1
        for (int i = 0; i < mitad; i++) {
            int elemento = conjunto.elegir();
            subconjunto1.agregar(elemento);
            conjunto.sacar(elemento);
        }

        // Repartir los elementos restantes al subconjunto2
        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            subconjunto2.agregar(elemento);
            conjunto.sacar(elemento);
        }
    }

    private int contarElementos(ConjuntoTDA conjunto) {
        ConjuntoTDA aux = new ConjuntoTDAImpl(); // Conjunto auxiliar para no perder los elementos
        aux.inicializarConjunto();
        int contador = 0;

        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            conjunto.sacar(elemento);
            aux.agregar(elemento);
            contador++;
        }

        // Restaurar el conjunto original
        while (!aux.conjuntoVacio()) {
            int elemento = aux.elegir();
            aux.sacar(elemento);
            conjunto.agregar(elemento);
        }

        return contador;
    }

}