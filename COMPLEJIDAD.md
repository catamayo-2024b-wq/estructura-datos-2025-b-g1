# 📈 Análisis de Complejidad - Tabla Hash

## 🧠 Introducción
La estructura de datos **HashTable** permite almacenar pares clave-valor (`K, V`) y acceder a ellos de forma eficiente usando una **función hash**, la cual convierte la clave en un índice dentro de un arreglo.  
Cuando dos claves generan el mismo índice (colisión), el conflicto se resuelve mediante **encadenamiento**, es decir, una lista enlazada de entradas en esa posición.

---

## ⚙️ Operaciones implementadas
La clase `HashTable<K, V>` implementa los siguientes métodos:

| Operación | Descripción |
|------------|--------------|
| `put(K key, V value)` | Inserta o actualiza un elemento según la clave. |
| `get(K key)` | Devuelve el valor asociado a una clave. |
| `remove(K key)` | Elimina un elemento si la clave existe. |
| `containsKey(K key)` | Verifica si una clave está presente. |
| `size()` | Devuelve el número total de elementos. |
| `isEmpty()` | Indica si la tabla está vacía. |

---

## ⏱️ Análisis de complejidad temporal

| Operación | Complejidad promedio | Complejidad peor caso | Justificación |
|------------|----------------------|------------------------|----------------|
| `put(K key, V value)` | **O(1)** | **O(n)** | En promedio, cada clave se ubica en un índice distinto. En el peor caso, todas las claves colisionan en el mismo índice y la lista se recorre completa. |
| `get(K key)` | **O(1)** | **O(n)** | En promedio, la búsqueda se hace directamente por índice. Si hay muchas colisiones, puede requerir recorrer una lista enlazada. |
| `remove(K key)` | **O(1)** | **O(n)** | Igual que `get`, depende de la cantidad de colisiones por índice. |
| `containsKey(K key)` | **O(1)** | **O(n)** | Internamente realiza una búsqueda, por lo tanto su complejidad es la misma. |
| `size()` | **O(1)** | **O(1)** | Se mantiene un contador que actualiza el tamaño al insertar o eliminar. |
| `isEmpty()` | **O(1)** | **O(1)** | Solo evalúa si el tamaño (`size`) es igual a cero. |

---

## 💡 Conclusión
La tabla hash proporciona un rendimiento **muy eficiente** en la mayoría de los casos, ya que sus operaciones básicas (`put`, `get`, `remove`) tienen un **tiempo promedio constante O(1)**.  
Sin embargo, si hay **muchas colisiones** (por una mala función hash o un tamaño insuficiente), el rendimiento puede degradarse hasta **O(n)**.  
Por ello, es fundamental usar una **buena función hash y un tamaño adecuado del arreglo** para mantener el desempeño óptimo.

---

## 🧩 Referencias
- Weiss, M. A. (2014). *Data Structures and Algorithm Analysis in Java*. Pearson.  
- Goodrich, M., Tamassia, R. (2010). *Data Structures and Algorithms in Java*. Wiley.  
- Oracle Java Docs: [https://docs.oracle.com/javase/](https://docs.oracle.com/javase/)
