package type;

import functions.DataCaption;

import java.util.Scanner;

public class TypeIfFunctions {
    public static void main(String[] args) {
        // Validar si una persona es mayor o menor de edad.

        //Definir variables
        String namePerson;
        Integer age;

        //Crear scaner
        DataCaption scanner = new DataCaption();

        //Capturar datos
        scanner.setMessage("Digite su nombre: ");
        namePerson = scanner.CaptionString();

        scanner.setMessage("Digite su edad: ");
        age = Integer.parseInt(scanner.CaptionString());

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
