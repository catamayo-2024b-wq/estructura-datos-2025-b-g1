import java.time.LocalDate;
import java.util.Scanner;

public class BibliotecaU1 {

    // ======== CONFIGURACIÓN ========
    static final int MAX_LIBROS = 20;   // Tamaño fijo del catálogo
    static final int SUCURSALES = 3;   // Número de sucursales

    // ======== ESTRUCTURAS ========
    static class Libro {
        int codigo;
        String titulo;
        String autor;
        int stock;
        boolean activo;

        Libro(int cod, String tit, String aut, int stk) {
            codigo = cod;
            titulo = tit;
            autor = aut;
            stock = stk;
            activo = true;
        }

        public String toString() {
            return "[Código:" + codigo + " | Título:" + titulo + " | Autor:" + autor +
                    " | Stock:" + stock + " | Activo:" + (activo ? "Sí" : "No") + "]";
        }
    }

    static class PrestamoNode {
        int codigoLibro;
        String usuario;
        LocalDate fecha;
        boolean devuelto;
        PrestamoNode siguiente;

        PrestamoNode(int codLibro, String usr, LocalDate f) {
            codigoLibro = codLibro;
            usuario = usr;
            fecha = f;
            devuelto = false;
            siguiente = null;
        }

        public String toString() {
            return "[Libro:" + codigoLibro + " | Usuario:" + usuario +
                    " | Fecha:" + fecha + " | Devuelto:" + (devuelto ? "Sí" : "No") + "]";
        }
    }

    static class HistorialNode {
        String tipoOperacion;
        String detalle;
        LocalDate fecha;
        HistorialNode anterior;
        HistorialNode siguiente;

        HistorialNode(String tipo, String det, LocalDate f) {
            tipoOperacion = tipo;
            detalle = det;
            fecha = f;
        }

        public String toString() {
            return "[" + fecha + "] " + tipoOperacion + " -> " + detalle;
        }
    }

    // ======== VARIABLES GLOBALES ========
    static Libro[] catalogo = new Libro[MAX_LIBROS];
    static int[][] disponibilidad = new int[MAX_LIBROS][SUCURSALES];
    static int cantidadLibros = 0;

    static PrestamoNode prestamosCabeza = null;
    static HistorialNode historialCabeza = null;
    static HistorialNode historialCola = null;

    static Scanner sc = new Scanner(System.in);

    // ======== MÉTODOS DEL CATÁLOGO ========
    static void cargarLibro() {
        if (cantidadLibros >= MAX_LIBROS) {
            System.out.println("Catálogo lleno.");
            return;
        }
        System.out.print("Código: ");
        int codigo = sc.nextInt(); sc.nextLine();
        if (buscarIndicePorCodigo(codigo) != -1) {
            System.out.println("Ya existe un libro con ese código.");
            return;
        }
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Stock: ");
        int stock = sc.nextInt(); sc.nextLine();

        Libro libro = new Libro(codigo, titulo, autor, stock);
        for (int i = 0; i < MAX_LIBROS; i++) {
            if (catalogo[i] == null) {
                catalogo[i] = libro;
                cantidadLibros++;
                for (int s = 0; s < SUCURSALES; s++) {
                    disponibilidad[i][s] = stock / SUCURSALES;
                }
                historial("ALTA", libro.toString());
                break;
            }
        }
    }

    static void eliminarLibro() {
        System.out.print("Código del libro a dar de baja: ");
        int codigo = sc.nextInt(); sc.nextLine();
        int idx = buscarIndicePorCodigo(codigo);
        if (idx == -1) {
            System.out.println("No encontrado.");
            return;
        }
        catalogo[idx].activo = false;
        historial("BAJA", catalogo[idx].toString());
        System.out.println("Libro dado de baja.");
    }

    static void buscarLibroPorTitulo() {
        System.out.print("Título a buscar: ");
        String titulo = sc.nextLine().toLowerCase();
        for (int i = 0; i < MAX_LIBROS; i++) {
            if (catalogo[i] != null && catalogo[i].activo &&
                    catalogo[i].titulo.toLowerCase().contains(titulo)) {
                System.out.println(catalogo[i]);
            }
        }
    }

