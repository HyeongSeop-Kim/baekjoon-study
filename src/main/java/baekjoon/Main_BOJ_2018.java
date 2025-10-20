package baekjoon;

import java.io.*;
import java.util.*;

public class Main_BOJ_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        int[] numbers = new int[length];
        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < length; i++) {
            numbers[i] = Integer.parseInt(br.readLine());

            if (frequency.containsKey(numbers[i])) {
                frequency.put(numbers[i], frequency.get(numbers[i]) + 1);
            } else {
                frequency.put(numbers[i], 1);
            }
        }

        // 정렬
        Arrays.sort(numbers);

        // 평균값
        double average = 0;
        OptionalDouble optionalDouble = Arrays.stream(numbers).average();

        if (optionalDouble.isPresent()) {
            average = optionalDouble.getAsDouble();
        }
        bw.write((int) Math.round(average));

        // 중앙값
        int centerNumber = numbers[numbers.length / 2];
        bw.write(centerNumber);

        // 최빈값

        // 1. 값 -> 횟수를 map에 담아야겠다.
        // 2. 반복문을 통해서(?) 최빈값을 구해야겠다.
        Comparator<Map.Entry<Integer, Integer>> comparator = Map.Entry.comparingByValue();

        int maxFrequency = Collections.max(frequency.entrySet(), comparator).getValue();

        // 3. 최빈값이랑 같은 value를 가진 key만 모아야겠다.
        // 4. 정렬도 필요하겠다.<- 두번째로 작은값을 반환해야하니까.
        Set<Map.Entry<Integer, Integer>> entries = frequency.entrySet();
        int[] maxFrequencies = entries.stream()
                .filter(e -> e.getValue() == maxFrequency)
                .mapToInt(Map.Entry::getKey)
                .sorted()
                .toArray();


        // 5. 값이 하나면 바로 반환 여러개면 두번쨰 값 반환.
        if (maxFrequencies.length == 1) {
            bw.write(maxFrequencies[0]);
        } else {
            bw.write(maxFrequencies[1]);
        }

        // 범위
        int minNumber = numbers[0];
        int maxNumber = numbers[length - 1];
        int range = maxNumber - minNumber;
        bw.write(range);

        bw.flush();
    }
}