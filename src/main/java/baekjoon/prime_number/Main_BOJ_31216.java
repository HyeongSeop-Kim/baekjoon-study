package baekjoon.prime_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_31216 {
    public static void main(String[] args) throws IOException {
        /*
            k/n 번째로 작은 것 -> k/n 번째
            1 <= n <= 3000 이라는 범위가 주어졌으므로
            충분한 범위의 숫자에 대해 미리 소수 여부를 체크.
            소수를 판별하면서 소수의 갯수를 함께 카운팅하여 해당 소수가 슈퍼 소수인지 체크.
            슈퍼 소수인 경우 배열에 저장, n번째 슈퍼소수를 슈퍼소수 배열(n-1)에서 바로 찾아 반환
         */
        int MAX = 320000;
        boolean[] isPrime = new boolean[MAX + 1];

        for (int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int[] superPrimes = new int[3001];

        int primeCount = 0;
        int superPrimeCount = 0;

        for (int i = 2; i <= MAX; i++) {
            if (isPrime[i]) {
                primeCount++;

                if (isPrime[primeCount]) {
                    superPrimeCount++;
                    superPrimes[superPrimeCount] = i;

                    if (superPrimeCount >= 3000) break;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(superPrimes[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }
}