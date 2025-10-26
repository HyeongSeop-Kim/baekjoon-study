package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_BOJ_2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            queue.add(i + 1);
        }

        int count = 1;
        while (!queue.isEmpty()) {
            if (count % 2 == 0 && queue.size() != 1) {
                queue.add(queue.poll());
            } else {
                System.out.print(queue.poll() + " ");
            }
            count++;
        }
    }
}