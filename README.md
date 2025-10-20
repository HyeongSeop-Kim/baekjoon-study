## 개요

[백준](https://www.acmicpc.net/) 에서 프로그래밍 문제를 풀면서 공부한 것을 정리한 파일

## 소수

### 에라토스테네스의 체
- 범위 안에서 소수를 판별하는 가장 빠른 방법.

```java
public static boolean trialDivision(long n) {
    if (n < 2) return false;
    if (n == 2) return true;
    if (n % 2 == 0) return false;

    for (long i = 3; i * i <= n; i += 2) {
        if (n % i == 0) return false;
    }
    return true;
}
```

### Miller-Rabin
- 확률적 알고리즘이나 정해진 witness 집합을 사용하면 확정적으로 소수를 판별할 수 있음.
    - 범위별 witness 집합은 다음과 같음.

| 범위                | witness                           |
|-------------------|-----------------------------------|
| n < 2,047         | {2}                               |
| n < 1,373,653     | {2, 3}                            |
| n < 25,326,001    | {2, 3, 5}                         |
| n < 3,215,031,751 | {2, 3, 5, 7}                      |
| n < 2⁶³-1         | {2,3,5,7,11,13,17,19,23,29,31,37} |
- 10,000,000 이상의 큰 수에 적합.

```java
    public static boolean isPrime(long n) {
    if (n < 2) return false;
    if (n == 2 || n == 3) return true;
    if (n % 2 == 0) return false;

    long d = n - 1;
    int r = 0;
    while (d % 2 == 0) {
        d /= 2;
        r++;
    }

    // long 범위에서 100% 정확한 witness 집합
    long[] witnesses = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};

    for (long a : witnesses) {
        if (a >= n) continue;
        if (!millerTest(n, a, d, r)) {
            return false;
        }
    }
    return true;
}

private static boolean millerTest(long n, long a, long d, int r) {
    long x = modPow(a, d, n);
    if (x == 1 || x == n - 1) return true;

    for (int i = 0; i < r - 1; i++) {
        x = modMul(x, x, n);
        if (x == n - 1) return true;
    }
    return false;
}

private static long modPow(long base, long exp, long mod) {
    long result = 1;
    base %= mod;
    while (exp > 0) {
        if (exp % 2 == 1) {
            result = modMul(result, base, mod);
        }
        base = modMul(base, base, mod);
        exp /= 2;
    }
    return result;
}

private static long modMul(long a, long b, long mod) {
    return (long) ((a % mod) * (b % mod) % mod);
}
```