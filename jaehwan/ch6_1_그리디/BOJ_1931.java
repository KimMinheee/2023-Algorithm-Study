import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1931 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int count = 0;
        int end = 0;
        int[][] time = new int[N][2];
        for (int i = 0; i < N; i++) {
            time[i][0] = in.nextInt(); // 시작
            time[i][1] = in.nextInt(); // 종료
        }
        // 끝나는 시간을 기준으로 한 재정의 필요
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {       // 종료시간이 같을 경우 시작시간이 빠른순
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        for (int i = 0; i < N; i++) {
            if (end <= time[i][0]) {//겹치지 않게 다음 회의가 나온 경우
                end = time[i][1];   //종료 시간 업데이트
                count++;
            }
        }
        System.out.println(count);
    }
}
/*
처음부터 끝까지 주어지는 숫자사이에 서로 겹치는 부분이 없는지 검사하는 문제
종료 시간이 빠른순으로 정렬, 종료시간이 겹친다면 시작 시간이 빠른 순으로 재정렬이필요하다
*/
