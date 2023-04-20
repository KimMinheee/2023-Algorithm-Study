package week1;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11003_최솟값찾기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Pair> dq = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i=1; st.hasMoreTokens(); i++){
            int A = Integer.parseInt(st.nextToken());
            Pair pair = new Pair(i, A); //객체 생성
            while(!dq.isEmpty() && pair.value<=dq.getLast().value){ //뒤에서 부터 현재 요소보다 크거나 같은 값 삭제(최솟값)
                dq.removeLast();
            }
            dq.addLast(pair); //현재 요소 뒤에 삽입
            while(dq.getFirst().index <=pair.index-L){ //구간에 맞지 않는 수 삭제, 현재요소 인덱스-L보다 작은 수들은 이전 연산이므로 삭제(슬라이딩)
                dq.removeFirst();
            }
            bw.write(dq.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    private static class Pair {
        private int index;
        private int value;

        public Pair(int index, int value) { //index는 1씩 증가하는 형태로 생성
            this.index = index;
            this.value = value;
        }
    }
}


