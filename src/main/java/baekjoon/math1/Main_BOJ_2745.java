package baekjoon.math1;

import java.io.*;

public class Main_BOJ_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        String N = s.split(" ")[0];
        int base = Integer.parseInt(s.split(" ")[1]);
        int result = 0;

        for (int i = 0; i < N.length(); i++) {
            char c = s.charAt(N.length() - 1 - i);
            int temp = convert(c);
            for (int j = 0; j < i; j++) {
                temp = temp * base;
            }
            result += temp;
        }

        bw.write(result + "");
        bw.flush();
    }

    private static int convert(char digit) {
        if (digit >= '0' && digit <= '9') {
            return digit - '0';
        }
        return digit - 'A' + 10;
    }
}