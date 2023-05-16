import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int ROWS = 10;
    static final int COLUMNS = 10;
    static final int POSSIBLE_MOVES = 4;


    static final char EMPTY_SQUARE = '#';
    static final char WHITE_PIECE = 'W';
    static final char BLACK_PIECE = 'B';

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < T; i++) {
            sc.nextLine();
            String[] lines = new String[ROWS];
            char[][] board = new char[ROWS][COLUMNS];
            for (int j = 0; j < ROWS; j++) {
                lines[j] = sc.nextLine();
            }
            for (int j = 0; j < ROWS; ++j) {
                for (int k = 0; k < COLUMNS; ++k) {
                    board[j][k] = lines[j].charAt(k);
                }
            }
            int max = 0;
            for (int j = 0; j < ROWS; ++j) {
                for (int k = 0; k < COLUMNS; k++) {
                    if (board[j][k] == 'W') max = Math.max(capture(j, k, board, max),max);
                }
            }

            System.out.println(max);
        }

    }

    private static int capture(int j, int k, char[][] board, int cap) {


        var dirJ = new int[POSSIBLE_MOVES];
        var dirK = new int[POSSIBLE_MOVES];
        dirJ[0] = -1;
        dirJ[1] = -1;
        dirJ[2] = 1;
        dirJ[3] = 1;
        dirK[0] = -1;
        dirK[1] = 1;
        dirK[2] = -1;
        dirK[3] = 1;
        int count = 0;

        boolean hasCaptured = false;
        for (int i = 0; i < POSSIBLE_MOVES; ++i) {


            int jumpJ = dirJ[i] * 2 + j;
            int jumpK = dirK[i] * 2 + k;
            int enemyJ = dirJ[i] + j;
            int enemyK = dirK[i] + k;

            if (isValid(jumpJ, jumpK, board) && board[enemyJ][enemyK] == 'B') {
                board[j][k] = EMPTY_SQUARE;
                board[jumpJ][jumpK] = WHITE_PIECE;
                board[enemyJ][enemyK] = EMPTY_SQUARE;

                int subCount = capture(jumpJ, jumpK, board, cap + 1);

                board[j][k] = WHITE_PIECE;
                board[enemyJ][enemyK] = BLACK_PIECE;
                board[jumpJ][jumpK] = EMPTY_SQUARE;
                count = Math.max(count, subCount);
                hasCaptured = true;
            }

        }
        if (!hasCaptured) {


            return count;
        } else {
            return count + 1;
        }
    }

    private static boolean isValid(int jumpJ, int jumpK, char[][] board) {
        return jumpJ >= 0 && jumpK >= 0 && jumpJ < ROWS && jumpK < COLUMNS && board[jumpJ][jumpK] == '#';
    }


}