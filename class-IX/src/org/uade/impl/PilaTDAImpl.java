package org.uade.impl;

import org.uade.api.PilaTDA;

public class PilaTDAImpl implements PilaTDA {

    private int [] v;
    private int ult;

    @Override
    public void inicializarPila() {
        ult = 0;
        v = new int [100];
    }

    @Override
    public void apilar(int x) {
        v[ult] = x;
        ult++;
    }

    @Override
    public void desapilar() {
        ult--;
    }

    @Override
    public int tope() {
        return v[ult-1];
    }

    @Override
    public boolean pilaVacia() {
        if (ult == 0)
            return true;
        else
            return false;
    }
}
