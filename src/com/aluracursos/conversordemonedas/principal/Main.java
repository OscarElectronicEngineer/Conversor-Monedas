package com.aluracursos.conversordemonedas.principal;

import com.aluracursos.conversordemonedas.modelos.CapturarDatosApi;
import com.aluracursos.conversordemonedas.modelos.ConversorMoneda;


import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // Códigos ANSI para colores
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        ConversorMoneda conversor = new ConversorMoneda();

        System.out.println(ANSI_GREEN + "============================================");
        System.out.println("🟢 BIENVENIDO AL CONVERSOR DE MONEDAS");
        System.out.println("============================================" + ANSI_RESET);

        while (true) {
            mostrarMenu(conversor.obtenerConversiones());
            int opcion = leerOpcion(scanner, conversor.obtenerConversiones().size());

            if (opcion == conversor.obtenerConversiones().size() + 1) {
                System.out.println("\n" + ANSI_RED + "👋 Gracias por usar el conversor. ¡Hasta pronto!" + ANSI_RESET);
                break;
            }

            String clave = conversor.obtenerConversiones().keySet().toArray(new String[0])[opcion - 1];
            String[] partes = clave.split("-");
            String origen = partes[0];
            String destino = partes[1];

            System.out.print("\n💵 Ingrese el monto que desea convertir: ");
            double monto = scanner.nextDouble();

            System.out.println("\n" + ANSI_CYAN + "🔄 Consultando conversión..." + ANSI_RESET);
            double resultado = CapturarDatosApi.capturarDatos(origen, destino, monto);

            System.out.println(ANSI_YELLOW + "--------------------------------------------");
            System.out.printf("💰 Resultado: %.2f %s = %.2f %s%n", monto, origen, resultado, destino);
            System.out.println("--------------------------------------------" + ANSI_RESET + "\n");
        }

        scanner.close();
    }

    private static void mostrarMenu(Map<String, String> conversiones) {
        System.out.println("\n" + ANSI_BLUE + "📋 Conversiones disponibles:");
        System.out.println("--------------------------------------------" + ANSI_RESET);
        int i = 1;
        for (String valor : conversiones.values()) {
            System.out.println(" " + i++ + ". " + valor);
        }
        System.out.println(" " + i + ". Salir");
        System.out.println(ANSI_BLUE + "--------------------------------------------" + ANSI_RESET);
    }

    private static int leerOpcion(Scanner scanner, int totalOpciones) {
        int opcion;
        while (true) {
            System.out.print(ANSI_GREEN + "🔢 Elige una opción: " + ANSI_RESET);
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= totalOpciones + 1) {
                    return opcion;
                }
            } else {
                scanner.next(); // descartar entrada inválida
            }
            System.out.println(ANSI_RED + "❌ Opción inválida. Intente nuevamente.\n" + ANSI_RESET);
        }
    }
}


