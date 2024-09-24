package org.uade.app;

import org.uade.api.ColaTDA;
import org.uade.api.ConjuntoTDA;
import org.uade.api.DiccionarioSimpleTDA;
import org.uade.impl.ColaTDAImpl;
import org.uade.impl.DiccionarioSimpleTDAImpl;
import org.uade.operacion.OperacionDiccionario;

/*
Crear una aplicacion que dado una serie de elementos,
podamos saber la cantidad de ocurrencias del mismo.

Considerandos:
- Se deben usar al menos dos TDA distintos.
- Garantizar el orden de los elementos.
 */
public class EjercicioUno {

    public static void main(String[] args) {
        EjercicioUno app = new EjercicioUno();
        app.execute();
    }

    public void execute() {
        ColaTDA cola = new ColaTDAImpl();
        cola.inicializarCola();
        cola.acolar(1);
        cola.acolar(2);
        cola.acolar(2);
        cola.acolar(2);
        cola.acolar(5);
        cola.acolar(5);
        cola.acolar(5);

        DiccionarioSimpleTDA resultado = contarElementos(cola);

        OperacionDiccionario operacion = new OperacionDiccionario();
        operacion.mostrarDiccionario(resultado);
    }

    public DiccionarioSimpleTDA contarElementos(ColaTDA cola) {
        DiccionarioSimpleTDA diccionario = new DiccionarioSimpleTDAImpl();
        diccionario.inicializarDiccionario();

        // Procesamos los elementos de la cola
        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            cola.desacolar();

            // Verificamos si el elemento ya está en el diccionario
            ConjuntoTDA claves = diccionario.claves();
            if (claves.pertenece(elemento)) {
                // Si el elemento ya está en el diccionario, incrementamos su valor
                int valorActual = diccionario.recuperar(elemento);
                diccionario.agregar(elemento, valorActual + 1);
            } else {
                // Si el elemento no está en el diccionario, lo agregamos con valor 1
                diccionario.agregar(elemento, 1);
            }
        }
        return diccionario;
    }

}
