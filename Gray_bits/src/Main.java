import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(grayCodeCalculation(input[0], Integer.toBinaryString(input[1])));

        }
    }

    public static int grayCodeCalculation(int n, String k) {
//        ArrayList<String> codes= new ArrayList<>(Arrays.asList("0","1"));
//        for (int i = 2; i < Math.pow(2,n); i*=2) {
//
//            for (int j = i-1; j >=0; j--) {
//                codes.add(codes.get(j));
//            }
//            for(int j =0; j < i; ++j){
//                codes.set(j,"0" + codes.get(j));
//            }
//            for(int j =i; j < 2*i; ++j){
//                codes.set(j,"1" + codes.get(j));
//            }
//            if(codes.size() == k) break;
//        }
//        return Integer.parseInt(codes.get(k),2);
        int k_1 = Integer.parseInt(k,2);
        String k_2_bin = Integer.toBinaryString( k_1>>1);
        int k_2 = Integer.parseInt(k_2_bin,2);
        return k_1 ^ k_2;

    }




}

