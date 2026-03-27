import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolInventario inventario = new ArbolInventario();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== Sistema de Inventario Tree-Stock ===");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Buscar Producto");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el ID del producto (número entero): ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Ingresa el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    inventario.insertar(id, nombre);
                    System.out.println("-> Producto registrado con éxito.");
                    break;
                case 2:
                    System.out.println("\n--- Inventario Actual (Ordenado por ID) ---");
                    inventario.recorridoInorden();
                    break;
                case 3:
                    System.out.print("Ingresa el ID del producto a buscar: ");
                    int idBuscar = scanner.nextInt();
                    boolean existe = inventario.buscar(idBuscar);
                    if (existe) {
                        System.out.println("-> El producto con ID " + idBuscar + " SÍ existe en el inventario.");
                    } else {
                        System.out.println("-> El producto NO existe.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo de Tree-Stock...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}