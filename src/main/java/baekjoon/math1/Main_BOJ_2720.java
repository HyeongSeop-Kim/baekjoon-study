package baekjoon.math1;

import java.io.*;

public class Main_BOJ_2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCount = Integer.parseInt(br.readLine());

        for(int i = 0; i < caseCount; i++) {
            int temp = Integer.parseInt(br.readLine());
            int quarter = temp / 25;
            temp %= 25;
            int dime = temp / 10;
            temp %= 10;
            int nickel = temp / 5;
            temp %= 5;
            int penny = temp;
            bw.write(String.format("%d %d %d %d\n", quarter, dime, nickel, penny));
        }

        bw.flush();
    }
}