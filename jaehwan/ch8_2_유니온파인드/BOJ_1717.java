import java.util.Scanner;
public class BOJ_1717 {
    public static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//원소개수
        int M = sc.nextInt();//질의개수
        parent = new int[N + 1]; //대표 노드
        for (int i = 0; i <= N; i++) { // 대표 노드를 자기 자신으로 초기화 하기
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) { //질문 개수만큼 반복
            int question = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (question == 0) { // 집합합치기
                union(a, b);
            } else { // 같은 집합의 원소인지 확인하기
                if (same(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
    //union연산: 각 노드가 속한 집합을 1개로 합치는 연산
    public static void union(int a, int b) { // union 연산 : 바로 연결이 아닌 대표 노드끼리 연결하여 줌
        a = find(a); // 대표값
        b = find(b); //
        if (a != b) { // 대표값이 다르면 b인덱스 값 a로 바꿔줌
            parent[b] = a;
        }
    }
    //각 노드 a에 관해 a가 속한 집합의 대표노드를 반환하는 연산
    public static int find(int a) { // find 연산 / 자신이 속한 대표값 반환
        if (a == parent[a]) { //인덱스의 값과 벨류가 같은지 확인
            return a;}
        else {
            //경로압축
            return parent[a] = find(parent[a]);
            //value값을 index로 바꿔서 재귀
            // 재귀가 빠져나오면서 대표값으로 바뀐다
        }
    }
    public static boolean same(int a, int b) { // 두 원소가 같은 집합인지 확인
        a = find(a);
        b = find(b);
        if (a == b) {
            return true;
        }
        return false;
    }
}
/*
유니온 파인드를 구현해보라는 문제이다.
재귀를 하면서 경로압축을 해주는것에 유의하며 유니온 연산과 파인드 연산을 해주면된다.
* */
