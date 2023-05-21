import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc = new Scanner(new File("1.in"));
        Scanner sc = new Scanner(System.in);
        while(true){
            int columns = Integer.parseInt(sc.nextLine());
            if(columns == 0) break;
            String word = sc.nextLine();
            int rows = word.length() / columns;
            char[][] array = new char[rows][columns];
            int c = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    array[i][j] = word.charAt(c);
                    c++;
                }
                if(i % 2 ==1){
                    var arr = array[i];
                    for (int j = 0; j < arr.length/2; j++) {
                         char p = arr[j];
                         arr[j] = arr[arr.length-1-j];
                        arr[arr.length-1-j] = p;
                    }
                }

            }
            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    System.out.print(array[j][i]);
                }
            }
            System.out.println();

        }

    }
}