package org.uade.app;


import org.uade.api.PilaTDA;
import org.uade.impl.PilaTDAImpl;
import org.uade.operacion.OperacionPila;

/*
Cree, inicialice y cargue la pila DADA, ordenes los elementos
 */
public class EjercicioDos {

    public static void main(String[] args) {
        EjercicioDos app = new EjercicioDos();
        app.execute();
    }

    public void execute() {
        PilaTDA dada = new PilaTDAImpl(); // Implementa la clase Pila que sigue la interfaz PilaTDA
        dada.inicializarPila();

        // Ejemplo de carga de la pila
        dada.apilar(3);
        dada.apilar(1);
        dada.apilar(4);
        dada.apilar(2);
        dada.apilar(5);

        ordenarPila(dada);

        OperacionPila operacion = new OperacionPila();
        operacion.mostrar(dada);
    }

    public void ordenarPila(PilaTDA pila) {
        PilaTDA pilaAuxiliar = new PilaTDAImpl(); // Pila auxiliar para mantener los elementos ordenados
        pilaAuxiliar.inicializarPila();

        while (!pila.pilaVacia()) {
            int temp = pila.tope();
            pila.desapilar();

            // Mover los elementos mayores de la pila auxiliar a la pila original
            while (!pilaAuxiliar.pilaVacia() && pilaAuxiliar.tope() > temp) {
                pila.apilar(pilaAuxiliar.tope());
                pilaAuxiliar.desapilar();
            }

            // Insertar el elemento en la posición correcta
            pilaAuxiliar.apilar(temp);
        }

        // Restaurar los elementos de la pila auxiliar a la pila original (esto invierte el orden)
        while (!pilaAuxiliar.pilaVacia()) {
            pila.apilar(pilaAuxiliar.tope());
            pilaAuxiliar.desapilar();
        }
    }
}
