package org.uade.app;

import org.uade.api.ABBTDA;
import org.uade.api.ConjuntoTDA;
import org.uade.api.DiccionarioSimpleTDA;
import org.uade.impl.ABBTDAImpl;
import org.uade.impl.ConjuntoTDAImpl;
import org.uade.impl.DiccionarioSimpleTDAImpl;
import org.uade.operacion.OperacionDiccionario;

/*
Dado un diccionario, invierte las claves y los valores (si es posible).
 */
public class EjercicioCinco {

    public static void main(String[] args) {
        EjercicioCinco app = new EjercicioCinco();
        app.execute();
    }

    private void execute() {

        DiccionarioSimpleTDA diccionario = new DiccionarioSimpleTDAImpl();
        diccionario.inicializarDiccionario();

        // Agregar algunos valores al diccionario
        diccionario.agregar(1, 10);
        diccionario.agregar(2, 20);
        diccionario.agregar(3, 30);
        diccionario.agregar(4, 10); // Valor duplicado para ilustrar el manejo de duplicados

        // Invertir el diccionario
        DiccionarioSimpleTDA diccionarioInvertido = invertirDiccionario(diccionario);

        // Mostrar el diccionario invertido
        ConjuntoTDA clavesInvertidas = diccionarioInvertido.claves();
        while (!clavesInvertidas.conjuntoVacio()) {
            int clave = clavesInvertidas.elegir();
            clavesInvertidas.sacar(clave);
            System.out.println("Clave: " + clave + ", Valor: " + diccionarioInvertido.recuperar(clave));
        }

    }

    public static DiccionarioSimpleTDA invertirDiccionario(DiccionarioSimpleTDA diccionario) {
        DiccionarioSimpleTDA diccionarioInvertido = new DiccionarioSimpleTDAImpl();
        diccionarioInvertido.inicializarDiccionario();

        ConjuntoTDA clavesOriginales = diccionario.claves();
        while (!clavesOriginales.conjuntoVacio()) {
            int clave = clavesOriginales.elegir();
            clavesOriginales.sacar(clave);
            int valor = diccionario.recuperar(clave);

            // Verificar si el valor ya está como clave en el diccionario invertido
            if (!claveExistente(diccionarioInvertido, valor)) {
                diccionarioInvertido.agregar(valor, clave);
            } else {
                System.out.println("Valor duplicado encontrado: " + valor + ". No se puede invertir.");
            }
        }
        return diccionarioInvertido;
    }

    private static boolean claveExistente(DiccionarioSimpleTDA diccionario, int clave) {
        ConjuntoTDA claves = diccionario.claves();
        while (!claves.conjuntoVacio()) {
            if (claves.elegir() == clave) {
                return true;
            }
            claves.sacar(claves.elegir());
        }
        return false;
    }

}
