import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1931_회의실배정 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Comparator<Pair>) (o1, o2) -> {
            //종료시간 같으면 시작시간 이른 것이 먼저
            if(o1.end == o2.end) return o1.start-o2.start;
            //종료시간 이른 것이 먼저
            return o1.end - o2.end;
        });
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int endTime = -1; //현재 종료 시간
        int cnt = 0; //회의 진행 횟수
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            if(endTime <= pair.start) { //현재 종료시간 다음으로 올 수 있는 회의 찾으면
                endTime = pair.end; //종료시간 업데이트
                cnt++; //진행 회의 수 증가
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

        private static class Pair {
            int start;
            int end;

            public Pair(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }
}
