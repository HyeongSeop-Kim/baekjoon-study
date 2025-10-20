package baekjoon.array;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ_10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] baskets = new int[N];

        for (int i = 0; i < N; i++) {
            baskets[i] = i + 1;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int target1 = Integer.parseInt(st.nextToken()) - 1;
            int target2 = Integer.parseInt(st.nextToken()) - 1;

            int temp = baskets[target1];
            baskets[target1] = baskets[target2];
            baskets[target2] = temp;
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