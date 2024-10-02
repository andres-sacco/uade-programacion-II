package org.uade.app;


import org.uade.api.ABBTDA;
import org.uade.impl.ABBTDAImpl;

/*
Dado dos arboles binarios, se quiere comprobar si ambos tienen la misma estructura.

Considerandos:
- No es necesario comprobar si tienen los mismos valores.
 */
public class EjercicioUno {

    public static void main(String[] args) {
        EjercicioUno app = new EjercicioUno();
        app.execute();
    }

    public void execute() {
        ABBTDA arbol1 = new ABBTDAImpl();
        arbol1.inicializarArbol();
        arbol1.agregar(10);
        arbol1.agregar(5);
        arbol1.agregar(20);

        ABBTDA arbol2 = new ABBTDAImpl();
        arbol2.inicializarArbol();
        arbol2.agregar(15);
        arbol2.agregar(3);
        arbol2.agregar(25);

        System.out.println("¿Tienen la misma estructura?: " + mismaEstructura(arbol1, arbol2));


        ABBTDA arbol3 = new ABBTDAImpl();
        arbol3.inicializarArbol();
        arbol3.agregar(10);
        arbol3.agregar(5);

        ABBTDA arbol4 = new ABBTDAImpl();
        arbol4.inicializarArbol();
        arbol4.agregar(15);
        arbol4.agregar(20);
        arbol4.agregar(3);

        System.out.println("¿Tienen la misma estructura?: " + mismaEstructura(arbol3, arbol4));
    }


    private boolean mismaEstructura(ABBTDA arbol1, ABBTDA arbol2) {
        // Si ambos árboles están vacíos, tienen la misma estructura
        if (arbol1.arbolVacio() && arbol2.arbolVacio()) {
            return true;
        }

        // Si uno está vacío y el otro no, entonces no tienen la misma estructura
        if (arbol1.arbolVacio() || arbol2.arbolVacio()) {
            return false;
        }

        // Recursivamente comprobamos la estructura de los hijos izquierdo y derecho
        return mismaEstructura(arbol1.hijoIzq(), arbol2.hijoIzq()) &&
                mismaEstructura(arbol1.hijoDer(), arbol2.hijoDer());
    }

}
