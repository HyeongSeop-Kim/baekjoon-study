package baekjoon.math1;

import java.io.*;

public class Main_BOJ_2903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int temp = 2;
        for (int i = 0; i < n; i++) {
            temp += temp - 1;
        }
        bw.write(temp * temp + "");

        bw.flush();
    }
}