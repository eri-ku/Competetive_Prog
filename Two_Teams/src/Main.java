import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc = new Scanner(new File("input.txt"));
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = Integer.parseInt(sc.nextLine());
            if (n == 0) return;
            String[] names = new String[n];
            for (int i = 0; i < n; i++) {
                names[i] = sc.nextLine();
            }
            Arrays.sort(names);
            String middleLeft = names[n / 2 - 1];
            String middle = names[n / 2];
            StringBuilder answer = new StringBuilder();
           int min = Math.min(middleLeft.length(), middle.length());

            for (int i = 0; i < min; i++) {
                if (middle.charAt(i) == middleLeft.charAt(i)) {
                    answer.append(middleLeft.charAt(i));
                } else {
                    if (i == middleLeft.length() - 1) {
                        answer.append(middleLeft.charAt(i));
                        break;
                    }
                    if ((char) (middleLeft.charAt(i) + 1) != middle.charAt(i) && answer.length() +1 != middleLeft.length()){
                        answer.append((char) (middleLeft.charAt(i) + 1));
                        break;
                    }
                    if ((char) (middleLeft.charAt(i) + 1) != middle.charAt(i) && answer.length() +1 == middleLeft.length()){
                        answer.append((middleLeft.charAt(i)));
                        break;
                    }
                    String s = answer.toString() + (char) (middleLeft.charAt(i) + 1);
                    if ((char) (middleLeft.charAt(i) + 1) == middle.charAt(i) && s.equals(middle)){
                        answer.append((middleLeft.charAt(i)));
                        if(middleLeft.charAt(i+1) == 'Z'){
                            answer.append('Z');
                            i++;
                        }
                        while (i != middleLeft.length()-1 && middleLeft.charAt(i+1) == 'Z') {
                                answer.append('Z');
                                i++;
                            }
                        if (answer.length() == middleLeft.length()) break;
                        if(answer.length() + 1 == middleLeft.length()){
                            i++;
                            answer.append( middleLeft.charAt(i));
                            break;
                        }
                        i = answer.length();

                        answer.append((char) (middleLeft.charAt(i) + 1));
                        break;
                    }
                    if ((char) (middleLeft.charAt(i) + 1) == middle.charAt(i) && (!(s.equals(middle)))){
                        answer.append((char) (middleLeft.charAt(i) + 1));
                        break;
                    }

                }

            }

            System.out.println(answer);
        }
    }
}