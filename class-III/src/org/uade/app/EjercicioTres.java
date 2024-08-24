package org.uade.app;

import org.uade.api.PilaTDA;
import org.uade.impl.PilaTDAImpl;
import org.uade.operacion.OperacionPila;

import java.util.Scanner;
/*
    Cree e inicialice las pilas DADA, VALOR, PAR, IMPAR. Cargue desde el teclado la pila DADA.
    Cargue la pila VALOR con al menos un valor. Determine si la cantidad de elementos de la
    pila DADA es par. Si es par, pase el elemento del tope de la pila VALOR a la pila PAR
    y sino páselo a la pila IMPAR.
 */
public class EjercicioTres {

    public static void main(String[] args) {
        EjercicioTres app = new EjercicioTres();
        app.execute();
    }

    public void execute() {
        PilaTDA dada = new PilaTDAImpl();
        PilaTDA valor = new PilaTDAImpl();
        PilaTDA par = new PilaTDAImpl();
        PilaTDA impar = new PilaTDAImpl();
        dada.inicializarPila();
        valor.inicializarPila();
        par.inicializarPila();
        impar.inicializarPila();

        //Llenado de pilas
        OperacionPila operacion = new OperacionPila();
        Scanner scanner = new Scanner(System.in);
        operacion.llenar(dada, scanner, "dada");
        operacion.llenar(valor, scanner, "valor");
        scanner.close();

        int cantidadElementos = operacion.contarElementos(dada);

        // Si la cantidad de elementos es par, pasar el tope de VALOR a PAR, sino a IMPAR
        if (cantidadElementos % 2 == 0) {
            operacion.pasarPila(valor, par);
            System.out.println("Elementos en PAR:");
            operacion.mostrar(par);

        } else {
            operacion.pasarPila(valor, impar);
            System.out.println("Elementos en IMPAR:");
            operacion.mostrar(impar);
        }
    }

}
