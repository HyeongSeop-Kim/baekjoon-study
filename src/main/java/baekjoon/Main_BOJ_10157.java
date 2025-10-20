package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ_10157 {

    private static final String CANNOT_ASSIGNED = "0";
    private static int seatCount = 0;
    private static int waitingNumber = 0;
    private static int maxX = 0;
    private static int maxY = 0;
    private static boolean[][] seatAssignment;

    public static void main(String[] args) throws IOException {
        /*
            2차원 boolean 배열 사용 boolean[C][R]
            좌표값 (x,y) x값을 증감시키는 함수, y값을 증감시키는 함수 총 4개 사용

            좌표 값을 변경할 때마다 좌석 수 카운팅할 변수(seatCount) 필요.
            각 함수는 시작 좌표값을 인자로 받고, seatCount == K인 경우 해당 좌표 값을 반환(?)함.

            아래 사이클을 반복하는 순환 함수

            1. y값을 증가
                1-1. 현재 좌표값을 true로 변환
                1-2. 값을 증가 시키기 전 증가 시킨 좌표값이 배열범위를 벗어나거나 true인지 확인
                1-3. false면 다음 좌표값으로 1-1부터 반복
                1-4. 배열범위를 벗어나거나 true면 현재 좌표값에서 x값을 증가 시킨 좌표값이 배열범위를 벗어나거나 true인지 확인
                 1-4-1. false면 다음 좌표 값으로 2번 함수 호출
                 1-4-2. 좌표값이 배열범위를 벗어나거나 true면 0 반환
            2. x값을 증가
                2-1. 현재 좌표값을 true로 변환
                2-2. 값을 증가 시키기 전 증가 시킨 좌표값이 배열범위를 벗어나거나 true인지 확인
                2-3. false면 다음 좌표값으로 1-1부터 반복
                2-4. true면 현재 좌표값에서 y값을 감소 시킨 좌표값이 배열범위를 벗어나거나 true인지 확인
                 2-4-1. false면 다음 좌표 값으로 3번 함수 호출
                 2-4-2. 좌표값이 배열범위를 벗어나거나 true면 0 반환
            3. y값을 감소
                3-1. 현재 좌표값을 true로 변환
                3-2. 값을 증가 시키기 전 증가 시킨 좌표값이 배열범위를 벗어나거나 true인지 확인
                3-3. false면 다음 좌표값으로 1-1부터 반복
                3-4. true면 현재 좌표값에서 x값을 감소 시킨 좌표값이 배열범위를 벗어나거나 true인지 확인
                 3-4-1. false면 다음 좌표 값으로 4번 함수 호출
                 3-4-2. 좌표값이 배열범위를 벗어나거나 true면 0 반환
            4. x값을 감소
                4-1. 현재 좌표값을 true로 변환
                4-2. 값을 증가 시키기 전 증가 시킨 좌표값이 배열범위를 벗어나거나 true인지 확인
                4-3. false면 다음 좌표값으로 1-1부터 반복
                4-4. true면 현재 좌표값에서 y값을 증가 시킨 좌표값이 배열범위를 벗어나거나 true인지 확인
                 4-4-1. false면 다음 좌표 값으로 순환 함수 호출
                 4-4-2. 좌표값이 배열범위를 벗어나거나 true면 0 반환
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        maxX = Integer.parseInt(st.nextToken());
        maxY = Integer.parseInt(st.nextToken());
        waitingNumber = Integer.parseInt(br.readLine());
        seatAssignment = new boolean[maxX][maxY];

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String seatCoordinate = isValidWaitingNumber() ? getSeatCoordinate(0, 0) : CANNOT_ASSIGNED;
        bw.write(seatCoordinate);
        bw.flush();
    }

    private static boolean isValidWaitingNumber() {
        int maxSeatCount = maxX * maxY;

        return maxSeatCount >= seatCount;
    }

    private static String getSeatCoordinate(int x, int y) {
        return increaseY(x, y);
    }

    private static String increaseY(int x, int y) {
        // 1. 현재 좌표값을 true로 변환
        seatAssignment[x][y] = true;
        seatCount++;

        // seatCount == K인 경우 해당 좌표 값을 반환
        if (seatCount == waitingNumber) {
            return String.format("%d %d", x + 1, y + 1);
        }

        // 2. 값을 증가 시키기 전 증가 시킨 좌표값이 배열범위를 벗어나거나 true인지 확인
        int increasedY = y + 1;

        // 3. false면 다음 좌표값으로 1-1부터 반복
        if (canSeatAssignment(x, increasedY)) {
            return increaseY(x, increasedY);
        }

        // 4. 배열범위를 벗어나거나 true면 현재 좌표값에서 x값을 증가 시킨 좌표값이 배열범위를 벗어나거나 true인지 확인
        int increasedX = x + 1;

        // 4-1. false면 다음 좌표 값으로 2번 함수 호출
        if (canSeatAssignment(increasedX, y)) {
            return increaseX(increasedX, y);
        }

        // 4-2. 좌표값이 배열범위를 벗어나거나 true면 0 반환
        return CANNOT_ASSIGNED;
    }

    private static String increaseX(int x, int y) {
        seatAssignment[x][y] = true;
        seatCount++;

        if (seatCount == waitingNumber) {
            return String.format("%d %d", x + 1, y + 1);
        }

        int increasedX = x + 1;
        if (canSeatAssignment(increasedX, y)) {
            return increaseX(increasedX, y);
        }

        int decreasedY = y - 1;
        if (decreasedY < maxY && canSeatAssignment(x, decreasedY)) {
            return decreaseY(x, decreasedY);
        }

        return CANNOT_ASSIGNED;
    }

    private static String decreaseY(int x, int y) {
        seatAssignment[x][y] = true;
        seatCount++;

        if (seatCount == waitingNumber) {
            return String.format("%d %d", x + 1, y + 1);
        }

        int decreasedY = y - 1;
        if (decreasedY < maxY && canSeatAssignment(x, decreasedY)) {
            return decreaseY(x, decreasedY);
        }

        int decreasedX = x - 1;
        if (canSeatAssignment(decreasedX, y)) {
            return decreaseX(decreasedX, y);
        }

        return CANNOT_ASSIGNED;
    }

    private static String decreaseX(int x, int y) {
        seatAssignment[x][y] = true;
        seatCount++;

        if (seatCount == waitingNumber) {
            return String.format("%d %d", x + 1, y + 1);
        }

        int decreasedX = x - 1;
        if (canSeatAssignment(decreasedX, y)) {
            return decreaseX(decreasedX, y);
        }

        int increasedY = y + 1;
        if (canSeatAssignment(x, increasedY)) {
            return increaseY(x, increasedY);
        }

        return CANNOT_ASSIGNED;
    }

    private static boolean canSeatAssignment(int x, int y) {
        if (x >= maxX || y >= maxY || x < 0 || y < 0) {
            return false;
        }
        return !seatAssignment[x][y];
    }
}