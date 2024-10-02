package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.impl.ABBTDAImpl;

/*
Dado dos arboles se busca saber si el primero es prefijo del segundo.

Considerandos:
- Use el siguiente arbol
     10
    /  \
   5   20

y este otro

     10
    /  \
   5   20
  /   /
 2   15
 */
public class EjercicioSeis {

    public static void main(String[] args) {
        EjercicioSeis app = new EjercicioSeis();
        app.execute();
    }

    public void execute() {
        ABBTDA arbolA = new ABBTDAImpl();
        arbolA.inicializarArbol();
        arbolA.agregar(10);
        arbolA.agregar(5);
        arbolA.agregar(20);

        ABBTDA arbolB = new ABBTDAImpl();
        arbolB.inicializarArbol();
        arbolB.agregar(10);
        arbolB.agregar(5);
        arbolB.agregar(20);
        arbolB.agregar(2);
        arbolB.agregar(15);

        boolean esPrefijo = esPrefijo(arbolA, arbolB);
        System.out.println("¿El árbol A es prefijo del árbol B? " + esPrefijo);
    }

    private boolean esPrefijo(ABBTDA arbolA, ABBTDA arbolB) {
        // Si el árbol A está vacío, es prefijo de cualquier árbol
        if (arbolA.arbolVacio()) {
            return true;
        }

        // Si el árbol B está vacío, pero el árbol A no, entonces no puede ser prefijo
        if (arbolB.arbolVacio()) {
            return false;
        }

        // Verificamos si las raíces son iguales
        if (arbolA.raiz() != arbolB.raiz()) {
            return false;
        }

        // Comprobamos recursivamente para los hijos izquierdo y derecho
        boolean prefijoIzq = esPrefijo(arbolA.hijoIzq(), arbolB.hijoIzq());
        boolean prefijoDer = esPrefijo(arbolA.hijoDer(), arbolB.hijoDer());

        return prefijoIzq && prefijoDer;
    }

}
