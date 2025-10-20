package baekjoon.math1;

import java.io.*;
import java.util.ArrayList;

public class Main_BOJ_11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int N = Integer.parseInt(s.split(" ")[0]);
        int base = Integer.parseInt(s.split(" ")[1]);
        ArrayList<Character> result = new ArrayList<>();

        int temp = N;
        while (temp > 0) {
            int digit = temp % base;
            result.add(convert(digit));
            temp /= base;
        }

        for(int i = 0; i < result.size(); i++) {
            bw.write(result.get(result.size() - 1 - i));
        }
        bw.flush();
    }

    private static char convert(int digit) {
        if (digit < 10) {
            return (char) (digit + '0');
        }
        return (char) (digit - 10 + 'A');
    }
}