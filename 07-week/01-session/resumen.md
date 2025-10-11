# Resumen - Semana 07

## Ejemplo de Notas

### Estructura de Datos

#### Datos Básicos
* **documento**: Identificación del estudiante
* **nombre**: Nombre completo del estudiante  
* **correo**: Correo electrónico del estudiante

#### Datos de la Materia
* **codigo**: Código único de la materia
* **nombre**: Nombre de la materia
* **programa**: Programa académico al que pertenece

#### Datos de la Calificación
* **estudiante[documento]**: Referencia al documento del estudiante
* **materia[codigo]**: Referencia al código de la materia
* **nf**: Nota final

#### Desagregación de las Notas

##### Actividades (porcentajes)
* **taller**: Calificación de talleres
* **foro**: Calificación de participación en foros
* **quiz**: Calificación de quices

##### Parciales
* **parte1**: Primera parte del parcial
* **parte2**: Segunda parte del parcial

##### Evaluaciones Complementarias
* **autoevaluacion**: Autoevaluación del estudiante
* **coevaluacion**: Coevaluación entre pares

### Ejemplo de Código Java

```java
// Creación de objeto Estudiante
Estudiante estudiante = new Estudiante();

// Tipos de datos primitivos y wrapper
Integer numero;  // Wrapper class - puede ser null
int numero;      // Tipo primitivo - no puede ser null

double numero;   // Tipo primitivo - precisión doble
Double numero;   // Wrapper class - puede ser null
```

### Notas Importantes
* Los tipos primitivos (`int`, `double`) no pueden ser `null`
* Los wrapper classes (`Integer`, `Double`) pueden ser `null`
* Los wrapper classes proporcionan métodos adicionales para manipular los datos