package org.example;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorDeMonedas conversor = new ConversorDeMonedas();

        // Obtener y mostrar las monedas disponibles
        Map<String, String> monedasDisponibles = conversor.obtenerMonedasDisponibles();
        System.out.println("Monedas disponibles:");
        for (Map.Entry<String, String> entry : monedasDisponibles.entrySet()) {
            System.out.printf("- %s: %s%n", entry.getKey(), entry.getValue());
        }

        while (true) {
            try {
                // Solicitar la moneda base
                System.out.print("Ingrese la moneda base (o 'exit' para salir): ");
                String monedaBase = scanner.nextLine().toUpperCase();

                // Salir si el usuario escribe "exit"
                if (monedaBase.equals("EXIT")) {
                    System.out.println("Saliendo del programa...");
                    break;
                }

                // Obtener las tasas de cambio disponibles
                Map<String, Double> tasas = conversor.obtenerTasasDeCambio(monedaBase);
                if (tasas.isEmpty()) {
                    System.out.println("Error: Moneda base no válida. Inténtelo de nuevo.");
                    continue; // Volver a pedir la moneda base
                }

                System.out.println("Monedas disponibles para conversión desde " + monedaBase + ":");

                // Mostrar las monedas disponibles con sus nombres completos
                for (String moneda : tasas.keySet()) {
                    String nombreCompleto = conversor.obtenerNombreMoneda(moneda);
                    System.out.printf("- %s: %s%n", moneda, nombreCompleto);
                }

                // Entrada de la moneda objetivo
                System.out.print("Ingrese la moneda objetivo: ");
                String monedaObjetivo = scanner.nextLine().toUpperCase();

                // Verificar si la moneda objetivo es válida
                if (!tasas.containsKey(monedaObjetivo)) {
                    System.out.println("Error: La moneda objetivo no está disponible.");
                    continue; // Volver a pedir la moneda base
                }

                // Entrada de la cantidad a convertir
                System.out.print("Ingrese la cantidad a convertir: ");
                double cantidad = scanner.nextDouble();
                scanner.nextLine();  // Consumir el salto de línea

                // Realizar la conversión
                double resultado = conversor.convertir(monedaBase, monedaObjetivo, cantidad);
                System.out.printf("Resultado: %.2f %s%n", resultado, monedaObjetivo);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
