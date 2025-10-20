package baekjoon.multiple_and_factor;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ_5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0) break;

            if (b % a == 0) {
                bw.write("factor\n");
                continue;
            }

            if (a % b == 0) {
                bw.write("multiple\n");
                continue;
            }

            bw.write("neither\n");
        }

        bw.flush();
    }
}