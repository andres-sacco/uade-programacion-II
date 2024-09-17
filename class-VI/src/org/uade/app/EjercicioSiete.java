package org.uade.app;

import org.uade.api.ConjuntoTDA;
import org.uade.api.PilaTDA;
import org.uade.impl.ConjuntoTDAImpl;
import org.uade.impl.PilaTDAImpl;
import org.uade.operacion.OperacionConjunto;

/*
Dadas una pila y un conjunto, implementa un algoritmo que determine si ambos contienen exactamente los mismos elementos, independientemente del orden
 */
public class EjercicioSiete {

    public static void main(String[] args) {
        EjercicioSiete app = new EjercicioSiete();
        app.execute();
    }

    public void execute() {
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();

        conjunto.agregar(1);
        conjunto.agregar(2);
        conjunto.agregar(5);

        PilaTDA pila = new PilaTDAImpl();
        pila.inicializarPila();
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(5);

        boolean sonIguales = sonIguales(pila, conjunto);
        System.out.println("Ambas estructuras son iguales: " + sonIguales);
    }

    public boolean sonIguales(PilaTDA pila, ConjuntoTDA conjunto) {
        // Paso 1: Verificar la cantidad de elementos
        if (obtenerTamañoPila(pila) != obtenerTamañoConjunto(conjunto)) {
            return false;
        }

        // Paso 2: Crear un conjunto auxiliar para almacenar los elementos de la pila
        ConjuntoTDA conjuntoAux = new ConjuntoTDAImpl();
        conjuntoAux.inicializarConjunto();

        // Paso 3: Recorrer la pila y agregar sus elementos al conjunto auxiliar
        PilaTDA pilaAux = copiarPila(pila); // Copiamos la pila para no modificar la original
        while (!pilaAux.pilaVacia()) {
            int elemento = pilaAux.tope();
            conjuntoAux.agregar(elemento);
            pilaAux.desapilar();
        }

        // Paso 4: Comparar el conjunto auxiliar con el conjunto dado
        return conjuntosIguales(conjuntoAux, conjunto);
    }

    private int obtenerTamañoPila(PilaTDA pila) {
        PilaTDA pilaAux = copiarPila(pila);
        int tamaño = 0;

        while (!pilaAux.pilaVacia()) {
            pilaAux.desapilar();
            tamaño++;
        }

        return tamaño;
    }

    private int obtenerTamañoConjunto(ConjuntoTDA conjunto) {
        ConjuntoTDA conjuntoAux = copiarConjunto(conjunto);
        int tamaño = 0;

        while (!conjuntoAux.conjuntoVacio()) {
            conjuntoAux.sacar(conjuntoAux.elegir());
            tamaño++;
        }

        return tamaño;
    }

    private PilaTDA copiarPila(PilaTDA pila) {
        PilaTDA copia = new PilaTDAImpl();
        PilaTDA temp = new PilaTDAImpl(); // Para invertir el orden

        copia.inicializarPila();
        temp.inicializarPila();

        // Copiar los elementos en orden inverso
        while (!pila.pilaVacia()) {
            temp.apilar(pila.tope());
            pila.desapilar();
        }

        // Restaurar la pila original y crear la copia
        while (!temp.pilaVacia()) {
            int elemento = temp.tope();
            temp.desapilar();
            pila.apilar(elemento);
            copia.apilar(elemento);
        }

        return copia;
    }

    private ConjuntoTDA copiarConjunto(ConjuntoTDA conjunto) {
        ConjuntoTDA copia = new ConjuntoTDAImpl();
        copia.inicializarConjunto();

        ConjuntoTDA temp = new ConjuntoTDAImpl();
        temp.inicializarConjunto();

        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            temp.agregar(elemento);
            conjunto.sacar(elemento);
        }

        while (!temp.conjuntoVacio()) {
            int elemento = temp.elegir();
            conjunto.agregar(elemento);
            copia.agregar(elemento);
            temp.sacar(elemento);
        }

        return copia;
    }

    private boolean conjuntosIguales(ConjuntoTDA conjunto1, ConjuntoTDA conjunto2) {
        ConjuntoTDA temp1 = copiarConjunto(conjunto1);
        ConjuntoTDA temp2 = copiarConjunto(conjunto2);

        while (!temp1.conjuntoVacio()) {
            int elemento = temp1.elegir();
            if (!temp2.pertenece(elemento)) {
                return false;
            }
            temp1.sacar(elemento);
            temp2.sacar(elemento);
        }

        return temp2.conjuntoVacio();
    }

}
