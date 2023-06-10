import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2251 {
    static int A,B,C;
    static ArrayList<Integer> answer; //정답 배열 

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        A = Integer.parseInt(st.nextToken()); //최대용량 입력받기
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        answer=new ArrayList<>();//가능한 c의 용량을 담음
        BFS();
        Collections.sort(answer);
        for(int i:answer){
            System.out.print(i+ " ");
        }
    }

    public static void BFS() {
        Queue<ABC> q = new LinkedList<>();
        boolean[][][] visited = new boolean[A + 1][B + 1][C + 1];

        q.add(new ABC(0, 0, C));// 초기 상태 문제에서 말한 처음상태
        while (!q.isEmpty()) {
            ABC curr = q.poll();
            if (visited[curr.a][curr.b][curr.c]) //이미 방문한 상태일 경우 건너뜀
                continue;

            if (curr.a == 0) { //a물통이 비어있는 경우일때마다 c물통의 용량을 정답 리스트에 추가
                answer.add(curr.c);
            }

            visited[curr.a][curr.b][curr.c] = true;//방문 체크

            // case 1: A->B
            if (curr.a + curr.b <= B) { //현재 담겨있는 물의 양이 b를 초과하면 
                q.add(new ABC(0, curr.a + curr.b, curr.c)); //보내는 물통은 전부 비우고 보내는 물양 + 보낼곳의 물양
            } else { //넘칠경우
                q.add(new ABC(curr.a + curr.b - B, B, curr.c)); //더한 값에서 b 값 만큼 빼줌 그리고 b에 최대용량 담음 
            }
            // case 2: A->C
            if (curr.a + curr.c <= C) {
                q.add(new ABC(0, curr.b, curr.a + curr.c));
            } else {
                q.add(new ABC(curr.a + curr.c - C, curr.b, C));
            }
            // case 3: B->A
            if (curr.a + curr.b <= A) {
                q.add(new ABC(curr.a + curr.b, 0, curr.c));
            } else {
                q.add(new ABC(A, curr.a + curr.b - A, curr.c));
            }
            // case 4: B->C
            if (curr.b + curr.c <= C) {
                q.add(new ABC(curr.a, 0, curr.b + curr.c));
            } else {
                q.add(new ABC(curr.a, curr.b + curr.c - C, C));
            }
            // case 5: C->A
            if (curr.a + curr.c <= A) {
                q.add(new ABC(curr.a + curr.c, curr.b, 0));
            } else {
                q.add(new ABC(A, curr.b, curr.a + curr.c - A));
            }
            // case 6: C->B
            if (curr.b + curr.c <= B) {
                q.add(new ABC(curr.a, curr.b + curr.c, 0));
            } else {
                q.add(new ABC(curr.a, B, curr.b + curr.c - B));
            }
        }
    }
}
class ABC{// 물통의 상태를 저장하는 클래스 각각 현재 물통의 현재 용량임
   int a;
    int b;
    int c;
    public ABC(int a,int b,int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
}

/*
BFS 문제이다.
물통에서 물을 옮기는 방법은 아래와 같이 6가지

A->B
A->C
B->A
B->C
C->A
C->B

이에 맞게 BFS를 작성하면 된다.
*/
