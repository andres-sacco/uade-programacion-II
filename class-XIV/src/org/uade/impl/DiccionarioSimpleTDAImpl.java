package org.uade.impl;

import org.uade.api.ConjuntoTDA;
import org.uade.api.DiccionarioSimpleTDA;

import java.util.HashMap;

public class DiccionarioSimpleTDAImpl implements DiccionarioSimpleTDA {
    private HashMap<Integer, ConjuntoTDA> diccionario;

    public DiccionarioSimpleTDAImpl() {
        diccionario = new HashMap<>();
    }

    @Override
    public void inicializarDiccionario() {
        diccionario.clear();
    }

    @Override
    public void agregar(int clave, int valor) {
        if (!diccionario.containsKey(clave)) {
            ConjuntoTDA valores = new ConjuntoTDAImpl();
            valores.inicializarConjunto();
            diccionario.put(clave, valores);
        }
        diccionario.get(clave).agregar(valor);
    }

    @Override
    public void eliminar(int clave) {
        diccionario.remove(clave);
    }

    @Override
    public int recuperar(int clave) {
        if (diccionario.containsKey(clave)) {
            return diccionario.get(clave).elegir();
        }
        return -1; // o alguna otra indicación de "no encontrado"
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA clavesConjunto = new ConjuntoTDAImpl();
        clavesConjunto.inicializarConjunto();
        for (int clave : diccionario.keySet()) {
            clavesConjunto.agregar(clave);
        }
        return clavesConjunto;
    }
}
