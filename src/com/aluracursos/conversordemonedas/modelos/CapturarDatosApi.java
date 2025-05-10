package com.aluracursos.conversordemonedas.modelos;

import com.google.gson.Gson;


import java.io.IOException;

import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class CapturarDatosApi {

    private static final String API_KEY = "";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static double capturarDatos(String monedaOrigen, String monedaDestino, double monto) {
        String url = BASE_URL + API_KEY + "/pair/" + monedaOrigen + "/" + monedaDestino + "/" + monto;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException(" Error al conectar con la API: " + response.statusCode());
            }

            Moneda moneda = new Gson().fromJson(response.body(), Moneda.class);
            return moneda.conversion_result();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(" Fallo en la petición HTTP: " + e.getMessage());
        }
    }




}
