package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 스위치 개수
        int[] switches = new int[N + 1]; // 1번부터 시작 (0번 인덱스 사용 안 함)

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int studentCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < studentCount; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken()); // 1:남, 2:여
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                // 남학생: 배수 위치 스위치 변경
                for (int j = num; j <= N; j += num) {
                    switches[j] = 1 - switches[j];
                }
            } else {
                // 여학생: 대칭 구간 스위치 변경
                switches[num] = 1 - switches[num]; // 중심 먼저 변경

                int left = num - 1;
                int right = num + 1;

                while (left >= 1 && right <= N && switches[left] == switches[right]) {
                    switches[left] = 1 - switches[left];
                    switches[right] = 1 - switches[right];
                    left--;
                    right++;
                }
            }
        }

        // 출력: 20개씩 끊어서 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(switches[i]);
            if (i % 20 == 0) {
                sb.append("\n");
            } else if (i != N) {
                sb.append(" ");
            }
        }

        System.out.println(sb);
        br.close();
    }
}