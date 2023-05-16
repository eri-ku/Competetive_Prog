import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) throws FileNotFoundException {
            Scanner sc = new Scanner(System.in);
          //Scanner sc = new Scanner(new File("1.in"));
            int count = Integer.parseInt(sc.nextLine());

            HashSet<String> two = new HashSet<>();
            two.add("A");
            two.add("B");
            two.add("C");
            two.add("a");
            two.add("b");
            two.add("c");
            HashSet<String> three = new HashSet<>();
            three.add("D");
            three.add("E");
            three.add("F");
            three.add("d");
            three.add("e");
            three.add("f");
            HashSet<String> four = new HashSet<>();
            four.add("G");
            four.add("H");
            four.add("I");
            four.add("g");
            four.add("h");
            four.add("i");
            HashSet<String> five = new HashSet<>();
            five.add("J");
            five.add("K");
            five.add("L");
            five.add("j");
            five.add("k");
            five.add("l");
            HashSet<String> six = new HashSet<>();
            six.add("M");
            six.add("N");
            six.add("O");
            six.add("m");
            six.add("n");
            six.add("o");
            HashSet<String> seven = new HashSet<>();
            seven.add("P");
            seven.add("Q");
            seven.add("R");
            seven.add("S");
            seven.add("p");
            seven.add("q");
            seven.add("r");
            seven.add("s");
            HashSet<String> eight = new HashSet<>();
            eight.add("T");
            eight.add("U");
            eight.add("V");
            eight.add("t");
            eight.add("u");
            eight.add("v");
            HashSet<String> nine = new HashSet<>();
            nine.add("W");
            nine.add("X");
            nine.add("Y");
            nine.add("Z");
            nine.add("w");
            nine.add("x");
            nine.add("y");
            nine.add("z");
            ArrayList<HashSet<String>> list = new ArrayList<>();
            list.add(two);
            list.add(three);
            list.add(four);
            list.add(five);
            list.add(six);
            list.add(seven);
            list.add(eight);
            list.add(nine);
            for (int i = 0; i < count; i++) {
                String pali = sc.nextLine();
                boolean contains = false;
                if(pali.length() == 1){
                    contains = true;
                }
                for (int j = 0; j < pali.length()/2; j++) {
                    String c = String.valueOf(pali.charAt(j));
                    String z = String.valueOf(pali.charAt((pali.length()-j)-1));

                    for(var hash : list){
                        if(hash.contains(c) && hash.contains(z)){
                            contains = true;
                            break;
                        }
                        contains = false;
                    }
                    if(!contains){
                        break;
                    }
                }

                System.out.println(contains ? "YES" : "NO");
            }
    }
}