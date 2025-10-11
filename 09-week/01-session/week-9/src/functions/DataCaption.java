package functions;

import java.util.Scanner;

public class DataCaption {
    String message;
    String data;

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String CaptionString(){
        Scanner scanner = new Scanner(System.in);
        System.out.print(this.getMessage());
        this.setData(scanner.nextLine());
        return this.getData();
    }
}
