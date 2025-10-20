package baekjoon.array;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        int M = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(st.nextToken());
            scores[i] = score;
            M = Math.max(M, score);
        }

        float total = 0;

        for (int i = 0; i < N; i++) {
            total += (float) scores[i] / M * 100;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(total / N + "");
        bw.flush();
    }
}