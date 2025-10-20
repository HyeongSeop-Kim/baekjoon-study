package baekjoon.math1;

import java.io.*;

public class Main_BOJ_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());

        /*
            N-> 홀수 N--/1++
            N-> 짝수 1++/N--
            1 2 4 7 11
            +1 +2 +3 +4
         */
        int N = 1;
        int sum = 0;

        while (X > sum + N) {
            sum += N;
            N++;
        }

        int numerator;
        int denominator;
        int position = X - sum;

        if (N % 2 == 0) {
            numerator = position;
            denominator = N - position + 1;
        } else {
            numerator = N - position + 1;
            denominator = position;
        }

        bw.write(numerator + "/" + denominator);
        bw.flush();
    }
}