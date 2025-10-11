package type;
import functions.DataCaptionV2;

public class TypeIfFunctionsV2 {
    public static void main(String[] args) {
        // Validar si una persona es mayor o menor de edad.

        //Definir variables
        String namePerson;
        Integer age;

        //Crear scaner
        DataCaptionV2 scanner = new DataCaptionV2();

        //Capturar datos
        namePerson = scanner.CaptionString("Digite su nombre: ");
        age = Integer.parseInt(scanner.CaptionString("Digite su edad: "));

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
