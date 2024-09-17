package org.uade.app;


import org.uade.api.ColaPrioridadTDA;
import org.uade.api.ColaTDA;
import org.uade.impl.ColaPrioridadTDAImpl;
import org.uade.impl.ColaTDAImpl;
import org.uade.operacion.OperacionCola;

/*
Eliminar de una cola con prioridad un elemento con una prioridad especifica
 */
public class EjercicioCinco {

    public static void main(String[] args) {
        EjercicioCinco app = new EjercicioCinco();
        app.execute();
    }

    public void execute() {
        ColaPrioridadTDA cola = new ColaPrioridadTDAImpl();
        cola.inicializarCola();

        // Ejemplo de carga de la pila
        cola.acolarPrioridad(3, 9);
        cola.acolarPrioridad(1, 5);
        cola.acolarPrioridad(4, 1);
        cola.acolarPrioridad(2, 4);
        cola.acolarPrioridad(5, 5);

        eliminarPorPrioridad(cola, 4);

        OperacionCola operacion = new OperacionCola();
        operacion.mostrar(cola);
    }

    private void eliminarPorPrioridad(ColaPrioridadTDA cola, int prioridadEliminar) {
        if (!cola.colaVacia()) {
            int elemento = cola.primero();
            int prioridad = cola.prioridad();
            cola.desacolar();

            eliminarPorPrioridad(cola, prioridadEliminar);

            // Volver a acolar solo si la prioridad no coincide con la que se quiere eliminar
            if (prioridad != prioridadEliminar) {
                cola.acolarPrioridad(elemento, prioridad);
            }
        }
    }
}
