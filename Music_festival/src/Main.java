import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       // BufferedReader br = new BufferedReader(new FileReader("1.in"));
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if(input[0]==0 && input[1]==0) break;
            HashMap<String,ArrayList<String>>setSlots = new HashMap<>();
            ArrayList<String> listSlot = new ArrayList<>();
            for (int i = 0; i < input[0]; i++) {
                String slot = br.readLine();
                setSlots.put(slot,new ArrayList<>());
                listSlot.add(slot);
            }

            for (int i = 0, j=0; i < input[1]; i++) {
                String[] pom = br.readLine().split(" ");
                var artists = setSlots.getOrDefault(pom[1], null);
                if(artists == null){
                    artists = new ArrayList<>();
                    listSlot.add(pom[1]);
                }
                artists.add(pom[0]);
                setSlots.put(pom[1],artists);
            }

            for (var slot : listSlot){
                for(var artists : setSlots.get(slot)){
                    System.out.println(artists);
                }
            }
        }

    }
}