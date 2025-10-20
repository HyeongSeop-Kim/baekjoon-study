package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ_1051 {
    public static void main(String[] args) throws IOException {
        // return 가장 큰 정사각형

        // 존재할 수 있는 가장 큰 정사각형부터 찾아서 존재하면 바로 return
        // 없는 경우 다음 크기의 정사각형 탐색해서 반환

        // 정사각형을 찾는 방법(?)
        // 가장 큰 정사각형: N, M 중 작은 값을 한 변으로 하는 정사각형
        // 00 01 02 ... 0M
        // 10 ...
        // N0 ...       NM

        // 1. 입력값을 2차원 배열에 저장
        // 2. 작은 값을 N이라고 할 때 [0][0], [N][0], [0][N], [N][N] 비교
        // -> 비교 시작점을 기준으로 (x,y) 좌표함수로 표현하면 (x,y), (x+N,y), (x,y+N), (x+N,y+N)
        // 3. y값을 1씩 증가 시켜가면서 y+N 값이 M에 도달할 때까지 비교
        // 4. 반환할 값이 없을 경우 N-1을기준으로 1~3번 진행

        // 반환할 때 크기 계산해서 반환
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int[][] RECTANGULAR = new int[height][width];
        int MAX_SIDE_LENGTH = Math.min(width, height);

        for (int i = 0; i < height; i++) {
            String row = br.readLine();
            for (int j = 0; j < width; j++) {
                RECTANGULAR[i][j] = row.charAt(j) - '0';
            }
        }

        int area = getArea(MAX_SIDE_LENGTH, width, height, RECTANGULAR);
        System.out.println(area);
    }

    private static int getArea(int startSideLength, int width, int height, int[][] rectangular) {
        int sideLength = startSideLength;

        while (sideLength > 1) {
            int addedIdx = sideLength - 1;
            for (int i = 0; i < height; i++) {
                if (i + sideLength > height) {
                    break;
                }
                for (int j = 0; j < width; j++) {
                    if (j + sideLength > width) {
                        break;
                    }
                    int vertex1 = rectangular[i][j];
                    int vertex2 = rectangular[i + addedIdx][j];
                    int vertex3 = rectangular[i][j + addedIdx];
                    int vertex4 = rectangular[i + addedIdx][j + addedIdx];

                    if (vertex1 == vertex2 && vertex2 == vertex3 && vertex3 == vertex4) {
                        return sideLength*sideLength;
                    }
                }
            }
            sideLength--;
        }
        return 1;
    }
}