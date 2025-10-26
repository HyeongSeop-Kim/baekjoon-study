package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_BOJ_12605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                stack.push(st.nextToken());
            }

            StringBuilder builder = new StringBuilder();
            builder.append("Case #").append(i + 1).append(": ");

            while (!stack.isEmpty()) {
                builder.append(stack.pop()).append(" ");
            }
            System.out.println(builder);
        }
    }
}