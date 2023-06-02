import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2251_물통 {

    private static int a, b, c;
    private static ArrayList<Integer> ans;
    
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int max = Math.max(a, b);
        max = Math.max(max, c);

        ans = new ArrayList<>();
        visited = new boolean[max + 1][max + 1][max + 1];
//        visited = new boolean[201][201][201];
        bfs();

        for (int i : ans) {
            bw.write(ans.get(i) + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void bfs() {
        Queue<Pot> q = new LinkedList<>();
        q.add(new Pot(0, 0, c));
        
        while (!q.isEmpty()) {
            Pot pots = q.poll();
            int currA = pots.a;
            int currB = pots.b;
            int currC = pots.c;

            System.out.println("currA = " + currA);
            System.out.println("currB = " + currB);
            System.out.println("currC = " + currC);
            //현재 물통 상황 이미 체킹했다면 패스
            if(visited[currA][currB][currC])
                continue;

            visited[currA][currB][currC] = true;
            if (currA == 0) { //a용량 0일 때 c용량 저장
                ans.add(currC);
            }

            //물통 연산
            // c -> a로 옮기기, a, b두군데 들어갈 공간 충분할 때
            if (currA + currC >= a) { //넘치면 b에도 넣는다.
                System.out.println("c -> a로 옮기기, 넘칠 때");
                q.add(new Pot(a, currB + currC - a, currC - (a - currA))); //c -> a
            }
            else{ //넘치지 않으면 그대로
                System.out.println("c -> a로 옮기기");
                q.add(new Pot(currA + currC, currB, 0));
            }

            //c -> b로 옮기기
            if (currB + currC >= b) { //넘치면 a에도 넣는다.
                System.out.println("c -> b로 옮기기, 넘칠 때");
                q.add(new Pot(currA + currC - b, b, currC - (b - currB))); //c -> b
            }
            else{ //넘치지 않으면 그대로
                System.out.println("c -> b로 옮기기");
                q.add(new Pot(currA, currB + currC, 0));
            }

            //a -> b로 옮기기
            if(currA + currB >= b) { //b 넘칠 때
                System.out.println("a -> b로 옮기기, 넘칠 때");
                q.add(new Pot(currA - (b - currB), b, currC));
            }
            else{ //넘치지 않을 때
                System.out.println("a -> b로 옮기기");
                q.add(new Pot(0,currA +currB, currC));
            }

            //b -> a로 옮기기
            if(currA + currB >= a) { //a 넘칠 때
                System.out.println("b -> a로 옮기기, 넘칠 때");
                q.add(new Pot(a, currB - (a - currA), currC));
            }
            else{ //넘치지 않을 때
                System.out.println("b -> a로 옮기기");
                q.add(new Pot(currA + currB,0, currC));
            }

            //a -> c로 옮기기
            if(currA + currC >=c){ //c 넘칠 때
                System.out.println("a -> c로 옮기기, 넘칠 때");
                q.add(new Pot(currA - (c - currC), currB - (a - currA), c));
            }
            else{ //넘치지 않을 때
                System.out.println("a -> c로 옮기기");
                q.add(new Pot(0, currB, currA + currC));
            }

            //b -> c로 옮기기
            if (currB + currC >= c) { //넘칠 때
                System.out.println("b -> c로 옮기기, 넘칠 때");
                q.add(new Pot(currA, currB - (c -currC), c));
            }
            else{
                System.out.println("b -> c로 옮기기");
                q.add(new Pot(currA, 0, currB + currC));
            }

            
        }
    }

    public static class Pot{
        int a;
        int b;
        int c;

        public Pot(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
