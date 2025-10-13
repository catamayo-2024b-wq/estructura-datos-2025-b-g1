// Ejercicio2.java
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        HashTable<String, Integer> counter = new HashTable<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un texto (una línea).");
        String line = sc.nextLine();
        String[] words = line.split("\\W+"); // separa por no-palabra

        for (String w : words) {
            if (w.isEmpty()) continue;
            String key = w.toLowerCase();
            Integer old = counter.get(key);
            if (old == null) counter.put(key, 1);
            else counter.put(key, old + 1);
        }

        System.out.println("Conteo de palabras:");
        for (String w : words) {
            if (w.isEmpty()) continue;
            String k = w.toLowerCase();
            if (counter.containsKey(k)) {
                System.out.println(k + " -> " + counter.get(k));
                // para evitar repetir la impresión, eliminamos la clave después de imprimir
                counter.remove(k);
            }
        }
        sc.close();
    }
}
