package ch06_1_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931_회의실배정 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /*
		    time[][0] 은 시작시점
		    time[][1] 은 종료시점
		    */

        int[][] time = new int[N][2];
//        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            time[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {// 종료 시간이 같을 때
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
            // (2,2)(1,2) (1,2)(2,2)
        });
        int count = 0;
        int end = 0;

        for (int i = 0; i < N; i++) {
            // 겹치지 않는 다음 회의가 나온 경우
            if (end <= time[i][0]) {
                end = time[i][1]; //종료해주기
                count++;
            }
        }
        System.out.println(count);

    }

}

