package baekjoon.array;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sequence);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sequence[0] + " " + sequence[sequence.length-1]);
        bw.flush();
    }
}