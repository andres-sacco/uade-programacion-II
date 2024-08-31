package org.uade.app;

import org.uade.api.PilaTDA;
import org.uade.impl.PilaTDAImpl;

/*
    Implementa un algoritmo que evalúe una expresión en notación postfija utilizando una pila.
    Por ejemplo, la expresión 3 4 + 2 * debería devolver 14.
 */
public class EjercicioTres {

    public static void main(String[] args) {
        EjercicioTres app = new EjercicioTres();
        app.execute();
    }

    public void execute() {
        PilaTDA pila = new PilaTDAImpl();
        String expresion = "3 4 + 2 *";
        int resultado = evaluarExpresionPostfija(expresion, pila);
        System.out.println("El resultado de la expresión '" + expresion + "' es: " + resultado);
    }

    public int evaluarExpresionPostfija(String expresion, PilaTDA pila) {
        pila.inicializarPila();

        // Divide la expresión en tokens utilizando el espacio como delimitador
        String[] tokens = expresion.split(" ");

        for (String token : tokens) {
            // Si el token es un número, lo apilamos
            if (esNumero(token)) {
                pila.apilar(Integer.parseInt(token));
            } else {
                // Si el token es un operador, sacamos los dos últimos números de la pila
                int operando2 = pila.tope();
                pila.desapilar();
                int operando1 = pila.tope();
                pila.desapilar();

                // Realizamos la operación correspondiente y apilamos el resultado
                int resultado = getResultado(token, operando1, operando2);
                pila.apilar(resultado);
            }
        }
        // El resultado final estará en la cima de la pila
        return pila.tope();
    }

    private int getResultado(String token, int operando1, int operando2) {
        int resultado = 0;
        switch (token) {
            case "+":
                resultado = operando1 + operando2;
                break;
            case "-":
                resultado = operando1 - operando2;
                break;
            case "*":
                resultado = operando1 * operando2;
                break;
            case "/":
                resultado = operando1 / operando2;
                break;
        }
        return resultado;
    }

    private boolean esNumero(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
