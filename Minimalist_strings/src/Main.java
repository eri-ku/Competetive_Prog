import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Character,Integer> map = new HashMap<>();
        HashSet<Character> set1 = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            set1.add(s.charAt(i));
        }
        for (var el : set1) {
            map.put(el,0);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                int count = map.get(s.charAt(i));
                count++;
                map.put(s.charAt(i),count);
            }
        }

        int[] array = new int[map.size()];
        int q = 0;
        for (Integer value : map.values()) {
            array[q] = value;
            q++;
        }
        Arrays.sort(array);
int f = 0;
        int acount = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if(f == 2) break;
            acount += array[i];
            f++;

        }


        System.out.println(s.length() - acount) ;







    }
}