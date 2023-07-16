package haein.그래프.W10;
import java.io.*;

//메인 함수
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
//        트리 생성
        Tree tree = new Tree();

//        노드 입력받기, 노드 생성 (트리 구성)

        for(int i = 0; i<N; i++){
            String[] input = br.readLine().split(" ");

            tree.createNode(input[0], input[1], input[2]);
        }

//        결과 출력 (3줄-전, 중, 후)
        tree.preOrder(tree.root);
        System.out.println();

        tree.inOrder(tree.root);
        System.out.println();

        tree.postOrder(tree.root);
        System.out.println();
    }
}

class Tree{
    Node root = new Node(".");

//    노드 생성
//    새로운 노드를 생성하고 그 노드의 왼쪽과 오른쪽 자식 노드를 연결
//    트리의 루트 노드가 없을 경우 루트 노드를 생성
    void createNode(String mid, String left, String right){
        if(root.data.equals(".")){
            if(!mid.equals("."))
                root = new Node(mid);
            if(!left.equals("."))
                root.left = new Node(left);
            if(!right.equals("."))
                root.right = new Node(right);
        }
// 루트 노드가 이미 있을 경우 find 메서드를 호출하여 트리에서 적절한 위치를 찾아 노드를 삽입합니다.
        else find(root, mid, left, right);
    }

//    노드 찾기
    void find(Node node, String mid, String left, String right){
        if(node == null)
            return;

        else if(mid.equals(node.data)){
            if(!left.equals("."))
                node.left = new Node(left);
            if(!right.equals("."))
                node.right = new Node(right);
        }

        find(node.left, mid, left, right);
        find(node.right, mid, left, right);
    }



//    순회 방식 : 재귀 - 전위, 중위, 후위

//    전위 순회
    void preOrder(Node node){
//        자신 출력
        System.out.print(node.data);
//        왼쪽 방문
        if(node.left != null)
            preOrder(node.left);
//        오른쪽 방문
        if(node.right != null)
            preOrder(node.right);
    }


//중위 순회
    void inOrder(Node node){
        if(node.left != null)
            inOrder(node.left);

        System.out.print(node.data);

        if(node.right != null)
            inOrder(node.right);
    }


//    후위 순회
    void postOrder(Node node){
//        왼쪽 노드 재귀 순회
        if(node.left != null)
            postOrder(node.left);

        if(node.right != null)
            postOrder(node.right);

        System.out.print(node.data);
    }
}

class Node{
    String data;
    Node left, right;

    Node(String data){
        this.data = data;
    }
}