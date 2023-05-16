import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        Scanner sc = new Scanner(System.in);
        int n = -1 ;
        while(n != 0){
            HashSet<Integer> set = new HashSet<Integer>();
            n = Integer.parseInt(sc.nextLine());

            if (n == 0) continue;
            for (int i = 0; i < n; i++) {
                int[] numbers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int number : numbers) {
                    set.add(number);
                }
            }

            String answer = set.size() == 49 ? "Yes" : "No";
            System.out.println(answer);

        }






    }



}