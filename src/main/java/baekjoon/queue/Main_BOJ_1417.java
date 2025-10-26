package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        Integer type1 = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        int count = 0;

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N - 1; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        while (true) {
            Integer typeN = queue.poll();
            if (typeN < type1) break;
            queue.offer(typeN - 1);
            type1++;
            count++;
        }

        System.out.println(count);
    }
}