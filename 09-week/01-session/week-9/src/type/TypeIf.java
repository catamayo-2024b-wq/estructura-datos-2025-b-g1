package type;

import java.util.Scanner;

public class TypeIf {
    public static void main(String[] args) {
        // Validar si una persona es mayor o menor de edad.

        //Definir variables
        String namePerson;
        Integer age;

        //Crear scaner
        Scanner scanner = new Scanner(System.in);

        //Capturar datos
        System.out.print("Digite su nombre: ");
        namePerson = scanner.nextLine();
        System.out.print("Digite su edad: ");
        age = Integer.parseInt(scanner.nextLine());

        // Varificar si la persona es mayor o menor de edad.
        if(age>0 && age<=127){
            if(age >= 18){
                System.out.println(namePerson+" es mayor de edad.");
            }else{
                System.out.println(namePerson+" es menor de edad.");
            }
        }else{
            System.out.println("Edad no permitida para el programa.");
        }

    }
}
