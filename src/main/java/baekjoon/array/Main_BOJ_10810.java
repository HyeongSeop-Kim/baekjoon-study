package baekjoon.array;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ_10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] baskets = new int[N];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int num = Integer.parseInt(st.nextToken());
            for(int j = start; j <= end; j++){
                baskets[j] = num;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            sb.append(baskets[i]);
            if (i < N - 1) {
                sb.append(" ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}