package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.impl.ABBTDAImpl;
import org.uade.operacion.OperacionArbol;

/*
Dado un árbol binario, se busca poder Eliminar todos los elementos impares o pares dependiendo de un parametro.
La eliminación será siempre que sean superiores a un parametro
 */
public class EjercicioDiecisiete {

    public static void main(String[] args) {
        EjercicioDiecisiete app = new EjercicioDiecisiete();
        app.execute();
    }

    public void execute() {
        ABBTDA arbol = new ABBTDAImpl();
        arbol.inicializarArbol();

        // Agregamos nodos al árbol
        arbol.agregar(10);
        arbol.agregar(5);
        arbol.agregar(20);
        arbol.agregar(3);
        arbol.agregar(7);
        arbol.agregar(15);
        arbol.agregar(30);

        // Queremos extraer el subárbol con la raíz en el valor 5
        eliminarCondicional(arbol, true, 25);

        OperacionArbol operacion = new OperacionArbol();
        operacion.mostrarArbolInorden(arbol);
    }


    private void eliminarCondicional(ABBTDA arbol, boolean eliminarPares, int valorMinimo) {
        if (!arbol.arbolVacio()) {
            // Recursión en los hijos
            eliminarCondicional(arbol.hijoIzq(), eliminarPares, valorMinimo);
            eliminarCondicional(arbol.hijoDer(), eliminarPares, valorMinimo);

            // Verificamos si la raíz del árbol actual cumple las condiciones para eliminarse
            int valorRaiz = arbol.raiz();
            boolean esPar = valorRaiz % 2 == 0;

            if ((eliminarPares && esPar && valorRaiz > valorMinimo) ||
                    (!eliminarPares && !esPar && valorRaiz > valorMinimo)) {
                // Si cumple la condición de ser par o impar y es mayor al valorMinimo, se elimina
                arbol.eliminar(valorRaiz);
            }
        }
    }

}