package org.uade.app;

import org.uade.api.ConjuntoTDA;
import org.uade.api.PilaTDA;
import org.uade.impl.ConjuntoTDAImpl;
import org.uade.impl.PilaTDAImpl;
import org.uade.operacion.OperacionPila;

/*
Queremos almacenar los números agrupados por decenas (0-9, 10-19, 20-21). La idea es poder buscar por medio del primer número de la decena todos los que existan. Queremos garantizar que el último número de cada grupo sea el primero que saquemos.
 */
public class EjercicioDiez {

    private PilaTDA[] decenasPilas; // Arreglo de pilas para cada decena
    private ConjuntoTDA[] decenasConjuntos; // Arreglo de conjuntos para cada decena


    public static void main(String[] args) {
        EjercicioDiez app = new EjercicioDiez();
        app.execute();
    }

    public void execute() {

        // Crear 10 pilas y conjuntos para agrupar por decenas (0-9, 10-19, ..., 90-99)
        decenasPilas = new PilaTDA[10];
        decenasConjuntos = new ConjuntoTDA[10];

        for (int i = 0; i < 10; i++) {
            decenasPilas[i] = new PilaTDAImpl();
            decenasPilas[i].inicializarPila();
            decenasConjuntos[i] = new ConjuntoTDAImpl();
            decenasConjuntos[i].inicializarConjunto();
        }

        agregarNumero(52);
        agregarNumero(9);
        agregarNumero(0);
        agregarNumero(25);
        agregarNumero(99);

        sacarNumero(0);
        sacarNumero(0);

    }
    public void agregarNumero(int numero) {
        int decena = numero / 10; // Determinar la decena del número

        // Solo agregar si no está ya en el conjunto
        if (!decenasConjuntos[decena].pertenece(numero)) {
            decenasConjuntos[decena].agregar(numero); // Agregar al conjunto correspondiente
            decenasPilas[decena].apilar(numero); // Agregar a la pila correspondiente
        }
    }

    public void mostrarPorDecena(int decena) {
        if (decena < 0 || decena > 9) {
            System.out.println("Decena fuera de rango.");
            return;
        }

        PilaTDA pilaAux = new PilaTDAImpl(); // Pila auxiliar para mostrar los elementos
        pilaAux.inicializarPila();

        // Mostrar elementos de la pila correspondiente a la decena
        System.out.println("Elementos en la decena " + decena * 10 + "-" + (decena * 10 + 9) + ":");
        while (!decenasPilas[decena].pilaVacia()) {
            int elemento = decenasPilas[decena].tope();
            System.out.println(elemento);
            pilaAux.apilar(elemento); // Guardar el elemento en la pila auxiliar
            decenasPilas[decena].desapilar();
        }

        // Restaurar los elementos a la pila original
        while (!pilaAux.pilaVacia()) {
            decenasPilas[decena].apilar(pilaAux.tope());
            pilaAux.desapilar();
        }
    }

    public void sacarNumero(int decena) {
        if (decena < 0 || decena > 9) {
            System.out.println("Decena fuera de rango.");
            return;
        }

        // Sacar el último número agregado (comportamiento LIFO)
        if (!decenasPilas[decena].pilaVacia()) {
            int numero = decenasPilas[decena].tope();
            decenasPilas[decena].desapilar();
            decenasConjuntos[decena].sacar(numero); // Eliminar del conjunto también
            System.out.println("Número sacado: " + numero);
        } else {
            System.out.println("No hay números en la decena " + decena * 10 + "-" + (decena * 10 + 9));
        }
    }

}
