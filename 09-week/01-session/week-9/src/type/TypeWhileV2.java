package type;

import functions.DataCaptionV2;

import java.util.Scanner;

public class TypeWhileV2 {
    public static void main(String[] args) {
        // Validar si una persona es mayor o menor de edad.

        //Definir variables
        String namePerson;
        Integer age;
        Boolean control;

        //Crear scaner
        DataCaptionV2 scanner = new DataCaptionV2();
        //Scanner scanner = new Scanner(System.in);


        // Varificar si la persona es mayor o menor de edad.
        control = true;

        //Capturar datos

        /*System.out.print("Digite su nombre: ");
        namePerson = scanner.nextLine();*/
        namePerson = scanner.CaptionString("Digite su nombre: ");

        while (control == true) {
            //Capturar datos
            /*System.out.print("Digite su edad: ");
            age = Integer.parseInt(scanner.nextLine());*/
            age = Integer.parseInt(scanner.CaptionString("Digite su edad: "));

            if (age > 0 && age <= 127) {
                if (age >= 18) {
                    System.out.println(namePerson + " es mayor de edad.");
                } else {
                    System.out.println(namePerson + " es menor de edad.");
                }
                control = false;
            } else {
                System.out.println("Edad no permitida para el programa,  "+namePerson+" ingresa de nuevo tús datos");
            }
        }


    }
}
