package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_26042 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new ArrayDeque<>();

        int MAX = 0;
        int MIN = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int studentNum = Integer.parseInt(st.nextToken());
                queue.offer(studentNum);
                if ((queue.size() == MAX && studentNum < MIN) || queue.size() > MAX) {
                    MAX = queue.size();
                    MIN = studentNum;
                }
            } else {
                queue.poll();
            }
        }

        System.out.println(MAX + " " + MIN);
    }
}