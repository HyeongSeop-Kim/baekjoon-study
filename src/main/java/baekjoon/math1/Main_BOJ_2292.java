package baekjoon.math1;

import java.io.*;

public class Main_BOJ_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int floor = 0;
        int temp = 1;

        while (n > temp || floor == 0) {
            temp += 6 * floor;
            floor++;
        }

        bw.write(floor + "");
        bw.flush();
    }
}