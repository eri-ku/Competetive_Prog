import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger limit = new BigInteger("10").pow(60);

        BigInteger line = BigInteger.TWO;
        boolean flag_continue = true;
        System.out.println(BigInteger.ONE);
        while(flag_continue){
            BigInteger k = BigInteger.ONE;
            for (BigInteger i = BigInteger.ONE; i.compareTo(line) <= 0; i = i.add(BigInteger.ONE)) {
                System.out.print(k + " ");
                k = k.multiply(line.subtract(i)).divide(i);
                if(k.compareTo(limit) > -1) flag_continue = false;
            }
            System.out.println();
            line = line.add(BigInteger.ONE);
        }
    }
}