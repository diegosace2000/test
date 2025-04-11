import java.util.Scanner;

public class TeatroMoroVentas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double precioBase = 100.00;

        String ubicacionAsiento = "";
        int edad = 0;
        double descuento = 0.0;
        double precioFinal = 0.0;

        while (true) {
            System.out.println("Bienvenido al Teatro Moro");
            System.out.println("1. Comprar entrada");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            
            if (opcion == 2) {
                System.out.println("¡Gracias por visitar el Teatro Moro!");
                break;
            }

            if (opcion == 1) {
                System.out.println("Seleccione la ubicación del asiento:");
                System.out.println("Zona 1 - 30.000$");
                System.out.println("Zona 2 - 15.000$");
                System.out.println("Zona 3 - 10.000$");
                System.out.print("Ingrese la zona (1-3): ");
                String zona = scanner.next().toUpperCase();

                if (zona.equals("1") || zona.equals("2") || zona.equals("3")) {
                    if (zona.equals("1")) {
                        precioBase = 30.000;
                    } else if (zona.equals("2")) {
                        precioBase = 15.000;
                    } else {
                        precioBase = 10.000;
                    }
                    ubicacionAsiento = zona;
                } else {
                    System.out.println("Opción inválida de zona.");
                    continue;
                }

                boolean edadValida = false;
                while (!edadValida) {
                    System.out.print("Ingrese su edad: ");
                    edad = scanner.nextInt();
                    
                    if (edad > 4) {
                        edadValida = true;
                    } else {
                        System.out.println("Edad inválida. Por favor ingrese una edad válida.");
                    }
                }
          
                
                 if (edad < 18) {
                    System.out.println("No se aplican descuentos para menores de 18 años.");
                    descuento = 0;
                } else if (edad >= 18 && edad <= 25) {
                    System.out.println("¡Descuento del 10% por ser estudiante!");
                    descuento = 0.10;
                } else if (edad >= 60) {
                    System.out.println("¡Descuento del 15% por ser persona de la tercera edad!");
                    descuento = 0.15;
                } else {
                    descuento = 0;
                }
                precioFinal = precioBase * (1 - descuento);
                System.out.println("Resumen de la compra:");
                System.out.println("Ubicación del asiento: Zona " + ubicacionAsiento);
                System.out.println("Precio base: $" + precioBase);
                System.out.println("Descuento aplicado: " + (descuento * 100) + "%");
                System.out.println("Precio final a pagar: $" + precioFinal);
                
                // Paso 4: Permitir que el usuario realice otra compra o salga
                System.out.print("¿Desea realizar otra compra? (S/N): ");
                char respuesta = scanner.next().toUpperCase().charAt(0);
                if (respuesta == 'N') {
                    System.out.println("¡Gracias por su compra!");
                    break;
                }
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        
        scanner.close();
    }
}
