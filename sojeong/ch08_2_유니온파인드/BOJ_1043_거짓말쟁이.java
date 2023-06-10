package ch08_2_유니온파인드;
import java.io.*;
import java.util.*;

public class BOJ_1043_거짓말쟁이 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, total = 0;
    static boolean[] truePeople = new boolean[51];
    static int[] parent;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람 수
        M = Integer.parseInt(st.nextToken()); // 파티 수

        // 1. union-find 초기화
        parent = new int[N+1];
        for(int i=1;i<=N; i++) {
            parent[i] = i;
        }

        // 2. 진실을 아는 사람 정보 받아오기 truePeople[진실을아는사람] == true
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++) {
            truePeople[Integer.parseInt(st.nextToken())] = true;
        }

        // 3. 파티 정보를 받아오면서 같은 파티에 있는 사람들 union
        ArrayList<Integer>[] peoples = new ArrayList[M];
        for(int i=0; i<M; i++) {
            peoples[i] = new ArrayList<>();
        }
        int value, pre =0;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n > 0) {
                pre = Integer.parseInt(st.nextToken());
                peoples[i].add(pre);
            }
            for(int j=1; j<n; j++) {
                value = Integer.parseInt(st.nextToken());
                peoples[i].add(value);
                union(pre, value); // 두명씩 union하면 모두가 같은 parent를 갖게 됨.
                pre = value;
            }
        }

        // 4. 진실을 아는 사람들의 parent는 같이 파티를 참여 했으므로 진실을 아는 사람들
        int parent;
        for(int i=1; i<truePeople.length; i++) {
            if(truePeople[i]) {
                truePeople[find(i)] = true;
            }
        }

        // 5. 진실을 아는 사람들과 파티를 같이 하지 않았으면 total++
        for(int i=0; i<M; i++) {
            if(peoples[i].size() > 0) {
                parent = find(peoples[i].get(0));
                if(!truePeople[parent]) total++;
            }
        }

        // 6. 거짓말 할 수 있는 파티 최대 수 출력
        System.out.println(total);
    }

    private static int find(int x) {
        if(parent[x] == x)
            return parent[x] = x;
        else  return find(parent[x]);

    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a!= b) {
            if(a>b) {
                parent[a] = b;
            } else {
                parent[b] = a;
            }
            return true;
        }
        return false;
    }
}