import java.util.Scanner;

public class BOJ_1976 {
    static int n;
    static int m;
    static int[] map;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n+1];
        for (int i = 1; i <= n; i++) { //각자 도시 초기화
            map[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int v = sc.nextInt();
                if (1 == v) {
                    union(i, j);
                }
            }
        }
        int r = find(sc.nextInt()); //첫번째 여행 경로
        for (int i = 2; i <= m; i++) { //배열 끝까지
            if (r != find(sc.nextInt())) { //대표값이 다르면 NO
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y) { //같으면 해줄 필요 없으니까
            map[y] = x;
        }
    }
    public static int find(int x) { //인덱스를 받아서 벨류(대표값(재귀로 찾아감))를 반환함
        if (map[x] == x)
            return x;
        return map[x] = find(map[x]);
    }
}

/*
이동이 가능한지만을 물어보는 것이기 때문에 한개의 집합에 속해있나를 물어보는것과 같다.
유니온 파인드라는것을 알아차리면 푸는것은 어렵지 않다.

유니온파인드의 예로 연결여부확인,싸이클검사,최소신장트리에서 연결 여부 확인에 해당한다.
*/
