import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
//        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
//        System.setOut(out);
        int T = sc.nextInt();
        sc.nextLine();


        for (int i = 1; i <= T; ++i) {
            String[] splits = sc.nextLine().split("[+^()]");//1,2,4
            int k = Integer.parseInt(splits[4]);
            StringBuilder result = new StringBuilder();
            for (int j = 0; j <= k; ++j) {

                BigInteger coefficient = calcCoefficient(k,j);
                String s = craeteString(splits[1], splits[2], k - j, j);
                if(coefficient.intValue() == 1) result.append(s);
                else result.append(coefficient).append("*").append(s);
                if (j < k) result.append('+');
            }
            System.out.println("Case " + i + ": " + result);
        }


    }

    private static BigInteger calcCoefficient(int n, int k) {

        BigInteger coefficient = BigInteger.valueOf(1);
        for (int i = 0; i < k; i++) {
            coefficient = coefficient.multiply(BigInteger.valueOf(n-i)).divide(BigInteger.valueOf(i+1));
        }
        return coefficient;
    }



    private static String craeteString(String first, String second, int expA, int expB) {
        StringBuilder stringBuilder = new StringBuilder();
        if (expA > 0) {
            stringBuilder.append(first);

            if (expA > 1) {
                stringBuilder.append('^');
                stringBuilder.append(expA);
            }
        }
        if (expB > 0) {
            if (stringBuilder.length() > 0) stringBuilder.append('*');
            stringBuilder.append(second);
            if (expB > 1) {
                stringBuilder.append('^');
                stringBuilder.append(expB);
            }
        }
        return stringBuilder.toString();
    }
}