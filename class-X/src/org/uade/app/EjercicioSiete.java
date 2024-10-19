package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.impl.ABBTDAImpl;

/*
Recibe un árbol binario (a) y un entero (k) mayor a 0.
Retorna una array con todos los elementos presentes en el nivel k del arbol a ordenados de de menor a mayor

Ejemplo entrada:
        4
      /   \
     2     6
    / \   / \
   1   3 5   7
 */
public class EjercicioSiete {

    public static void main(String[] args) {
        EjercicioSiete app = new EjercicioSiete();
        app.execute();
    }

    public void execute() {
        ABBTDA arbol = new ABBTDAImpl();
        arbol.inicializarArbol();

        // Agregar algunos valores al árbol
        arbol.agregar(4);
        arbol.agregar(2);
        arbol.agregar(6);
        arbol.agregar(1);
        arbol.agregar(3);
        arbol.agregar(5);
        arbol.agregar(7);

        int[] resultado = elementosEnNivelK(arbol, 3); // La raíz está en el nivel 1

        if (resultado != null) {
            System.out.print("Elementos en el nivel 3: ");
            for (int val : resultado) {
                System.out.print(val + " ");
            }
        } else {
            System.out.println("No hay elementos en el nivel especificado.");
        }

    }

    // Metodo que retorna un array con los elementos en el nivel k, ordenados de menor a mayor
    public int[] elementosEnNivelK(ABBTDA arbol, int k) {
        if (arbol.arbolVacio()) {
            return null; // Si el árbol es vacío, retornamos null
        }

        // Definimos un array con un tamaño suficiente (asumimos que 100 nodos es más que suficiente para el nivel)
        int[] elementosNivelK = new int[100];
        int[] contador = {0};  // Usamos un array de tamaño 1 para llevar la cuenta de los elementos encontrados

        obtenerElementosNivel(arbol, 1, k, elementosNivelK, contador);

        // Si no hay elementos en el nivel k, retornamos null
        if (contador[0] == 0) {
            return null;
        }

        // Redimensionamos el array para que tenga el tamaño exacto de los elementos encontrados
        int[] resultado = new int[contador[0]];
        System.arraycopy(elementosNivelK, 0, resultado, 0, contador[0]);

        // Ordenamos el array manualmente usando Bubble Sort
        bubbleSort(resultado);

        return resultado;
    }

    // Metodo recursivo para obtener los elementos en el nivel k
    private void obtenerElementosNivel(ABBTDA arbol, int nivelActual, int k, int[] elementos, int[] contador) {
        if (arbol.arbolVacio()) {
            return; // Si el árbol es vacío, no hacemos nada
        }

        if (nivelActual == k) {
            // Añadimos el valor del nodo en el array de elementos en el nivel k
            elementos[contador[0]] = arbol.raiz();
            contador[0]++; // Aumentamos el contador de elementos encontrados
        } else {
            // Seguimos recorriendo los hijos izquierdo y derecho
            obtenerElementosNivel(arbol.hijoIzq(), nivelActual + 1, k, elementos, contador);
            obtenerElementosNivel(arbol.hijoDer(), nivelActual + 1, k, elementos, contador);
        }
    }

    // Metodo para ordenar el array usando Bubble Sort
    private void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Intercambiamos los elementos
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}