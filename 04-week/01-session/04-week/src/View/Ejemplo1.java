package View;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.rmi.ConnectIOException;

public class Ejemplo1 {
    public static void main(String[] args) {
        /*
            Obtener la calificación final de de corte
            Se conoce:
            - Nota de corte de compode de: Parcial + Trabajos + AutoCoe + Certificación

            Peso[70] Parcial{práctica + teoría}
            Peso[10] Certicación{curso}
            Peso[15] Trabajos{taller + foro + quiz}
            Peso[5] AutoCoe{coe + auto}
         */

        //Notas globales
        Double Parcial; //70%
        Double Certificacion; //10%
        Double Trabajos; //15%
        Double AutoCoe; //5%

        // Notas para parcial
        Double Practica;
        Double Teoria;

        //Notas trabajos
        Double Taller;
        Double Foro;
        Double Quiz;

        //Notas para AutoCoe
        Double Autoevaluacion;
        Double Coevaluacion;

        //Nota definitiva
        Double Definitiva;

        //Nombre del estudiuante
        String Estudiante;
        //Realizar proceso

        // Llenar nombre
        Estudiante = JOptionPane.showInputDialog(null, "Nombre del estudiante: ");

        // Obtener definitica de parcial
        Practica = 5.0;
        Teoria = 5.0;
        Parcial = ((Practica + Teoria)/2)*0.7;
        System.out.println("Nota alcanza en parcial: "+Parcial);

        //Llenas data
        Certificacion = 5.0 * 0.1;
        System.out.println("Nota de certificación obtenida es: "+Certificacion);

        // Obtener la calificación de nota talleres
        Foro = 5.0;
        Quiz = 5.0;
        Taller = 5.0;

        Trabajos = ((Taller+Quiz+Foro)/3)*0.15;
        System.out.println("Nota obtenida de trabajos: "+Trabajos);

        //Auto y Coe
        Autoevaluacion = 5.0;
        Coevaluacion = 5.0;
        AutoCoe = ((Autoevaluacion+Coevaluacion)/2)*0.05;
        System.out.println("Nota obtenida por auto y coe es: "+AutoCoe);


        //Nota definitiva
        Definitiva = Parcial + Trabajos + Certificacion + AutoCoe;
        System.out.println(Estudiante+" obtuvo una nota de corte de: "+Definitiva);

    }
}
