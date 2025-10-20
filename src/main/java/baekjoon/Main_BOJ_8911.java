package baekjoon;

import java.io.*;

public class Main_BOJ_8911 {

    public static void main(String[] args) throws IOException {
        /*
            거북이가 지나간 영역을 모두 포함할 수 있는 가장 작은 직사각형
            -> 거북이가 지나간 (x, y) 좌표값 중 x, y 별로 가장 작은 값과 가장 큰 값을 x1, x2, y1, y2라고 할 때
            직사각형의 크기 = (x2 - x1) * (y2 - y1)

            1. 거북이가 지나간 좌표값 중 x, y 별로 가장 작은 값과 가장 큰 값을 저장하는 변수 선언
            2. 움직이는 명령(F || B) 시행 후 현재 좌표값을 기준으로 x1, x2, y1, y2 갱신
            3. 모든 명령 수행 후 영역 계산

            현재 좌표값 관리 -> x, y 각각 int 로 관리
            현재 바라보는 방향 관리 -> 원형 int 배열
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseCount; i++) {
            String commandLine = br.readLine();
            Turtle turtle = new Turtle(0, 0, 0);

            for (int j = 0; j < commandLine.length(); j++) {
                char command = commandLine.charAt(j);
                turtle.executeCommand(command);
            }

            int area = turtle.getArea();
            bw.write(area + "");
            bw.newLine();
        }

        bw.flush();
    }

    public static class Turtle {
        private int x;
        private int y;
        private int front;
        private int maxX = 0;
        private int minX = 0;
        private int maxY = 0;
        private int minY = 0;

        public Turtle(int x, int y, int front) {
            this.x = x;
            this.y = y;
            this.front = front;
        }

        public void executeCommand(final char command) {
            switch (command) {
                case 'F':
                    go();
                    changeCoordinate();
                    break;
                case 'B':
                    back();
                    changeCoordinate();
                    break;
                case 'R':
                    turnRight();
                    break;
                case 'L':
                    turnLeft();
                    break;
                default:
                    break;
            }
        }

        public int getArea() {
            return (maxX - minX) * (maxY - minY);
        }

        private void changeCoordinate() {
            if (x > maxX) {
                maxX = x;
            }

            if (x < minX) {
                minX = x;
            }

            if (y > maxY) {
                maxY = y;
            }

            if (y < minY) {
                minY = y;
            }
        }

        private void turnRight() {
            if (front == 3) {
                front = 0;
                return;
            }
            front++;
        }

        private void turnLeft() {
            if (front == 0) {
                front = 3;
                return;
            }
            front--;
        }

        private void go() {
            switch (front) {
                case 0:
                    y++;
                    break;
                case 1:
                    x++;
                    break;
                case 2:
                    y--;
                    break;
                case 3:
                    x--;
                    break;
                default:
                    break;
            }
        }

        private void back() {
            switch (front){
                case 0:
                    y--;
                    break;
                case 1:
                    x--;
                    break;
                case 2:
                    y++;
                    break;
                case 3:
                    x++;
                    break;
                default:
                    break;
            }
        }
    }
}