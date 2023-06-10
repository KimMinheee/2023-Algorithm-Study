package haein.그래프.유니온파인드;

import java.io.*;
import java.util.*;
public class Boj1043_거짓말쟁이가되긴싫어 {
    static int[] parent;

    static int find(int x) {
        if (x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y)
            parent[y] = x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;

        ArrayList<Integer>[] party = new ArrayList[M + 1];
        for (int i = 1; i <= M; i++)
            party[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int truePersonNum = Integer.parseInt(st.nextToken());
        int[] truePerson = new int[truePersonNum];

        if (truePersonNum != 0) {
            for (int i = 0; i < truePersonNum; i++) {
                truePerson[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int partyPersonNum = Integer.parseInt(st.nextToken());

                int firstPerson = Integer.parseInt(st.nextToken());
                party[i].add(firstPerson);

                for (int j = 1; j < partyPersonNum; j++) {
                    int otherPerson = Integer.parseInt(st.nextToken());
                    party[i].add(otherPerson);
                    union(firstPerson, otherPerson);
                }
            }

            for (int i = 1; i < truePersonNum; i++)
                union(truePerson[0], truePerson[i]);

            int count = 0;
            for (int i = 1; i <= M; i++) {
                boolean possible = true;
                for (int person : party[i]) {
                    if (find(truePerson[0]) == find(person)) {
                        possible = false;
                        break;
                    }
                }

                if (possible)
                    count++;
            }

            System.out.println(count);
        } else {
            System.out.println(M);
        }
    }
}