    static void listarCatalogo() {
        for (int i = 0; i < MAX_LIBROS; i++) {
            if (catalogo[i] != null && catalogo[i].activo) {
                System.out.println(catalogo[i]);
            }
        }
    }

    static int buscarIndicePorCodigo(int codigo) {
        for (int i = 0; i < MAX_LIBROS; i++) {
            if (catalogo[i] != null && catalogo[i].activo && catalogo[i].codigo == codigo) {
                return i;
            }
        }
        return -1;
    }

    // ======== PRÉSTAMOS (LISTA SIMPLE) ========
    static void prestarLibro() {
        System.out.print("Código del libro a prestar: ");
        int codigo = sc.nextInt(); sc.nextLine();
        int idx = buscarIndicePorCodigo(codigo);
        if (idx == -1 || catalogo[idx].stock <= 0) {
            System.out.println("Libro no disponible.");
            return;
        }
        System.out.print("Usuario: ");
        String usuario = sc.nextLine();

        PrestamoNode nuevo = new PrestamoNode(codigo, usuario, LocalDate.now());
        nuevo.siguiente = prestamosCabeza;
        prestamosCabeza = nuevo;

        catalogo[idx].stock--;
        historial("PRESTAMO", nuevo.toString());
        System.out.println("Préstamo registrado.");
    }

    static void devolverLibro() {
        System.out.print("Código del libro a devolver: ");
        int codigo = sc.nextInt(); sc.nextLine();

        PrestamoNode prev = null, curr = prestamosCabeza;
        while (curr != null && (curr.codigoLibro != codigo || curr.devuelto)) {
            prev = curr;
            curr = curr.siguiente;
        }
        if (curr == null) {
            System.out.println("No se encontró préstamo activo.");
            return;
        }
        curr.devuelto = true;
        if (prev == null) prestamosCabeza = curr.siguiente;
        else prev.siguiente = curr.siguiente;

        int idx = buscarIndicePorCodigo(codigo);
        if (idx != -1) catalogo[idx].stock++;

        historial("DEVOLUCION", curr.toString());
        System.out.println("Devolución registrada.");
    }

    static void listarPrestamos() {
        PrestamoNode curr = prestamosCabeza;
        while (curr != null) {
            System.out.println(curr);
            curr = curr.siguiente;
        }
    }

    // ======== HISTORIAL (LISTA DOBLE) ========
    static void historial(String tipo, String detalle) {
        HistorialNode nuevo = new HistorialNode(tipo, detalle, LocalDate.now());
        if (historialCabeza == null) {
            historialCabeza = historialCola = nuevo;
        } else {
            historialCola.siguiente = nuevo;
            nuevo.anterior = historialCola;
            historialCola = nuevo;
        }
    }

    static void listarHistorialAdelante() {
        HistorialNode curr = historialCabeza;
        while (curr != null) {
            System.out.println(curr);
            curr = curr.siguiente;
        }
    }

    static void listarHistorialAtras() {
        HistorialNode curr = historialCola;
        while (curr != null) {
            System.out.println(curr);
            curr = curr.anterior;
        }
    }

    // ======== MENÚ ========
    public static void main(String[] args) {
        int op;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Alta libro");
            System.out.println("2. Baja libro");
            System.out.println("3. Buscar por título");
            System.out.println("4. Listar catálogo");
            System.out.println("5. Prestar libro");
            System.out.println("6. Devolver libro");
            System.out.println("7. Listar préstamos");
            System.out.println("8. Historial adelante");
            System.out.println("9. Historial atrás");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1: cargarLibro(); break;
                case 2: eliminarLibro(); break;
                case 3: buscarLibroPorTitulo(); break;
                case 4: listarCatalogo(); break;
                case 5: prestarLibro(); break;
                case 6: devolverLibro(); break;
                case 7: listarPrestamos(); break;
                case 8: listarHistorialAdelante(); break;
                case 9: listarHistorialAtras(); break;
            }
        } while (op != 0);
    }
}