package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.impl.ABBTDAImpl;

/*
Dado un árbol binario de elementos,  crear un metodo que retorne el numero de nodos
que son  hojas y son hijos izquierdos al mismo tiempo.

Considerandos:
- Use el siguiente arbol
            10
           /  \
          5    20
         / \   / \
        2   6 15  30
 */
public class EjercicioCinco{

    public static void main(String[] args) {
        EjercicioCinco app = new EjercicioCinco();
        app.execute();
    }

    public void execute() {
        ABBTDA arbol = new ABBTDAImpl();
        arbol.inicializarArbol();
        arbol.agregar(10);
        arbol.agregar(5);
        arbol.agregar(2);
        arbol.agregar(6);
        arbol.agregar(20);
        arbol.agregar(15);
        arbol.agregar(30);

        int hojasHijoIzq = contarHojasHijoIzq(arbol, null);
        System.out.println("Número de nodos que son hojas e hijos izquierdos: " + hojasHijoIzq);
    }

    // Metodo que retorna el número de nodos que son hojas y a la vez hijos izquierdos
    private int contarHojasHijoIzq(ABBTDA arbol, ABBTDA padre) {
        if (arbol.arbolVacio()) {
            return 0; // Si el árbol está vacío, no hay nodos que contar
        }

        // Verificamos si el nodo actual es una hoja (sin hijos)
        boolean esHoja = arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio();

        // Verificamos si es hijo izquierdo (padre != null y el hijo izquierdo del padre es igual al nodo actual)
        boolean esHijoIzq = padre != null && padre.hijoIzq() == arbol;

        // Contamos el nodo actual si es hoja y hijo izquierdo
        int cuentaActual = (esHoja && esHijoIzq) ? 1 : 0;

        // Recursivamente contamos en los hijos izquierdo y derecho
        int cuentaIzq = contarHojasHijoIzq(arbol.hijoIzq(), arbol);
        int cuentaDer = contarHojasHijoIzq(arbol.hijoDer(), arbol);

        // Retornamos la suma de los conteos
        return cuentaActual + cuentaIzq + cuentaDer;
    }
}
