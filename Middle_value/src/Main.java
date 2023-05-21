import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc = new Scanner(new File("1.in"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sc.nextInt();
            int count = sc.nextInt();
            int[] pom = new int[count];
            for (int j = 0; j < count; j++) {
                pom[j] = sc.nextInt();
            }
            list.add(pom);
        }
        int q = 1;
        for (int i = 0; i < list.size(); i++) {
            int size = ((list.get(i).length / 2) + 1);
            int[] pomo = list.get(i);
            System.out.println(q + " " + size);
            ArrayList<Integer> pomList = new ArrayList<>();
            pomList.add(pomo[0]);
            System.out.print(pomo[0]);

            int o = 0;

            for (int j = 1; j < pomo.length; j++) {
                pomList.add(pomo[j]);
                pomList.add(pomo[++j]);

                ArrayList<Integer> writeList;
                writeList = pomList;
                Collections.sort(writeList);
                if (o % 9 == 0 && o != 0){
                    System.out.println();

                    System.out.print(writeList.get(writeList.size() / 2));
                }
                else
                    System.out.print(" " + writeList.get(writeList.size() / 2));

                o++;

            }
            System.out.println();


            q++;
        }
    }
}