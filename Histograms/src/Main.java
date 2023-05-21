import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc = new Scanner(new File("2.in"));
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(sc.nextLine());
            for (int j = 0; j < num; j++) {
                System.out.print('+');
            }
            System.out.println();
        }
    }
}