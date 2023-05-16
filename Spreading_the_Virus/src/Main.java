import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new File("1.in"));

        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int P = input[0];
        int F = input[1];

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>(P);

        for (int i = 0; i < F; i++) {
            int[] S = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            add(S[0], S[1], graph);
            add(S[1], S[0], graph);
        }

        int T = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < T; i++) {
            int person = Integer.parseInt(sc.nextLine());
            int maxInfected = 0;
            int maxDay = 0;
            boolean[] flags = new boolean[P];
            Queue<Integer> newInfected = new ArrayDeque<>();
            newInfected.add(person);
            int day = 1;
            int currentInfected;

            if (!graph.containsKey(person)) {
                System.out.println(0);
                continue;
            }

            while (!newInfected.isEmpty()) {
                currentInfected = 0;
                Queue<Integer> currList = new ArrayDeque<>(newInfected);
                newInfected.clear();
                for (Integer el : currList) {
                    for (Integer adj : graph.get(el)) {
                        if (!flags[adj]) {
                            currentInfected++;
                            newInfected.add(adj);
                            flags[adj] = true;
                        }
                    }
                }
                if (currentInfected > maxInfected) {
                    maxDay = day;
                }
                maxInfected = Math.max(maxInfected,currentInfected);
                day++;
            }
            System.out.println(maxInfected + " " + maxDay);
        }

    }

    private static void add(int a, int b, HashMap<Integer, ArrayList<Integer>> graph) {
        ArrayList<Integer> list = graph.getOrDefault(a, new ArrayList<>());
        list.add(b);
        graph.put(a, list);
    }
}

