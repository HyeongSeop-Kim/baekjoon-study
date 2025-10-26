## 개요

[백준](https://www.acmicpc.net/) 에서 프로그래밍 문제를 풀면서 공부한 것을 정리한 파일

## 소수
### 시행 나눗셈
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

### 에라토스테네스의 체
- 범위 안에서 소수를 판별하는 가장 빠른 방법.

```java
public static boolean[] sieveOfEratosthenes(int n) {
    boolean[] isPrime = new boolean[n + 1];

    // 초기화: 모두 소수로 가정
    for (int i = 2; i <= n; i++) {
        isPrime[i] = true;
    }

    for (int i = 2; i * i <= n; i++) {
        if (isPrime[i]) {
            // i의 배수들을 제거 (i는 남기고)
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;  // 배수 제거
            }
        }
    }

    return isPrime;
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

## 스택 (Stack)
- **LIFO (Last In First Out)**: 마지막에 들어온 데이터가 가장 먼저 나가는 구조

### 주요 연산
- **push(item)**: 스택의 맨 위에 요소 추가
- **pop()**: 스택의 맨 위 요소 제거 및 반환
- **peek() / top()**: 스택의 맨 위 요소 조회 (제거 X)
- **isEmpty()**: 스택이 비어있는지 확인

### Stack 클래스 사용
```java
import java.util.Stack;

Stack stack = new Stack<>();

// 삽입
stack.push(1);
stack.push(2);
stack.push(3);

// 조회
int top = stack.peek();  // 3

// 삭제
int popped = stack.pop();  // 3

// 비어있는지 확인
boolean empty = stack.isEmpty();  // false
```

### Deque를 Stack으로 사용 (권장)
```java
import java.util.ArrayDeque;
import java.util.Deque;

Deque stack = new ArrayDeque<>();

// 삽입
stack.push(1);  // 또는 stack.addFirst(1)
stack.push(2);
stack.push(3);

// 조회
int top = stack.peek();  // 3 (또는 stack.peekFirst())

// 삭제
int popped = stack.pop();  // 3 (또는 stack.pollFirst())

// 비어있는지 확인
boolean empty = stack.isEmpty();  // false
```

> **참고**: `Stack` 클래스는 레거시 클래스이므로 `Deque` 인터페이스를 구현한 `ArrayDeque`를 사용하는 것을 권장

### 주요 활용 사례
- **괄호 매칭**: 올바른 괄호 문자열 판별
- **후위 표기법 계산**: 중위 표기법을 후위 표기법으로 변환 및 계산
- **DFS (깊이 우선 탐색)**: 재귀 대신 스택으로 구현
- **백트래킹**: 이전 상태로 되돌아가기
- **모노톤 스택**: 다음/이전 큰/작은 원소 찾기
- **함수 호출 스택**: 재귀 함수의 동작 원리

### 주의사항
- `pop()` 또는 `peek()` 호출 전에 반드시 `isEmpty()` 체크
- 스택이 비어있을 때 `pop()` 호출 시 `EmptyStackException` 또는 `NoSuchElementException` 발생

---

## 큐 (Queue)
- **FIFO (First In First Out)**: 먼저 들어온 데이터가 먼저 나가는 구조
- 한쪽 끝(rear)에서 삽입, 다른 쪽 끝(front)에서 삭제

### 주요 연산
- **offer(item) / add(item)**: 큐의 끝에 요소 추가
- **poll() / remove()**: 큐의 앞 요소 제거 및 반환
- **peek() / element()**: 큐의 앞 요소 조회 (제거 X)
- **isEmpty()**: 큐가 비어있는지 확인

> **offer vs add**: `offer`는 실패 시 false 반환, `add`는 예외 발생  
> **poll vs remove**: `poll`은 빈 큐에서 null 반환, `remove`는 예외 발생  
> **peek vs element**: `peek`은 빈 큐에서 null 반환, `element`는 예외 발생

### LinkedList를 Queue로 사용
```java
import java.util.LinkedList;
import java.util.Queue;

Queue queue = new LinkedList<>();

// 삽입
queue.offer(1);
queue.offer(2);
queue.offer(3);

// 조회
int front = queue.peek();  // 1

// 삭제
int removed = queue.poll();  // 1

// 비어있는지 확인
boolean empty = queue.isEmpty();  // false
```

### ArrayDeque를 Queue로 사용 (더 빠름)
```java
import java.util.ArrayDeque;
import java.util.Queue;

Queue queue = new ArrayDeque<>();

// 삽입
queue.offer(1);
queue.offer(2);
queue.offer(3);

// 조회
int front = queue.peek();  // 1

// 삭제
int removed = queue.poll();  // 1

// 비어있는지 확인
boolean empty = queue.isEmpty();  // false
```

### 우선순위 큐 (Priority Queue)
- 각 요소가 우선순위를 가지며, 우선순위가 높은 요소가 먼저 나옴
- 내부적으로 힙(Heap) 자료구조 사용
- 기본적으로 **최소 힙** (작은 값이 높은 우선순위)

#### 시간 복잡도
- **offer(item)**: O(log n)
- **poll()**: O(log n)
- **peek()**: O(1)

#### 구현
```java
import java.util.PriorityQueue;
import java.util.Collections;

// 최소 힙 (기본)
PriorityQueue minHeap = new PriorityQueue<>();

// 최대 힙
PriorityQueue maxHeap = new PriorityQueue<>(Collections.reverseOrder());
// 또는
PriorityQueue maxHeap2 = new PriorityQueue<>((a, b) -> b - a);

// 삽입
minHeap.offer(3);
minHeap.offer(1);
minHeap.offer(2);

// 가장 작은 값 조회 및 제거
int min = minHeap.poll();  // 1
```

#### 커스텀 우선순위
```java
// 객체의 특정 필드 기준으로 정렬
class Task {
    int priority;
    String name;
    
    Task(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }
}

// 우선순위가 낮은 숫자가 먼저 나옴
PriorityQueue pq = new PriorityQueue<>((a, b) -> a.priority - b.priority);

// 우선순위가 같으면 이름 순으로
PriorityQueue pq2 = new PriorityQueue<>((a, b) -> {
    if (a.priority != b.priority) {
        return a.priority - b.priority;
    }
    return a.name.compareTo(b.name);
});

```

### 덱 (Deque - Double Ended Queue)
- 양쪽 끝에서 삽입과 삭제가 모두 가능한 자료구조
- 스택과 큐의 기능을 모두 수행 가능

#### 주요 연산
| 연산 | 앞(First) | 뒤(Last) | 시간 복잡도 |
|-----|----------|---------|-----------|
| 삽입 | addFirst() / offerFirst() | addLast() / offerLast() | O(1) |
| 삭제 | removeFirst() / pollFirst() | removeLast() / pollLast() | O(1) |
| 조회 | getFirst() / peekFirst() | getLast() / peekLast() | O(1) |

#### 구현
```java
import java.util.ArrayDeque;
import java.util.Deque;

Deque deque = new ArrayDeque<>();

// 앞에 삽입
deque.offerFirst(1);  // [1]
deque.offerFirst(2);  // [2, 1]

// 뒤에 삽입
deque.offerLast(3);   // [2, 1, 3]

// 앞에서 제거
int first = deque.pollFirst();  // 2, 남은 것: [1, 3]

// 뒤에서 제거
int last = deque.pollLast();    // 3, 남은 것: [1]

// 스택처럼 사용
deque.push(4);        // [4, 1]
int top = deque.pop(); // 4

// 큐처럼 사용
deque.offer(5);       // [1, 5]
int front = deque.poll(); // 1
```

### 주요 활용 사례

#### Queue
- **BFS (너비 우선 탐색)**: 최단 경로 탐색
- **레벨 순회**: 트리의 레벨별 탐색
- **프로세스 스케줄링**: 작업 순서 관리
- **캐시 구현**: LRU 캐시

#### Priority Queue
- **다익스트라 알고리즘**: 최단 경로
- **허프만 코딩**: 압축 알고리즘
- **작업 스케줄링**: 우선순위 기반 처리
- **K번째 최대/최소값**: Top K 문제

#### Deque
- **슬라이딩 윈도우**: 구간 최댓값/최솟값
- **팰린드롬 검사**: 양쪽에서 비교
- **스택/큐 동시 필요**: 유연한 자료구조 활용

### 주의사항

#### Queue
- `poll()` 호출 전에 `isEmpty()` 체크 (null 반환 방지)
- `LinkedList`보다 `ArrayDeque`가 일반적으로 더 빠름

#### Priority Queue
- 요소 삽입/삭제 시 O(log n)이므로 빈번한 연산에 주의
- `remove(Object)` 연산은 O(n)이므로 비효율적
- **힙 내부를 순회해도 정렬된 순서가 보장되지 않음** (완전 정렬이 필요하면 `poll()`로 꺼내야 함)
- 우선순위 비교 시 오버플로우 주의:
```java
  // 잘못된 예: 오버플로우 가능
  PriorityQueue pq = new PriorityQueue<>((a, b) -> a - b);
  
  // 올바른 예
  PriorityQueue pq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
```

#### Deque
- 용도에 따라 적절한 메서드 선택 (First/Last)
- `null` 요소를 허용하지 않음