package baekjoon;

import java.io.*;
import java.util.*;

public class Main_BOJ_2503 {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 123; i < 988; i++) {
            int onesDigit = extractDigit(1, i);
            if (onesDigit == 0) {
                continue;
            }
            int tensDigit = extractDigit(2, i);
            if (tensDigit == 0 || onesDigit == tensDigit) {
                continue;
            }

            int hundredsDigit = extractDigit(3, i);
            if (hundredsDigit == onesDigit || hundredsDigit == tensDigit) {
                continue;
            }
            numbers.add(i);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());

        for (int i = 0; i < length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int guessedNumber = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for (int j = numbers.size() - 1; j >= 0; j--) {
                int currentStrike = getStrike(guessedNumber, numbers.get(j));
                if (currentStrike != strike) {
                    numbers.remove(j);
                    continue;
                }
                int currentBall = getBall(guessedNumber, numbers.get(j));
                if (currentBall != ball) {
                    numbers.remove(j);
                }
            }
        }
        bw.write(numbers.size());
        bw.flush();
    }

    private static int getStrike(final int guessedNumber, final int number) {
        int strike = 0;
        for (int i = 1; i < 4; i++) {
            int guessedDigit = extractDigit(i, guessedNumber);
            int numberDigit = extractDigit(i, number);
            if(guessedDigit == numberDigit) {
                strike++;
            }
        }
        return strike;
    }

    private static int getBall(final int guessedNumber, final int number) {
        int ball = 0;
        for (int i = 1; i < 4; i++) {
            int guessedDigit = extractDigit(i, guessedNumber);
            for (int j = 1; j < 4; j++) {
                if (i == j) {
                    continue;
                }
                int digit = extractDigit(j, number);
                if(guessedDigit == digit) {
                    ball++;
                }
            }
        }
        return ball;
    }

    private static int extractDigit(final int place, final int number) {
        int numerator = number;
        for (int i = 0; i < place - 1; i++) {
            numerator = numerator / 10;
        }
        return numerator % 10;
    }
}