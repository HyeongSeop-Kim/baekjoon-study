package baekjoon;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BOJ_13414 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxStudents = Integer.parseInt(st.nextToken());
        int studentsCount = Integer.parseInt(st.nextToken());

        Set<String> applyForCourse = new LinkedHashSet<>();

        for (int i = 0; i < studentsCount; i++) {
            String studentNumber = br.readLine();
            applyForCourse.remove(studentNumber);
            applyForCourse.add(studentNumber);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Iterator<String> iterator = applyForCourse.iterator();
        for (int i = 0; i < maxStudents; i++) {
            if (!iterator.hasNext()) {
                break;
            }
            bw.write(iterator.next());
            bw.newLine();
        }
        bw.flush();
    }
}