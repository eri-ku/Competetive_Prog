
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int SIZE = 8;
    static int[][] board = new int[SIZE][SIZE];
    static int[] positions = new int[SIZE];
    static boolean activated;
    static int sol_n;
    static int[] input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n_datasets = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n_datasets; ++i) {
            if (i > 0) System.out.println();
            sc.nextLine();
            input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int[] ints : board) Arrays.fill(ints, 0);
            Arrays.fill(positions, 0);
            activated = false;
            board[(input[0] - 1)][(input[1] - 1)] = 1;
            positions[input[1] - 1] = input[0];
            sol_n = 1;
            nQueens(0, input[0] - 1, 0);
        }
        sc.close();
    }

    public static void nQueens(int col, int row, int placed) {
        if (col >= board.length || (col == 7 && input[1] == 8)) {
            print();
            return;
        }
        for (int i = 0; i < board.length; ++i) {
            if (col == input[1] - 1) {
                ++col;
            }
            if (placed == input[1] - 1) {
                ++placed;
            }
            if (isValid(col, i)) {
                board[i][col] = 1;
                positions[placed] = i + 1;
                nQueens(col + 1, i, placed + 1);
                board[i][col] = 0;
            }
        }
    }

    private static boolean isValid(int col, int row) {

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




        return col != input[1] - 1 && row != input[0] - 1;
    }

    private static void print() {
        if (!activated) {
            System.out.println("SOLN       COLUMN");
            System.out.println(" #      1 2 3 4 5 6 7 8");
            System.out.println();
            activated = true;
        }
        System.out.printf("%2s      ", +sol_n);
        for (int i = 0; i < positions.length; ++i) {

            if (i == positions.length - 1) {
                System.out.println(positions[i]);
                break;
            }
            System.out.print((positions[i]) + " ");
        }
        ++sol_n;
    }
}