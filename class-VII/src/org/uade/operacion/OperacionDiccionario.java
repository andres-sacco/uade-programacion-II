package org.uade.operacion;

import org.uade.api.ConjuntoTDA;
import org.uade.api.DiccionarioSimpleTDA;

public class OperacionDiccionario {

    public void mostrarDiccionario(DiccionarioSimpleTDA diccionario) {
        ConjuntoTDA claves = diccionario.claves();  // Obtenemos las claves del diccionario

        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();  // Elegimos una clave del conjunto
            int valor = diccionario.recuperar(clave);  // Recuperamos el valor asociado a esa clave

            System.out.println("Elemento: " + clave + " - Valor: " + valor);

            claves.sacar(clave);  // Sacamos la clave del conjunto para avanzar a la siguiente
        }
    }
}
