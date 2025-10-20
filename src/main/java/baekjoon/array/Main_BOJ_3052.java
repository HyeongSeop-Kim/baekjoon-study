package baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte[] remainders = new byte[42];
        byte res = 0;

        for (byte i = 0; i < 10; i++) {
            int remainder = Integer.parseInt(br.readLine()) % 42;
            if (remainders[remainder] == 0) {
                remainders[remainder] = 1;
                res++;
            }
        }

        System.out.println(res);
    }
}