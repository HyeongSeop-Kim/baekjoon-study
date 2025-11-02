package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_24267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        // 수행 횟수: nC3 = n * (n-1) * (n-2) / 6
        long count = n * (n - 1) * (n - 2) / 6;

        System.out.println(count);
        System.out.println(3);

        br.close();
    }
}