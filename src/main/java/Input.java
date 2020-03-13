import java.util.Scanner;

class Input {
    public int GetInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String GetString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
