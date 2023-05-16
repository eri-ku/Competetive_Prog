import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new File("1.txt"));
        int T =  Integer.parseInt(sc.nextLine());
        int count = 0;
        while(count < T){
            int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer>[] graph = new  ArrayList[input[0]];
            boolean[] flags = new boolean[input[0]];
            for (int i = 0; i < input[0]; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < input[1]; i++) {
                int[] S = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                graph[S[0]].add(S[1]);
                graph[S[1]].add(S[0]);
            }
            dfs(0,graph,flags);
            var flag = true;
            for (var el: flags) {
                if(!el){
                    flag = false;
                    break;
                }
            }
            if(flag) System.out.println("reachable");
            else System.out.println("not reachable");
            count++;


        }
    }

    private static void dfs(int i, ArrayList<Integer>[]graph, boolean[] flags) {
        flags[i] = true;
        for (Integer integer : graph[i]) {
            if(!flags[integer]) dfs(integer,graph,flags);
        }

    }
}