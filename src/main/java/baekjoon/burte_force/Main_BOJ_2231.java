package baekjoon.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = Integer.MAX_VALUE;

        for (int i = 1; i < N; i++) {
            String num = i + "";
            int temp = i;
            for (int j = 0; j < num.length(); j++) {
                temp += num.charAt(j) - '0';
            }
            if (temp == N && i < result) {
                result = i;
            }
        }

        if (result == Integer.MAX_VALUE) {
            System.out.print(0);
            return;
        }

        System.out.print(result);
    }
}