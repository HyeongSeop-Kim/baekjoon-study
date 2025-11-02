package baekjoon.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            문제
            정수 n(0 ≤ n ≤ 4*109)가 주어졌을 때, n보다 크거나 같은 소수 중 가장 작은 소수 찾는 프로그램을 작성하시오.

            입력
            첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다.

            출력
            각각의 테스트 케이스에 대해서 n보다 크거나 같은 소수 중 가장 작은 소수를 한 줄에 하나씩 출력한다.
         */
        long start = System.currentTimeMillis();
        long MAX = 4000000001L;
        Map<Long, Boolean> isPrimes = new HashMap<>();

        isPrimes.put(1L, false);

        for (long i = 2L; i < MAX; i++) {
            if (i != 2L && i % 2L == 0L) {
                isPrimes.put(i, false);
            } else  {
                isPrimes.put(i, true);
            }
        }

        for (long i = 3L; i * i <= MAX; i += 2L) {
            if (isPrimes.get(i)) {
                for (long j = i * i; j < MAX; j += i) {
                    isPrimes.replace(j, false);
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(System.currentTimeMillis() - start);
    }
}