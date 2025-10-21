// src/controller/FiguraController.java
package controller;

import model.*;
import service.CalculadoraService;
import java.util.Scanner;

public class FiguraController {
    private final Scanner scanner;
    private final CalculadoraService calculadora;

    public FiguraController() {
        this.scanner = new Scanner(System.in);
        this.calculadora = new CalculadoraService();
    }

    public void iniciar() {
        System.out.println("Bienvenido a la Calculadora de Figuras 3D");
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSeleccione una figura:");
            System.out.println("1. Caja");
            System.out.println("2. Cilindro");
            System.out.println("3. Esfera");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            try {
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1 -> crearYMostrarCaja();
                    case 2 -> crearYMostrarCilindro();
                    case 3 -> crearYMostrarEsfera();
                    case 4 -> continuar = false;
                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("¡Gracias por usar la calculadora!");
    }

    private void crearYMostrarCaja() {
        System.out.print("Ingrese longitud: ");
        double longitud = Double.parseDouble(scanner.nextLine());
        System.out.print("Ingrese anchura: ");
        double anchura = Double.parseDouble(scanner.nextLine());
        System.out.print("Ingrese altura: ");
        double altura = Double.parseDouble(scanner.nextLine());

        var caja = new Caja(longitud, anchura, altura);
        System.out.println("\n" + calculadora.obtenerDetallesFigura(caja));
    }

    private void crearYMostrarCilindro() {
        System.out.print("Ingrese radio: ");
        double radio = Double.parseDouble(scanner.nextLine());
        System.out.print("Ingrese altura: ");
        double altura = Double.parseDouble(scanner.nextLine());

        var cilindro = new Cilindro(radio, altura);
        System.out.println("\n" + calculadora.obtenerDetallesFigura(cilindro));
    }

    private void crearYMostrarEsfera() {
        System.out.print("Ingrese radio: ");
        double radio = Double.parseDouble(scanner.nextLine());

        var esfera = new Esfera(radio);
        System.out.println("\n" + calculadora.obtenerDetallesFigura(esfera));
    }
}