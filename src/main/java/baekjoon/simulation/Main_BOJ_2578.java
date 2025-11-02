package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2578 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                checkBoard(board, Integer.parseInt(st.nextToken()));
                int bingoCount = getBingoCount(board);

                result++;

                if (bingoCount >= 3){
                    System.out.println(result);
                    return;
                }
            }
        }

        br.close();
    }

    public static void checkBoard(int[][] board, int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == num) {
                    board[i][j] = 0;
                    return;
                }
            }
        }
    }

    public static int getBingoCount(int[][] board) {
        int count = 0;

        for (int i = 0; i < 5; i++) {
            if (board[i][0] == 0 && board[i][1] == 0 && board[i][2] == 0 && board[i][3] == 0 && board[i][4] == 0) {
                count++;
            }
            if (board[0][i] == 0 && board[1][i] == 0 && board[2][i] == 0 && board[3][i] == 0 && board[4][i] == 0) {
                count++;
            }
        }

        if (board[0][0] == 0 && board[1][1] == 0 && board[2][2] == 0 && board[3][3] == 0 && board[4][4] == 0) {
            count++;
        }

        if (board[0][4] == 0 && board[1][3] == 0 && board[2][2] == 0 && board[3][1] == 0 && board[4][0] == 0) {
            count++;
        }

        return count;
    }
}