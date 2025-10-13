// Ejercicio4.java
public class Ejercicio4 {
    public static void main(String[] args) {
        HashTable<Integer, String> t = new HashTable<>(8);
        int N = 50;
        for (int i = 0; i < N; i++) {
            t.put(i, "val" + i);
        }
        System.out.println("Insertados: " + N + " elementos.");
        System.out.println("size() reporta: " + t.size());
        System.out.println("isEmpty(): " + t.isEmpty());

        // eliminar algunos
        for (int i = 0; i < 10; i++) {
            t.remove(i);
        }
        System.out.println("Tras eliminar 10: size() = " + t.size());
    }
}
