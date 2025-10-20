package baekjoon.two_demensional_array;

import java.io.*;

public class Main_BOJ_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = new String[5];
        int maxLength = 0;

        for (int i = 0; i < 5; i++) {
            words[i] = br.readLine();
            maxLength = Math.max(words[i].length(), maxLength);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < 5; j++) {
                if (words[j].length() > i) {
                    bw.write(words[j].charAt(i));
                }
            }
        }
        bw.flush();
    }
}