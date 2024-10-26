package org.uade.app;

import org.uade.api.ColaTDA;
import org.uade.impl.ColaTDAImpl;
import org.uade.operacion.OperacionCola;

/*
Toma dos colas y combínalas de forma alternada en una nueva cola.
*/
public class EjercicioDos {

    public static void main(String[] args) {
        EjercicioDos app = new EjercicioDos();
        app.execute();
    }

    public void execute() {
        ColaTDA colaUno = new ColaTDAImpl();
        colaUno.inicializarCola();
        colaUno.acolar(1);
        colaUno.acolar(2);
        colaUno.acolar(3);
        colaUno.acolar(4);

        ColaTDA colaDos = new ColaTDAImpl();
        colaDos.inicializarCola();
        colaDos.acolar(5);
        colaDos.acolar(6);
        colaDos.acolar(7);
        colaDos.acolar(8);

        ColaTDA resultado = combinarColasAlternadas(colaUno, colaDos);

        OperacionCola operacion = new OperacionCola();
        operacion.mostrar(resultado);
    }

    private ColaTDA combinarColasAlternadas(ColaTDA cola1, ColaTDA cola2) {
        ColaTDA nuevaCola = new ColaTDAImpl(); // Cola para el resultado final
        nuevaCola.inicializarCola();

        // Combina alternadamente los elementos de las dos colas
        while (!cola1.colaVacia() || !cola2.colaVacia()) {
            if (!cola1.colaVacia()) {
                nuevaCola.acolar(cola1.primero());
                cola1.desacolar();
            }
            if (!cola2.colaVacia()) {
                nuevaCola.acolar(cola2.primero());
                cola2.desacolar();
            }
        }

        return nuevaCola;
    }

}