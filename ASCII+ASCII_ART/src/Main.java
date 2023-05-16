import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static ArrayList<String> nums = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String one = "....x....x....x....x....x....x....x";
        String two = "xxxxx....x....xxxxxxx....x....xxxxx";
        String three = "xxxxx....x....xxxxxx....x....xxxxxx";
        String four = "x...xx...xx...xxxxxx....x....x....x";
        String five = "xxxxxx....x....xxxxx....x....xxxxxx";
        String six = "xxxxxx....x....xxxxxx...xx...xxxxxx";
        String seven = "xxxxx....x....x....x....x....x....x";
        String eight = "xxxxxx...xx...xxxxxxx...xx...xxxxxx";
        String nine = "xxxxxx...xx...xxxxxx....x....xxxxxx";
        String zero = "xxxxxx...xx...xx...xx...xx...xxxxxx";
        String plus = ".......x....x..xxxxx..x....x.......";

//        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
//        System.setOut(out);




        nums.add(zero);
        nums.add(one);
        nums.add(two);
        nums.add(three);
        nums.add(four);
        nums.add(five);
        nums.add(six);
        nums.add(seven);
        nums.add(eight);
        nums.add(nine);
        nums.add(plus);


        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            list.add(sc.nextLine());
        }
        StringBuilder s = new StringBuilder();
        int start = 0;
        int end = 5;
        StringBuilder answer = new StringBuilder();


        while (end <= list.get(0).length()) {
            for (String element : list) {
                s.append(element, start, end);
            }


            for (int i = 0; i < nums.size(); i++) {
                if (s.toString().equals(nums.get(i))) {
                    if (i == 10) {
                        answer.append('+');
                        break;
                    }
                    answer.append(i);
                    break;
                }
            }


            start += 6;
            end += 6;
            s.setLength(0);
        }

        String[] arr = answer.toString().split("\\+");

        int result = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
        String resultString = String.valueOf(result);

            print(resultString);


    }

    public static void print(String s) {

        int start = 0;
        int end = 5;

        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < s.length(); i++) {
                System.out.print(nums.get(Integer.parseInt(String.valueOf(s.charAt(i)))).substring(start, end));
                if(i != s.length() -1){
                    System.out.print('.');
                }
            }
            System.out.println();
            start += 5;
            end += 5;
        }


    }

}


