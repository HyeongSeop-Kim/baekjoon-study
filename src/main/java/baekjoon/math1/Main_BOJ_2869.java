package baekjoon.math1;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        /*
        A + (A - B)(N - 1) >= V
        N >= (V - A) / (A - B) + 1
         */
        double A = Double.parseDouble(st.nextToken());
        double B = Double.parseDouble(st.nextToken());
        double V = Double.parseDouble(st.nextToken());

        int result = (int) Math.ceil((V - A) / (A - B) + 1);

        bw.write(result + "");
        bw.flush();
    }
}