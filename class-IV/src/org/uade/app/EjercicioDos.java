package org.uade.app;


import org.uade.api.PilaTDA;
import org.uade.impl.PilaTDAImpl;

/*
    Dado una expresión matemática (con paréntesis, corchetes y llaves),
    escribe un programa que verifique si la expresión está balanceada.
    Utiliza una pila para hacer un seguimiento de los paréntesis y asegura que
    cada apertura tenga un cierre correspondiente en el orden correcto.

 */
public class EjercicioDos {

    public static void main(String[] args) {
        EjercicioDos app = new EjercicioDos();
        app.execute();
    }

    public void execute() {
        PilaTDA pila = new PilaTDAImpl();
        String expresion = "{[3*(2+1)] + (4/2)}";

        if (estaBalanceada(expresion, pila)) {
            System.out.println("La expresión está balanceada.");
        } else {
            System.out.println("La expresión no está balanceada.");
        }
    }

    private boolean estaBalanceada(String expresion, PilaTDA pila) {
        pila.inicializarPila();

        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);

            // Apilamos los símbolos de apertura
            if (caracter == '(' || caracter == '{' || caracter == '[') {
                pila.apilar(caracter);
            }
            // Verificamos los símbolos de cierre
            else if (caracter == ')' || caracter == '}' || caracter == ']') {
                // Si la pila está vacía, la expresión no está balanceada
                if (pila.pilaVacia()) {
                    return false;
                }

                // Verificamos que el símbolo de cierre coincida con el de apertura
                char simboloDeApertura = (char) pila.tope();
                pila.desapilar();

                if (!coincide(simboloDeApertura, caracter)) {
                    return false;
                }
            }
        }

        return pila.pilaVacia();
    }

    private boolean coincide(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
                (apertura == '{' && cierre == '}') ||
                (apertura == '[' && cierre == ']');
    }
}
