package baekjoon.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int[] heights = new int[9];

        for (int i = 0; i < 9; i++) {
            int height = Integer.parseInt(br.readLine());
            heights[i] = height;
            sum += height;
        }

        for (int i = 0; i < 8; i++) {
            int temp = sum - heights[i];
            boolean isFind = false;
            for (int j = i + 1; j < 9; j++) {
                if (temp - heights[j] == 100) {
                    heights[i] = 0;
                    heights[j] = 0;
                    isFind = true;
                    break;
                }
            }
            if (isFind) break;
        }

        Arrays.sort(heights);

        for (int i = 2; i < 9; i++) {
            if (heights[i] != 0) {
                System.out.println(heights[i]);
            }
        }
    }
}