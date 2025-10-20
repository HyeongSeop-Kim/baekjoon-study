package baekjoon.prime_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        int temp = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                temp += c - 'A' + 27;
            } else {
                temp += c - 'a' + 1;
            }
        }

        String res = isPrime(temp) ? "It is a prime word." : "It is not a prime word.";
        System.out.println(res);
    }

    public static boolean isPrime(int num) {
        if (num == 1 || num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }

        return true;
    }
}