import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import Class.Estudiante;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        //Construir un scaner para captudad datos
        Scanner scanner = new Scanner(System.in);

        //Definir las variables del sistema
        /*********************
         * Dato de estudiante
         ********************/
        String documento;
        String nombre;
        String correo;

        //String[] nombres = {estudiante.DatoEstudiante()};
        //ArrayList<String> nombres = new ArrayList<>(Arrays.asList("Ana", "Luis", "María"));
        String[] nombres = new String[10];

        int i =0;
        Boolean control = true;

        //Crear objeto de la clase estudiante
        Estudiante estudiante = new Estudiante();
        while (control== true){
            //Capturar datos
            System.out.print("Digite el documento del estudiante: ");
            documento = scanner.nextLine();
            System.out.print("Digite el nombre del estudiante: ");
            nombre = scanner.nextLine();
            System.out.print("Digite el correo del estudiante: ");
            correo = scanner.nextLine();

            estudiante.setDocumento(documento);
            estudiante.setNombre(nombre);
            estudiante.setCorreo(correo);
            //System.out.println(estudiante.DatoEstudiante());

            // Agregar nuevos elementos
            //nombres.add(estudiante.getNombre());
            nombres[i] = estudiante.getNombre();

            String respuesta;
            System.out.print("Desea agregar otro estudiante S/N:");
            respuesta = scanner.nextLine();
            System.out.println("****|"+respuesta+"|**** |N|");
            if(respuesta.equals("N")){
                control=false;
            }
            i++;
        }

        //System.out.println(nombres);

        i =0;
        for (i=0; i<nombres.length;i++){
            System.out.println(nombres[i]);
        }


        /*****
         * Integer numero;
         * int numero;
         *
         * double numero;
         * Double numero;
         */

        Integer numero;
        int numero2;

        double numero3;
        Double numero4;
    }
}

