package baekjoon.array;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ_10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int v = Integer.parseInt(br.readLine());

        int res = 0;

        for (int i = 0; i < N; i++) {
            if (numbers[i] == v) {
                res++;
            }
        }

        bw.write(res + "");
        bw.flush();
    }
}