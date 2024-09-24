package org.uade.app;

import org.uade.api.ConjuntoTDA;
import org.uade.impl.ConjuntoTDAImpl;
import org.uade.operacion.OperacionConjunto;

/*
Crear una aplicacion que dado dos conjuntos devuelva un nuevo conjunto que contenga
los elementos que están en uno u otro conjunto, pero no en ambos.
 */
public class EjercicioCuatro {

    public static void main(String[] args) {
        EjercicioCuatro app = new EjercicioCuatro();
        app.execute();
    }

    public void execute() {
        ConjuntoTDA conjuntoA = new ConjuntoTDAImpl();
        conjuntoA.inicializarConjunto();

        conjuntoA.agregar(1);
        conjuntoA.agregar(2);
        conjuntoA.agregar(5);

        ConjuntoTDA conjuntoB = new ConjuntoTDAImpl();
        conjuntoB.inicializarConjunto();

        conjuntoB.agregar(3);
        conjuntoB.agregar(2);
        conjuntoB.agregar(6);

        ConjuntoTDA resultado = diferenciaSimetrica(conjuntoA, conjuntoB);

        OperacionConjunto operacion = new OperacionConjunto();
        operacion.mostrarConjunto(resultado);

    }


    private ConjuntoTDA diferenciaSimetrica(ConjuntoTDA conjuntoA, ConjuntoTDA conjuntoB) {
        ConjuntoTDA resultado = new ConjuntoTDAImpl();
        resultado.inicializarConjunto();

        // Agregar los elementos de conjuntoA que no están en conjuntoB
        ConjuntoTDA tempA = copiarConjunto(conjuntoA);
        while (!tempA.conjuntoVacio()) {
            int elemento = tempA.elegir();
            tempA.sacar(elemento);

            if (!conjuntoB.pertenece(elemento)) {
                resultado.agregar(elemento);
            }
        }

        // Agregar los elementos de conjuntoB que no están en conjuntoA
        ConjuntoTDA tempB = copiarConjunto(conjuntoB);
        while (!tempB.conjuntoVacio()) {
            int elemento = tempB.elegir();
            tempB.sacar(elemento);

            if (!conjuntoA.pertenece(elemento)) {
                resultado.agregar(elemento);
            }
        }

        return resultado;
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

}
