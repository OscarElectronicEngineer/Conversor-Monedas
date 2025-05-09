package com.aluracursos.conversordemonedas.modelos;


import java.util.LinkedHashMap;
import java.util.Map;

public class ConversorMoneda {

    private final Map<String, String> conversiones;

    public ConversorMoneda() {
        this.conversiones = new LinkedHashMap<>();
        inicializarConversiones();
    }

    private void inicializarConversiones() {
        agregarConversion("USD", "ARS");
        agregarConversion("ARS", "USD");
        agregarConversion("USD", "BRL");
        agregarConversion("BRL", "USD");
        agregarConversion("USD", "COP");
        agregarConversion("COP", "USD");
    }

    private void agregarConversion(String origen, String destino) {
        String clave = origen + "-" + destino;
        String valor = origen + " → " + destino;
        conversiones.put(clave, valor);
    }



    public Map<String, String> obtenerConversiones() {return conversiones;}


}
