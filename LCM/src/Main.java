
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            int[] numbers = new int[k];
            for (int j = 0; j < k; j++) {
                numbers[j] = sc.nextInt();
            }
            int result = 1;
            for (var number : numbers) {
                result = (result * number) / GCD(result, number);
            }
            System.out.println(result);

        }


    }

    public static int GCD(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
