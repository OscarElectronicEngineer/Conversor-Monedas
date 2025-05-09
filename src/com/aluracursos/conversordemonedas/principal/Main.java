package com.aluracursos.conversordemonedas.principal;

import com.aluracursos.conversordemonedas.modelos.CapturarDatosApi;
import com.aluracursos.conversordemonedas.modelos.ConversorMoneda;


import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        ConversorMoneda conversor = new ConversorMoneda();



        System.out.println("🟢 Bienvenido al Conversor de Monedas");

        while (true) {
            mostrarMenu(conversor.obtenerConversiones());
            int opcion = leerOpcion(scanner, conversor.obtenerConversiones().size());

            if (opcion == conversor.obtenerConversiones().size() + 1) {
                System.out.println("👋 Gracias por usar el conversor.");
                break;
            }

            String clave = conversor.obtenerConversiones().keySet().toArray(new String[0])[opcion - 1];
            String[] partes = clave.split("-");
            String origen = partes[0];
            String destino = partes[1];


            System.out.print("Ingrese el monto a convertir: ");
            double monto = scanner.nextDouble();

            System.out.println("🔄 Consultando conversión...");
            double resultado = CapturarDatosApi.capturarDatos(origen, destino, monto);

            System.out.printf("💰 Resultado: %.2f %s = %.2f %s%n", monto, origen, resultado, destino);
        }

        scanner.close();
    }

    private static void mostrarMenu(Map<String, String> conversiones) {
        System.out.println("\n Conversiones disponibles:");
        int i = 1;
        for (String valor : conversiones.values()) {
            System.out.println(i++ + ". " + valor);
        }
        System.out.println(i + ". Salir");
    }

    private static int leerOpcion(Scanner scanner, int totalOpciones) {
        int opcion;
        while (true) {
            System.out.print("Elige una opción: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= totalOpciones + 1) {
                    return opcion;
                }
            } else {
                scanner.next(); // descartar entrada inválida
            }
            System.out.println(" Opción inválida. Intente nuevamente.");
        }

    }
}
