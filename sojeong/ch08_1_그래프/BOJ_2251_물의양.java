package ch08_1_그래프;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2251_물의양 {
    static boolean[][][] visit;
    static boolean[] answer;
    static int[] amount;
    static int[][] base = {{0,1},{0,2},{1,0},{1,2},{2,0},{2,1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        visit = new boolean[a+1][b+1][c+1];
        answer = new boolean[c+1];
        amount = new int[]{a,b,c};
        BFS(0, 0, c);

        for(int i=0; i<=c; i++) {
            if(answer[i] == true) {
                System.out.print(i + " ");
            }
        }

    }

    public static void BFS(int a, int b, int c) {
        Queue<Liter> que = new LinkedList<Liter>();

        que.add(new Liter(a,b,c));
        visit[a][b][c] = true;

        while(!que.isEmpty()) {
            Liter liter = que.poll();
            if(liter.a == 0) {
                answer[liter.c] = true;
            }
            for(int i = 0; i<6; i++) {
                //다음 물의양 설정하기
                int[] now = {liter.a, liter.b, liter.c};
                now[base[i][1]] = now[base[i][1]] + now[base[i][0]];
                now[base[i][0]] = 0;
                if(now[base[i][1]] > amount[base[i][1]] ){
                    now[base[i][0]]	= now[base[i][1]] - amount[base[i][1]];
                    now[base[i][1]] = amount[base[i][1]];
                }

                if(visit[now[0]][now[1]][now[2]] == false) {
                    //다음 a,b,c의 값을 큐에 추가
                    que.add(new Liter(now[0], now[1], now[2]));
                    visit[now[0]][now[1]][now[2]] = true;
                }
            }
        }
    }
}

class Liter{
    int a;
    int b;
    int c;
    public Liter(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
