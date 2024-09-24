package org.uade.app;

import org.uade.api.ColaTDA;
import org.uade.api.DiccionarioSimpleTDA;
import org.uade.api.PilaTDA;
import org.uade.impl.ColaTDAImpl;
import org.uade.impl.DiccionarioSimpleTDAImpl;
import org.uade.impl.PilaTDAImpl;
import org.uade.operacion.OperacionCola;

/*
Crea una aplicacion en la se pueda almacenar acciones y luego deshacerlas o rehacerlas.

Considerandos:
- Se deben usar al menos dos TDA distintos.
- Garantizar que no se pierdan datos al mostrar el contenido
 */
public class EjercicioDos {

    private ColaTDA accionesEjecutadas;
    private PilaTDA accionesDeshechas;
    private DiccionarioSimpleTDA detallesAcciones;
    private int contadorAcciones;

    public EjercicioDos() {
        this.accionesEjecutadas = new ColaTDAImpl();
        this.accionesDeshechas = new PilaTDAImpl();
        this.detallesAcciones = new DiccionarioSimpleTDAImpl();
        this.contadorAcciones = 0; // Para generar un identificador único para cada acción
        this.accionesEjecutadas.inicializarCola();
        this.accionesDeshechas.inicializarPila();
        this.detallesAcciones.inicializarDiccionario();
    }


    public static void main(String[] args) {
        EjercicioDos app = new EjercicioDos();
        app.execute();
    }

    public void execute() {
        ejecutarAccion("Guardar", "Archivo 1");
        ejecutarAccion("Imprimir", "Archivo 2");
        ejecutarAccion("Borrar", "Archivo 3");

        mostrarHistorial();

        deshacerAccion();
        rehacerAccion();
    }

    private void ejecutarAccion(String tipoAccion, String detalles) {
        contadorAcciones++;
        accionesEjecutadas.acolar(contadorAcciones);
        detallesAcciones.agregar(contadorAcciones, tipoAccion.hashCode()); // Guardamos un identificador único en el diccionario

        // Aquí se podrían agregar más detalles sobre la acción al diccionario si es necesario.
        System.out.println("Acción ejecutada: " + tipoAccion + " - Detalles: " + detalles);
    }

    public void deshacerAccion() {
        if (!accionesEjecutadas.colaVacia()) {
            int accion = accionesEjecutadas.primero();
            accionesEjecutadas.desacolar();
            accionesDeshechas.apilar(accion);

            String tipoAccion = obtenerTipoAccion(accion);
            System.out.println("Acción deshecha: " + tipoAccion);
        } else {
            System.out.println("No hay acciones para deshacer.");
        }
    }

    public void rehacerAccion() {
        if (!accionesDeshechas.pilaVacia()) {
            int accion = accionesDeshechas.tope();
            accionesDeshechas.desapilar();
            accionesEjecutadas.acolar(accion);

            String tipoAccion = obtenerTipoAccion(accion);
            System.out.println("Acción rehecha: " + tipoAccion);
        } else {
            System.out.println("No hay acciones para rehacer.");
        }
    }

    private String obtenerTipoAccion(int accionId) {
        int tipoHash = detallesAcciones.recuperar(accionId);
        return String.valueOf(tipoHash); // Convertimos el hash del tipo de acción a string (solo para este ejemplo)
    }

    public void mostrarHistorial() {
        OperacionCola operacionCola = new OperacionCola();
        ColaTDA colaAuxiliar = operacionCola.copiarCola(accionesEjecutadas);
        System.out.println("Historial de acciones:");
        while (!colaAuxiliar.colaVacia()) {
            int accionId = colaAuxiliar.primero();
            String tipoAccion = obtenerTipoAccion(accionId);
            System.out.println("Acción: " + tipoAccion);
            colaAuxiliar.desacolar();
        }
    }
}
