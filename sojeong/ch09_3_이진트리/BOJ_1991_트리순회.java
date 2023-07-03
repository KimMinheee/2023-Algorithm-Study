package ch09_3_이진트리;

import java.util.*;

class Node{
    char Data;
    Node Left, Right;
    public Node(char Data) {
        this.Data = Data;
    }
}

class Tree{
    Node Root;

    public void Add(char Data, char Left_Data, char Right_Data) {
        if(Root==null) {
            //Data가 .이 아니라면 루트에 Data 값을 가진 노드 생성
            if(Data!='.') Root = new Node(Data);
            //왼쪽 자식 노드 데이터가 .이 아니라면 Left_Data를 가진 왼쪽 자식 노드 생성
            if(Left_Data!='.') Root.Left = new Node(Left_Data);
            //오른쪽 자식 노드 데이터가 .이 아니라면 Right_Data를 가진 오른쪽 자식 노드 생성
            if(Right_Data!='.') Root.Right = new Node(Right_Data);
        }
        //루트가 널이 아니라면 탐색
        else Search(Root, Data, Left_Data, Right_Data);
    }

    public void Search(Node Root, char Data, char Left_Data, char Right_Data) {
        //만약에 루트노드가 null이면 종료
        if(Root==null) return;

            //루트노드의 데이터가 Data라면
        else if(Root.Data==Data) {
            if(Left_Data!='.') Root.Left = new Node(Left_Data);
            if(Right_Data!='.') Root.Right = new Node(Right_Data);
        }
        //아니라면 , 못찾았다면
        else {
            Search(Root.Left, Data, Left_Data, Right_Data);
            Search(Root.Right, Data, Left_Data, Right_Data);
        }
    }

    //전위 순회
    public void PreOrder(Node Root) {
        //루트 -> 왼쪽 자식 -> 오른쪽 자식
        //먼저 루트노드 출력

        System.out.print(Root.Data);

        if(Root.Left!=null) PreOrder(Root.Left);

        if(Root.Right!=null) PreOrder(Root.Right);
    }

    //중위 순회
    public void InOrder(Node Root) {
        //왼쪽 자식 -> 루트 -> 오른쪽 자식

        if(Root.Left!=null) InOrder(Root.Left);
        //루트노드 출력
        System.out.print(Root.Data);

        if(Root.Right!=null) InOrder(Root.Right);
    }

    //후위 순회
    public void PostOrder(Node Root) {
        //왼쪽 자식 -> 오른쪽 자식 -> 루트

        if(Root.Left!=null) PostOrder(Root.Left);

        if(Root.Right!=null) PostOrder(Root.Right);

        //루트노드 출력
        System.out.print(Root.Data);


    }
}

public class BOJ_1991_트리순회 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //트리노드의 개수

        Tree tree = new Tree();
        for(int i=0;i<N;i++) {
            tree.Add(sc.next().charAt(0),sc.next().charAt(0),sc.next().charAt(0));
        }

        tree.PreOrder(tree.Root);
        System.out.println();
        tree.InOrder(tree.Root);
        System.out.println();
        tree.PostOrder(tree.Root);
    }
}