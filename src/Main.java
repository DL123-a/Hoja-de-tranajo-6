import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione tipo de Map:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");

        int opcionMap = scanner.nextInt();
        scanner.nextLine();

        Map<String, String> inventarioMap = MapFactory.createMap(opcionMap);

        Inventario inventario = new Inventario(inventarioMap);

        inventario.cargarInventario("../inventario.txt");

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\nMENU");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar categoria de producto");
            System.out.println("3. Mostrar coleccion");
            System.out.println("0. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println("Ingrese producto:");
                    String productoAgregar = scanner.nextLine();

                    inventario.agregarProducto(productoAgregar);

                    break;

                case 2:

                    System.out.println("Ingrese producto:");
                    String productoBuscar = scanner.nextLine();

                    inventario.mostrarCategoria(productoBuscar);

                    break;

                case 3:

                    inventario.mostrarColeccion();

                    break;

                case 0:

                    System.out.println("Saliendo del programa...");
                    break;

                default:

                    System.out.println("Opcion invalida");
            }
        }

        scanner.close();
    }
}