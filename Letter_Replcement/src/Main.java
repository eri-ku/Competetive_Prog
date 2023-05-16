import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new File("1.in"));
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            String[] message = sc.nextLine().split(" ");
            String code = sc.nextLine();
            StringBuilder answer = new StringBuilder();
            for (int j = 0; j < message.length; j++) {
                for (int k = 0; k < message[j].length(); k++) {
                    char c = message[j].charAt(k);
                    answer.append(code.charAt((int)(c)-65));
                }
                answer.append(" ");
            }
            System.out.println((i+1) + " " + answer);
        }

    }
}