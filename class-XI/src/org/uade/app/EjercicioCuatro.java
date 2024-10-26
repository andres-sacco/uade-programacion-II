package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.api.ConjuntoTDA;
import org.uade.api.DiccionarioSimpleTDA;
import org.uade.impl.ABBTDAImpl;
import org.uade.impl.ConjuntoTDAImpl;
import org.uade.impl.DiccionarioSimpleTDAImpl;
import org.uade.operacion.OperacionDiccionario;

/*
Se busca combinar un arbol con un conjunto guardando el resultado en un diccionario Simple.

Se buscan contar la cantidad de ocurrencias de cada valor
 */
public class EjercicioCuatro {

    public static void main(String[] args) {
        EjercicioCuatro app = new EjercicioCuatro();
        app.execute();
    }

    private void execute() {
        ABBTDA arbol = new ABBTDAImpl();
        arbol.inicializarArbol();
        arbol.agregar(1);
        arbol.agregar(5);
        arbol.agregar(20);
        arbol.agregar(40);

        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();
        conjunto.agregar(1);
        conjunto.agregar(70);
        conjunto.agregar(30);

        DiccionarioSimpleTDA diccionario = new DiccionarioSimpleTDAImpl();
        diccionario.inicializarDiccionario();

        // Combinamos el árbol y el conjunto, y guardamos en el diccionario
        combinarArbolConConjuntoEnDiccionario(arbol, conjunto, diccionario);

        // Mostrar el resultado del diccionario (para verificar)
        OperacionDiccionario operacion = new OperacionDiccionario();
        operacion.mostrarDiccionario(diccionario);

    }

    public void combinarArbolConConjuntoEnDiccionario(ABBTDA arbol, ConjuntoTDA conjunto, DiccionarioSimpleTDA diccionario) {
        // Procesar elementos del árbol y agregar al diccionario
        contarOcurrenciasArbol(arbol, diccionario);

        // Procesar elementos del conjunto y agregar al diccionario
        contarOcurrenciasConjunto(conjunto, diccionario);
    }

    // Función auxiliar para recorrer el árbol y agregar las ocurrencias al diccionario
    private static void contarOcurrenciasArbol(ABBTDA arbol, DiccionarioSimpleTDA diccionario) {
        if (!arbol.arbolVacio()) {
            int valor = arbol.raiz();
            agregarOcurrenciaAlDiccionario(valor, diccionario);
            contarOcurrenciasArbol(arbol.hijoIzq(), diccionario); // Recorrer el hijo izquierdo
            contarOcurrenciasArbol(arbol.hijoDer(), diccionario); // Recorrer el hijo derecho
        }
    }

    // Función auxiliar para recorrer el conjunto y agregar las ocurrencias al diccionario
    private static void contarOcurrenciasConjunto(ConjuntoTDA conjunto, DiccionarioSimpleTDA diccionario) {
        ConjuntoTDA aux = new ConjuntoTDAImpl(); // Conjunto auxiliar para no perder los elementos
        aux.inicializarConjunto();

        while (!conjunto.conjuntoVacio()) {
            int valor = conjunto.elegir(); // Obtener un elemento del conjunto
            agregarOcurrenciaAlDiccionario(valor, diccionario); // Agregar al diccionario
            conjunto.sacar(valor); // Sacar el elemento del conjunto
            aux.agregar(valor); // Guardar el valor en el conjunto auxiliar
        }

        // Restaurar el conjunto original
        while (!aux.conjuntoVacio()) {
            int valor = aux.elegir();
            aux.sacar(valor);
            conjunto.agregar(valor);
        }
    }

    // Función auxiliar para agregar un valor al diccionario y contar su ocurrencia
    private static void agregarOcurrenciaAlDiccionario(int valor, DiccionarioSimpleTDA diccionario) {
        if (diccionario.claves().pertenece(valor)) {
            int ocurrencias = diccionario.recuperar(valor);
            diccionario.eliminar(valor);
            diccionario.agregar(valor, ocurrencias + 1);
        } else {
            diccionario.agregar(valor, 1);
        }
    }
}
