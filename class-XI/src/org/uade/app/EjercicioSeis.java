package org.uade.app;

import org.uade.api.ConjuntoTDA;
import org.uade.api.DiccionarioSimpleTDA;
import org.uade.impl.ConjuntoTDAImpl;
import org.uade.impl.DiccionarioSimpleTDAImpl;

/*
Verifica si dos conjuntos son disjuntos (sin elementos comunes)
 */
public class EjercicioSeis {

    public static void main(String[] args) {
        EjercicioSeis app = new EjercicioSeis();
        app.execute();
    }

    private void execute() {
        ConjuntoTDA conjunto1 = new ConjuntoTDAImpl();
        conjunto1.inicializarConjunto();
        conjunto1.agregar(1);
        conjunto1.agregar(2);
        conjunto1.agregar(3);

        ConjuntoTDA conjunto2 = new ConjuntoTDAImpl();
        conjunto2.inicializarConjunto();
        conjunto2.agregar(4);
        conjunto2.agregar(5);
        conjunto2.agregar(6);
        //conjunto2.agregar(3); // Ahora conjunto2 contiene un elemento de conjunto1

        boolean resultado = sonDisjuntos(conjunto1, conjunto2);
        System.out.println("¿Los conjuntos son disjuntos? " + resultado);
    }

    public boolean sonDisjuntos(ConjuntoTDA conjunto1, ConjuntoTDA conjunto2) {
        // Iterar sobre el primer conjunto
        ConjuntoTDA copiaConjunto1 = new ConjuntoTDAImpl();
        copiaConjunto1.inicializarConjunto();

        // Hacer una copia del conjunto1 para no modificar el original
        while (!conjunto1.conjuntoVacio()) {
            int elemento = conjunto1.elegir();
            conjunto1.sacar(elemento);
            copiaConjunto1.agregar(elemento);
        }

        // Comprobar si algún elemento de conjunto1 está en conjunto2
        while (!copiaConjunto1.conjuntoVacio()) {
            int elemento = copiaConjunto1.elegir();
            if (conjunto2.pertenece(elemento)) {
                return false; // Se encontró un elemento común
            }
            copiaConjunto1.sacar(elemento);
        }

        return true; // No se encontraron elementos comunes
    }

}
