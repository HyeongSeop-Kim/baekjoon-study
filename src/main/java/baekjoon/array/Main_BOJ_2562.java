package baekjoon.array;

import java.io.*;

public class Main_BOJ_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int index = 0;

        for(int i = 0; i < 9; i++){
            int N = Integer.parseInt(br.readLine());
            if(N > max){
                max = N;
                index = i + 1;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(max + "\n" + index);
        bw.flush();
    }
}