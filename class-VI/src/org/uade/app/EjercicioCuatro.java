package org.uade.app;


import org.uade.api.ColaTDA;
import org.uade.api.PilaTDA;
import org.uade.impl.ColaTDAImpl;
import org.uade.impl.PilaTDAImpl;
import org.uade.operacion.OperacionCola;

/*
Eliminar de una cola un elemento específico con recursión.
 */
public class EjercicioCuatro {

    public static void main(String[] args) {
        EjercicioCuatro app = new EjercicioCuatro();
        app.execute();
    }

    public void execute() {
        ColaTDA cola = new ColaTDAImpl();
        cola.inicializarCola();

        // Ejemplo de carga de la pila
        cola.acolar(3);
        cola.acolar(1);
        cola.acolar(4);
        cola.acolar(2);
        cola.acolar(5);

        eliminarElemento(cola, 4);

        OperacionCola operacion = new OperacionCola();
        operacion.mostrar(cola);
    }

    private void eliminarElemento(ColaTDA cola, int elemento) {
        if (!cola.colaVacia()) {
            int frente = cola.primero();
            cola.desacolar();

            eliminarElemento(cola, elemento);

            if (frente != elemento) {
                cola.acolar(frente);
            }
        }
    }
}
