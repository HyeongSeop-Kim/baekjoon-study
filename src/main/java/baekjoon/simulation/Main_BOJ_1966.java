package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서 개수
            int M = Integer.parseInt(st.nextToken()); // 궁금한 문서 위치

            Queue<Document> queue = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Document(i, priority));
            }

            int count = 0;

            while (!queue.isEmpty()) {
                Document current = queue.poll();
                boolean hasHigher = false;

                // 현재 문서보다 중요도가 높은 문서가 있는지 확인
                for (Document doc : queue) {
                    if (doc.priority > current.priority) {
                        hasHigher = true;
                        break;
                    }
                }

                if (hasHigher) {
                    // 중요도가 더 높은 문서가 있으면 맨 뒤로
                    queue.offer(current);
                } else {
                    // 인쇄
                    count++;

                    // 찾는 문서면 종료
                    if (current.index == M) {
                        sb.append(count).append("\n");
                        break;
                    }
                }
            }
        }

        System.out.print(sb);
        br.close();
    }

    static class Document {
        int index;      // 초기 위치
        int priority;   // 중요도

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}