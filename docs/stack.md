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
