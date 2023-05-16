
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int SIZE = 8;
    static int[][] board = new int[SIZE][SIZE];
    static int[] input;

    static int steps;

    static int[] positions = new int[8];

    public static void main(String[] args) throws FileNotFoundException {
       Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new File("1.in"));
        int case_n = 1;
        while (sc.hasNextLine()) {
            steps = Integer.MAX_VALUE;
            input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nQueens( 0, 0);

            System.out.println("Case "+case_n +": " + steps);
            case_n++;
        }

        sc.close();
    }

    public static void nQueens( int col, int placed) {

        if (col >= board.length) {
            findMin();
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isValid(i,col)){
                board[i][col] = 1;
                positions[placed] = i +1;
                nQueens(col+1,placed+1);
                board[i][col] = 0;
            }
        }
    }

    private static boolean isValid(int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) return false;
        }
        for (int i = row, j = col; j < board.length && i >= 0; i--, j++) {
            if (board[i][j] == 1) return false;
        }
        for (int i = row, j = col; j < board.length && i < board.length; i++, j++) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    private static void findMin() {
        int pom = 0;
        for (int i=0; i < input.length;i++){
            if(input[i] != positions[i]) pom++;
        }
        steps = Math.min(pom,steps);
    }

}