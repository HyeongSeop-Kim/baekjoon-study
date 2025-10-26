package baekjoon.prime_number;

import java.io.*;

public class Main_BOJ_6588 {
    public static void main(String[] args) throws IOException {
        /*
            문제 조건
            1. 6 <= n <= 1000000
            2. 입력 마지막 줄은 0

            풀이 순서
            1. 에라스토테네스의 체를 활용하여 boolean[] isPrime = new boolean[1000001];
            2. isPrime을 순회하여 2 이상, 1000000 미만의 소수를 저장한 int[] 생성
                - 2, 100000는 짝수이기 때문
            3. 테스트 케이스에 대해 int 배열을 역순으로 순회하여 임의의 b 지정
                - 성능 최적화를 위해 b > n인 경우 continue
            4. 지정한 b에 대해 n - b로 a를 지정하고 isPrime[]을 활용해 a가 소수인지 판별
                - b를 역순으로 지정하였기 때문에 처음 찾은 a + b = n인 케이스가 b - a가 가장 큰 경우라고 판단
            5. 3번에서 찾지 못한 경우 "Goldbach's conjecture is wrong." return
         */

        // 1. 에라스토테네스의 체를 활용하여 boolean[] isPrime = new boolean[1000001];
        boolean[] isPrime = new boolean[1000001];

        for (int i = 2; i <= 1000000; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= 1000000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 2. isPrime을 순회하여 2 이상, 1000000 미만의 소수를 저장한 int[] 생성
//        int[] primes = new int[500000];
//        int primeCount = 0;
//        for (int i = 3; i <= 1000000; i++) {
//            if (isPrime[i]) {
//                primes[primeCount] = i;
//                primeCount++;
//            }
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            // 3. 테스트 케이스에 대해 int 배열을 역순으로 순회하여 임의의 b 지정
//            for (int i = primeCount - 1; i >= 0; i--) {
//                int b = primes[i];
//
//                if (b >= n) continue;
//
//                // 4. 지정한 b에 대해 n - b로 a를 지정하고 isPrime[]을 활용해 a가 소수인지 판별
//                int a = n - b;
//                if (isPrime[a]) {
//                    result = String.format("%d = %d + %d", n, a, b);
//                    break;
//                }
//            }
            boolean isCollect = false;
            for (int i = 3; i <= n/2; i+=2) {
                int a = i;

                if (!isPrime[a]) continue;

                int b = n - a;
                if (isPrime[b]) {
                    bw.write(n + " = " + a + " + " + b + "\n");
                    isCollect = true;
                    break;
                }
            }

            if (!isCollect) {
                bw.write("Goldbach's conjecture is wrong.\n");
            }
        }

        bw.flush();
        bw.close();
    }
}