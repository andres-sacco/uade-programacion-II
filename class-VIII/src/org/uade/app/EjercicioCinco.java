package org.uade.app;

import org.uade.api.ConjuntoTDA;
import org.uade.api.PilaTDA;
import org.uade.impl.ConjuntoTDAImpl;
import org.uade.impl.PilaTDAImpl;
import org.uade.operacion.OperacionPila;

/*
Queremos evitar la ocurrencia de múltiples números pero a la vez queremos saber
la cantidad de ocurrencias de cada elemento.

Considerandos:
- Se deben usar al menos dos TDA distintos.
- Garantizar el orden de los elementos.
- No usar un diccionario
 */
public class EjercicioCinco {

    public static void main(String[] args) {
        EjercicioCinco app = new EjercicioCinco();
        app.execute();
    }

    public void execute() {

        PilaTDA pila = new PilaTDAImpl();
        pila.inicializarPila();
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(2);
        pila.apilar(2);
        pila.apilar(5);
        pila.apilar(5);
        pila.apilar(5);

        contarOcurrencias(pila);

        OperacionPila operacionPila = new OperacionPila();
        operacionPila.mostrar(pila);
    }

    public void contarOcurrencias(PilaTDA pila) {
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();

        PilaTDA pilaElementos = new PilaTDAImpl(); // Pila para los elementos únicos
        PilaTDA pilaContadores = new PilaTDAImpl(); // Pila para los contadores de ocurrencias
        pilaElementos.inicializarPila();
        pilaContadores.inicializarPila();

        PilaTDA pilaAux = new PilaTDAImpl(); // Pila auxiliar para restaurar el orden
        pilaAux.inicializarPila();

        // Paso 1: Recorrer la pila y contar ocurrencias
        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            pila.desapilar();

            if (!conjunto.pertenece(elemento)) {
                // Si no está en el conjunto, agregarlo al conjunto y a la pila de elementos
                conjunto.agregar(elemento);
                pilaElementos.apilar(elemento);
                pilaContadores.apilar(1); // Iniciamos el contador en 1
            } else {
                // Si ya está en el conjunto, incrementar el contador correspondiente
                PilaTDA pilaElementosTemp = new PilaTDAImpl();
                PilaTDA pilaContadoresTemp = new PilaTDAImpl();
                pilaElementosTemp.inicializarPila();
                pilaContadoresTemp.inicializarPila();

                // Buscar el elemento en la pila de elementos
                while (pilaElementos.tope() != elemento) {
                    pilaElementosTemp.apilar(pilaElementos.tope());
                    pilaContadoresTemp.apilar(pilaContadores.tope());
                    pilaElementos.desapilar();
                    pilaContadores.desapilar();
                }

                // Incrementar el contador
                int contadorActual = pilaContadores.tope();
                pilaContadores.desapilar();
                pilaContadores.apilar(contadorActual + 1);

                // Restaurar las pilas
                while (!pilaElementosTemp.pilaVacia()) {
                    pilaElementos.apilar(pilaElementosTemp.tope());
                    pilaContadores.apilar(pilaContadoresTemp.tope());
                    pilaElementosTemp.desapilar();
                    pilaContadoresTemp.desapilar();
                }
            }

            // Guardamos el elemento en la pila auxiliar para mantener el orden original
            pilaAux.apilar(elemento);
        }

        // Paso 2: Restaurar la pila original
        while (!pilaAux.pilaVacia()) {
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }

        // Paso 3: Mostrar los elementos y sus ocurrencias
        System.out.println("Elementos y ocurrencias:");
        while (!pilaElementos.pilaVacia()) {
            System.out.println("Elemento: " + pilaElementos.tope() + ", Ocurrencias: " + pilaContadores.tope());
            pilaElementos.desapilar();
            pilaContadores.desapilar();
        }
    }

}
