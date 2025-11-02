package baekjoon.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] cards = new int[N];

        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 0; i < N - 2; i++) {
            int a =  cards[i];
            for (int j = i + 1; j < N - 1; j++) {
                int b = cards[j];
                for (int k = j + 1; k < N; k++) {
                    int sum = a + b + cards[k];
                    if (sum == M) {
                        System.out.print(sum);
                        return;
                    }
                    if (sum > result && sum < M) {
                        result = sum;
                    }
                }
            }
        }
        System.out.print(result);
    }
}