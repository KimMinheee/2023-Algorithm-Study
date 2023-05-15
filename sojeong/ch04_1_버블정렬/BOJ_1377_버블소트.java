package ch04_1_버블정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1377_버블소트 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Point[] points = new Point[N + 1];
        for (int i = 1; i <= N; i++) {
            int temp = Integer.parseInt(br.readLine());
            points[i] = new Point(temp, i);
        }
        Arrays.sort(points, 1, N + 1); // 숫자를 기준으로 오름차순 정렬

        int max = 0;
        for (int i = 1; i <= N; i++) { // 해당 숫자의 인덱스가 몇 칸 움직였는지 계산
            max = Math.max(max, points[i].idx - i); // -> (이동한 횟수 - 1)번
        }

        bw.write((max + 1) + "\n"); // 위에서 구한 값은 (이동한 횟수 - 1)번이므로 1 더함.
        bw.close();
        br.close();
    }

}

class Point implements Comparable<Point> {
    int num; // 숫자
    int idx; // 인덱스

    Point(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }

    @Override
    public int compareTo(Point o) {
        return num - o.num;
    }

}