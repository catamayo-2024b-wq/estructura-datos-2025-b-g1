package functions;

import java.util.Scanner;

public class DataCaptionV2 {
    String data;
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String CaptionString(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        this.setData(scanner.nextLine());
        return this.getData();
    }
}
