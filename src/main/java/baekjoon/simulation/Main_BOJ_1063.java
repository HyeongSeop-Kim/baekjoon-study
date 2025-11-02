package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String kingPosition = st.nextToken();
        Piece king = new Piece(kingPosition.charAt(0), kingPosition.charAt(1));

        String rockPosition = st.nextToken();
        Piece rock = new Piece(rockPosition.charAt(0), rockPosition.charAt(1));

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String commands = br.readLine();

            if (king.canMove(commands)) {
                for (int j = 0; j < commands.length(); j++) {
                    king.move(commands.charAt(j));
                }

                if (king.equals(rock)) {
                    if(rock.canMove(commands)) {
                        for (int j = 0; j < commands.length(); j++) {
                            rock.move(commands.charAt(j));
                        }
                    } else {
                        for (int j = 0; j < commands.length(); j++) {
                            king.backMove(commands.charAt(j));
                        }
                    }
                }
            }
        }

        king.printPosition();
        rock.printPosition();

        br.close();
    }

    public static class Piece {
        int x;
        int y;

        public Piece(char x, char y) {
            this.x = x - 'A' + 1;
            this.y = y - '1' + 1;
        }

        public boolean canMove(String command) {
            switch (command) {
                case "R":
                    if (x < 8) return true;
                    break;
                case "L":
                    if (x > 1) return true;
                    break;
                case "B":
                    if (y > 1) return true;
                    break;
                case "T":
                    if (y < 8) return true;
                    break;
                case "RB":
                    if (x < 8 && y > 1) return true;
                    break;
                case "LB":
                    if (x > 1 && y > 1) return true;
                    break;
                case "RT":
                    if (x < 8 && y < 8) return true;
                    break;
                case "LT":
                    if (x > 1 && y < 8) return true;
                    break;
                default:
                    return false;
            }
            return false;
        }

        public void move(char command) {
            switch (command) {
                case 'R':
                    x++;
                    break;
                case 'L':
                    x--;
                    break;
                case 'B':
                    y--;
                    break;
                case 'T':
                    y++;
                    break;
                default:
                    break;
            }
        }

        public void backMove(char command) {
            switch (command) {
                case 'R':
                    x--;
                    break;
                case 'L':
                    x++;
                    break;
                case 'B':
                    y++;
                    break;
                case 'T':
                    y--;
                    break;
                default:
                    break;
            }
        }

        public void printPosition() {
            char printX = (char) (x - 1 + 'A');
            char printY = (char) (y - 1 + '1');
            System.out.println("" + printX + printY);
        }

        public boolean equals(Piece p) {
            return x == p.x && y == p.y;
        }
    }
}