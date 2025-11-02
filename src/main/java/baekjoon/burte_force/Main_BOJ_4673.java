package baekjoon.burte_force;

import java.io.IOException;

public class Main_BOJ_4673 {
    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 10000; i++) {
            boolean isSelfNumber = true;
            for (int j = 1; j < i; j++) {
                String num = j + "";
                int temp = j;
                for (int k = 0; k < num.length(); k++) {
                    temp += num.charAt(k) - '0';
                }
                if (temp == i) {
                    isSelfNumber = false;
                }
            }
            if (isSelfNumber) {
                System.out.println(i);
            }
        }
    }
}