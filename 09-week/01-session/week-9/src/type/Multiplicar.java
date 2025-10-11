package type;

import functions.DataCaptionV2;

import javax.swing.text.html.parser.Parser;

public class Multiplicar {
    public static void main(String[] args) {
        DataCaptionV2 scanner = new DataCaptionV2();

        Byte table = Byte.valueOf(scanner.CaptionString("Digite el tipo de tabla de multiplicar a mostrar: "));
        Byte i=0;
        while(i<10){
            i++;
            System.out.println(table + " * " + i + " = " + (table*i) );
        }
    }
}
