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