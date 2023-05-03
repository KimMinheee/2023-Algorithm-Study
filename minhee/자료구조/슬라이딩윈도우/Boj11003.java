package minhee.자료구조.슬라이딩윈도우;
/**
 * BOJ11003 - 최솟값 찾기
 * - 슬라이딩윈도우, 덱 사용
 * - 교재,힌트 보고 품
 * - 우선순위큐는 시간초과(우선순위 큐 내부에서 정렬작업)
 */

import java.io.*;
import java.util.*;

public class Boj11003 {
    static int N, L;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        Deque<Node> deque = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());

            //1. deque에 현재 값보다 큰 값이 존재한다면 뒤에서부터 삭제
            while(!deque.isEmpty() && deque.getLast().value > num){ //to 오름차순 유지
                deque.removeLast();//현재 num보다 큰 값 뒤에서 부터 삭제
            }
            //2. deque에 노드 삽입
            deque.addLast(new Node(i,num));

            //3. 범위에서 벗어난 값은 덱에서 제거
            if(deque.getFirst().idx <= i-L) deque.removeFirst();

            bw.write(deque.getFirst().value+" ");

        }
        bw.flush();
        bw.close();
        br.close();

    }
}
class Node{
    int idx;
    int value;
    public Node(int idx, int value){
        this.idx = idx;
        this.value = value;
    }
}
