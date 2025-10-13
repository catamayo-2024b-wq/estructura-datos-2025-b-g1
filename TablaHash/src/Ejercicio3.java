// Ejercicio3.java
public class Ejercicio3 {
    // Clase Key con hashCode controlado para provocar colisiones
    static class BadKey {
        private final String id;
        private final int forcedHash;

        BadKey(String id, int forcedHash) {
            this.id = id;
            this.forcedHash = forcedHash;
        }

        @Override
        public int hashCode() {
            return forcedHash; // fuerza el mismo índice en la tabla
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof BadKey)) return false;
            BadKey other = (BadKey) o;
            return id.equals(other.id);
        }

        @Override
        public String toString() {
            return id;
        }
    }

    public static void main(String[] args) {
        HashTable<BadKey, String> table = new HashTable<>(4); // pequeña para ver colisiones
        BadKey k1 = new BadKey("A", 7);
        BadKey k2 = new BadKey("B", 7);
        BadKey k3 = new BadKey("C", 7);

        table.put(k1, "valorA");
        table.put(k2, "valorB");
        table.put(k3, "valorC");

        System.out.println("Después de insertar 3 claves con mismo hash:");
        table.debugPrintBuckets();

        System.out.println("Buscando B -> " + table.get(k2));
        System.out.println("Eliminando A -> " + table.remove(k1));
        System.out.println("Buckets tras eliminar A:");
        table.debugPrintBuckets();
    }
}
