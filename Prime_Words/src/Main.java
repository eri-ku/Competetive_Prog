import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            int sum =0;
            String word = sc.nextLine();
            for(int i=0;i<word.length();i++) {
                if((int)word.charAt(i) -95 >= -1 ) {
                    sum += (int) word.charAt(i) - 96;
                } else {
                    sum += (int) word.charAt(i) - 38;
                }
            }
            String output = "It is a prime word.";
            if(sum == 1 || sum ==4) {
                output = "It is not a prime word.";
            }
           for(int i=2;i < Math.ceil(Math.sqrt(sum));i++) {
               if(sum % i == 0) {
                   output = "It is not a prime word.";
                   break;
               }
           }

            System.out.println(output);

        }
    }
}