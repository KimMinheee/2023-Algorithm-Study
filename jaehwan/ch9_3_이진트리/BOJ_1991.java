import java.io.*;
import java.util.Scanner;

public class BOJ_1991 {//[BOJ_1991]트리순회 jaehwan solved - 재귀 사용
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        tree = new int[26][2]; //알파벳 개수 26개만큼 인덱스 / 왼/오
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            int node = temp[0].charAt(0) - 'A'; //노드를 숫자로 표현 A라고 한다면 65를 뺀 값 0이 저장
            char left = temp[1].charAt(0);
            char right = temp[2].charAt(0);

            if (left == '.') {
                tree[node][0] = -1;
            } else {
                tree[node][0] = left - 'A';
            }
            if (right == '.') {
                tree[node][1] = -1;
            } else {
                tree[node][1] = right - 'A';
            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }

    public static void preOrder(int now) { //전위
        if (now == -1)
            return;
        System.out.print((char) (now + 'A')); //현재 노드 출력
        preOrder(tree[now][0]); //왼쪽 노드 탐색
        preOrder(tree[now][1]); //오른쪽 노드 탐색
    }

    public static void inOrder(int now) { //중위
        if (now == -1)
            return;
        inOrder(tree[now][0]);
        System.out.print((char) (now + 'A'));
        inOrder(tree[now][1]);
    }

    public static void postOrder(int now) {//후위
        if (now == -1)
            return;
        postOrder(tree[now][0]);
        postOrder(tree[now][1]);
        System.out.print((char) (now + 'A'));
    }
}
/*
전위 순회(preorder traversal):
전위 순회는 트리의 루트 노드를 가장 먼저 방문하고, 왼쪽 서브트리를 순회한 뒤에 오른쪽 서브트리를 순회하는 방식입니다.
전위 순회의 순서는 다음과 같습니다: 루트-왼쪽-오른쪽. 즉, 노드를 방문하는 순서는 루트, 왼쪽 서브트리, 오른쪽 서브트리입니다.

중위 순회(inorder traversal):
중위 순회는 왼쪽 서브트리를 순회한 뒤에 루트 노드를 방문하고, 오른쪽 서브트리를 순회하는 방식입니다.
중위 순회의 순서는 다음과 같습니다: 왼쪽-루트-오른쪽. 즉, 노드를 방문하는 순서는 왼쪽 서브트리, 루트, 오른쪽 서브트리입니다.

후위 순회(postorder traversal):
후위 순회는 왼쪽 서브트리를 순회한 뒤에 오른쪽 서브트리를 순회한 후에 루트 노드를 방문하는 방식입니다.
후위 순회의 순서는 다음과 같습니다: 왼쪽-오른쪽-루트. 즉, 노드를 방문하는 순서는 왼쪽 서브트리, 오른쪽 서브트리, 루트입니다.

각 순회 방법은 트리의 노드를 서로 다른 순서로 방문하기 때문에 특정한 순서로 노드를 처리해야 할 때 유용합니다.
이러한 순회 방법은 재귀적인 방법이나 스택(stack)을 사용하여 구현할 수 있습니다.
*/
