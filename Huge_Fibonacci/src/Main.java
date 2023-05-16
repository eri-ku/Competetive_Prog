import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T =  sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n1 = 0;
            int n2 = 0;
            int n = 1;
            int N = sc.nextInt();
            if(N == 0) n = 0;
            for(int j=1;j <N;j++) {

                n2 = n1;
                n1 = n;

                n = (n1 + n2) % 1000000;
            }

            System.out.printf("%06d\n",n);



        }
    }
}