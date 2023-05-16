import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new File("1.in"));
        int count = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= count; i++) {
            int num = Integer.parseInt(sc.nextLine());

            int quarter = 0;
            int dime = 0;
            int nickel = 0;
            int penny = 0;

            if(num / 25 > 0){
                quarter = num/25;
                num-= 25*quarter;
            }
            if(num / 10 > 0){
                dime = num/10;
                num-= 10*dime;
            }
            if(num / 5 > 0){
                nickel = num/5;
                num-= 5*nickel;
            }
            if(num / 1 > 0){
                penny = num/1;
                num-= 1*penny;
            }
            System.out.println(i + " " + quarter + " QUARTER(S), "
            + dime + " DIME(S), "+ nickel + " NICKEL(S), " + penny +" PENNY(S)");

        }
    }
}