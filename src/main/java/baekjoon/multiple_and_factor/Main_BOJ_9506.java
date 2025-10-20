package baekjoon.multiple_and_factor;

import java.io.*;

public class Main_BOJ_9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == -1) break;

            int temp = 0;
            StringBuilder sb = new StringBuilder();
            sb.append(n).append(" = ");
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    if (temp + i > n) {
                        temp += i;
                        break;
                    }
                    if (temp != 0) sb.append(" + ");
                    temp += i;
                    sb.append(i);
                }
            }
            if (temp != n) {
                bw.write(n + " is NOT perfect.\n");
            } else {
                bw.write(sb.append("\n").toString());
            }
        }
        bw.flush();
    }
}