package baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] students = new boolean[30];

        for (int i = 0; i < 28; i++) {
            int index = Integer.parseInt(br.readLine()) - 1;
            students[index] = true;
        }

        for (int i = 0; i < 30; i++) {
            if (!students[i]) {
                System.out.println(i + 1);
            }
        }
    }
}