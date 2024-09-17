package org.uade.app;


import org.uade.api.PilaTDA;
import org.uade.impl.PilaTDAImpl;
import org.uade.operacion.OperacionPila;

/*
Mostrar los elementos de una pila pero sin utilizar un while.
 */
public class EjercicioTres {

    public static void main(String[] args) {
        EjercicioTres app = new EjercicioTres();
        app.execute();
    }

    public void execute() {
        PilaTDA pila = new PilaTDAImpl(); // Implementa la clase Pila que sigue la interfaz PilaTDA
        pila.inicializarPila();

        // Ejemplo de carga de la pila
        pila.apilar(3);
        pila.apilar(1);
        pila.apilar(4);
        pila.apilar(2);
        pila.apilar(5);

        mostrarRecursivo(pila);
    }

    private void mostrarRecursivo(PilaTDA pila) {
        if (!pila.pilaVacia()) {
            System.out.println(pila.tope());
            pila.desapilar();
            mostrarRecursivo(pila);
        }
    }
}
