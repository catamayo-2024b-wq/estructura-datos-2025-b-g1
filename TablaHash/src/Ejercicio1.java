// Ejercicio1.java
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        HashTable<String, String> dict = new HashTable<>();
        Scanner sc = new Scanner(System.in);
        int opt;

        do {
            System.out.println("\n--- Diccionario usuario->rol ---");
            System.out.println("1. Agregar/Actualizar usuario");
            System.out.println("2. Consultar rol por usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Mostrar tamaño");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            while (!sc.hasNextInt()) {
                System.out.println("Ingrese un número válido.");
                sc.nextLine();
            }
            opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1 -> {
                    System.out.print("Usuario: ");
                    String u = sc.nextLine().trim();
                    System.out.print("Rol: ");
                    String r = sc.nextLine().trim();
                    String old = dict.put(u, r);
                    if (old == null) System.out.println("Usuario agregado.");
                    else System.out.println("Rol actualizado (antes: " + old + ").");
                }
                case 2 -> {
                    System.out.print("Usuario a consultar: ");
                    String u = sc.nextLine().trim();
                    String role = dict.get(u);
                    System.out.println(role == null ? "Usuario no existe." : "Rol: " + role);
                }
                case 3 -> {
                    System.out.print("Usuario a eliminar: ");
                    String u = sc.nextLine().trim();
                    String removed = dict.remove(u);
                    System.out.println(removed == null ? "Usuario no encontrado." : "Usuario eliminado (rol: " + removed + ").");
                }
                case 4 -> System.out.println("Tamaño: " + dict.size());
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opt != 0);

        sc.close();
    }
}
