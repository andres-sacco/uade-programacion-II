package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.impl.ABBTDAImpl;

/*
Crear un metodo que me permita saber si el arbol equiponderado.

Considerandos:
- Es equiponderado si, para cada nodo del árbol, se cumple que el valor almacenado en ese nodo
  es igual a la suma de los valores de sus hijos izquierdo y derecho
- Use el siguiente arbol
        10
       /  \
      5    20
     / \   / \
    3   7 15 25

- Use el siguiente arbol
        10
       /  \
      5    5
 */
public class EjercicioTres {

    public static void main(String[] args) {
        EjercicioTres app = new EjercicioTres();
        app.execute();
    }

    public void execute() {
        ABBTDA arbol1 = new ABBTDAImpl();
        arbol1.inicializarArbol();
        arbol1.agregar(10);
        arbol1.agregar(5);
        arbol1.agregar(20);
        arbol1.agregar(3);
        arbol1.agregar(7);
        arbol1.agregar(15);
        arbol1.agregar(25);

        System.out.println("¿El árbol es equiponderado?: " + esEquiponderado(arbol1));

        ABBTDA arbol2 = new ABBTDAImpl();
        arbol2.inicializarArbol();
        arbol2.agregar(10);
        arbol2.agregar(9);
        arbol2.agregar(1);  // Los valores de los hijos suman 10, que es la raíz.

        System.out.println("¿El árbol es equiponderado?: " + esEquiponderado(arbol2));
    }


    private boolean esEquiponderado(ABBTDA arbol) {
        // Si el árbol está vacío o es una hoja (nodo sin hijos), se considera equiponderado
        if (arbol.arbolVacio() || (arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio())) {
            return true;
        }

        // Obtener los valores de los hijos
        int valorIzq = arbol.hijoIzq().arbolVacio() ? 0 : arbol.hijoIzq().raiz();
        int valorDer = arbol.hijoDer().arbolVacio() ? 0 : arbol.hijoDer().raiz();

        // Verificar si el nodo actual cumple la propiedad de ser equiponderado
        if (arbol.raiz() != valorIzq + valorDer) {
            return false;
        }

        // Recursivamente comprobar la condición para los hijos izquierdo y derecho
        return esEquiponderado(arbol.hijoIzq()) && esEquiponderado(arbol.hijoDer());
    }
}
