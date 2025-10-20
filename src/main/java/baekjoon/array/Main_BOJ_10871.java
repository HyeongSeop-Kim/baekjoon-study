package baekjoon.array;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main_BOJ_10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int X = Integer.parseInt(line[1]);

        String[] sequence = br.readLine().split(" ");

        List<String> res = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (X > Integer.parseInt(sequence[i])) {
                res.add(sequence[i]);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.join(" ", res));
        bw.flush();
    }
}