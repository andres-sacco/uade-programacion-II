package org.uade.api;

public interface DiccionarioMultipleTDA {

    void inicializarDiccionario();

    void agregar(int clave, int valor);

    void eliminar(int clave);

    void eliminarValor(int clave, int valor);

    ConjuntoTDA recuperar(int clave);

    ConjuntoTDA claves();
}
