import java.util.ArrayList;
import java.util.Scanner;

public class TallerEstructuraDatos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ArrayList: estructura dinámica para productos
        ArrayList<String> productos = new ArrayList<>();

        // Vector (array) de categorías fijas
        String[] categorias = {"Tecnología", "Hogar", "Aseo", "Bebidas", "Snacks"};

        int opcion = -1;

        do {
            System.out.println("\n--- MENÚ DE TECHMARKET ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Mostrar categorías");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            // validar entrada de opción (si no es entero, consumir y pedir de nuevo)
            if (!sc.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                sc.nextLine(); // limpiar buffer
                continue;
            }

            opcion = sc.nextInt();
            sc.nextLine(); // consumir newline

            switch (opcion) {
                case 1 -> { // Agregar producto
                    System.out.print("Ingrese nombre del producto: ");
                    String p = sc.nextLine().trim();

                    // Validación mínima: no permitir campos vacíos
                    if (!p.isEmpty()) {
                        productos.add(p);
                        System.out.println("Producto agregado correctamente.");
                    } else {
                        System.out.println("El nombre no puede estar vacío.");
                    }
                }

                case 2 -> { // Listar productos
                    System.out.println("\nProductos registrados:");
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos registrados.");
                    } else {
                        // Uso de ciclo for para recorrer ArrayList
                        for (int i = 0; i < productos.size(); i++) {
                            System.out.println((i + 1) + ". " + productos.get(i));
                        }
                    }
                }

                case 3 -> { // Eliminar producto
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos para eliminar.");
                        break;
                    }
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    String eliminar = sc.nextLine().trim();

                    if (eliminar.isEmpty()) {
                        System.out.println("El nombre no puede estar vacío.");
                    } else {
                        // Validar existencia antes de eliminar
                        boolean removed = productos.remove(eliminar);
                        if (removed) {
                            System.out.println("Producto eliminado con éxito.");
                        } else {
                            System.out.println("El producto no existe en la lista.");
                        }
                    }
                }

                case 4 -> { // Mostrar categorías
                    System.out.println("Categorías disponibles:");
                    // Uso de ciclo for-each para recorrer el vector (array)
                    for (String cat : categorias) {
                        System.out.println("* " + cat);
                    }
                }

                case 0 -> System.out.println("Saliendo del sistema...");

                default -> System.out.println("Opción no válida, intente de nuevo.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
