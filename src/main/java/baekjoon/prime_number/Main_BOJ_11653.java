package baekjoon.prime_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (N % 2 == 0) {
            sb.append(2).append("\n");
            N = N / 2;
        }

        for (int i = 3; i * i <= N; i += 2) {
            while (N % i == 0) {
                sb.append(i).append("\n");
                N = N / i;
            }
        }

        if (N > 1) {
            sb.append(N).append("\n");
        }

        System.out.println(sb);
    }
}