import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String[] colors = new String[3];
            for (int i = 0; i < colors.length; i++) {
                colors[i]= sc.next();
            }
            BigInteger bigInteger = sc.nextBigInteger();
            BigInteger n = bigInteger.mod(BigInteger.valueOf(6));

                for (int i = 0; i < n.intValue(); i++) {

                    if (i % 2 == 0) {
                        String temp = colors[1];
                        colors[1] = colors[0];
                        colors[0] = temp;
                    } else {
                        String temp = colors[1];
                        colors[1] = colors[2];
                        colors[2] = temp;
                    }
                }
                    System.out.println(colors[0] + " " + colors[1] + " " + colors[2]);


        }

        sc.close();
    }
}
