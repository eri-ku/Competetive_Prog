import java.util.*;
;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            int[] numbers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            var divisors = new ArrayList<Integer>();
            int v = 0;
            int j =1;

            while (v != numbers.length) {
                while(j != numbers.length) {
                    divisors.add(GCD(numbers[v], numbers[j]));
                    ++j;
                }
                ++v;
                j = v +1;
            }
            System.out.println(Collections.max(divisors));

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