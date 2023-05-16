
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    final static ArrayList<Integer> S = new ArrayList<>();
    final static int NUMS_COUNT = 6;
    final static int STOP = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            var line = sc.nextLine().split(" ");
            int k = Integer.parseInt(line[0]);
            S.clear();
            if (k == STOP) break;
            for (int i = 1; i < line.length; ++i) {
                S.add(Integer.parseInt(line[i]));
            }
            combine(new ArrayList<>(), 0);
            System.out.println();

        }
    }

    public static void combine(ArrayList<Integer> P, int index) {
        if (P.size() == NUMS_COUNT) {
            print(P);
            return;
        }
        for (int i = index; i < S.size(); ++i) {
            P.add(S.get(i));
            combine(P, ++index);
            P.remove(P.size() - 1);
        }

    }

    public static void print(ArrayList<Integer> P) {
        for (int i = 0; i < P.size(); ++i) {
            if (i == P.size() - 1) {
                System.out.println(P.get((i)));
                break;
            }
            System.out.print(P.get(i) + " ");
        }
    }


}

