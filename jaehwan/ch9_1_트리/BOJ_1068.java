import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1068 {//[BOJ_1068]리프노드 jaehwan solved - dfs 사용
    static boolean[] visit;
    static ArrayList<Integer>[] tree;
    static int answer=0;
    static int deleteNode=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        tree=new ArrayList[N];
        visit=new boolean[N];
        int root=0;
        for(int i=0;i<N;i++){
            tree[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<N;i++){//인접리스트에 데이터 저장
            int p=sc.nextInt();
            if(p!=-1){
                tree[i].add(p);
                tree[p].add(i);
            }
            else{root=i;}
        }
        deleteNode=sc.nextInt(); //삭제할 노드
        if(deleteNode==root){System.out.println(0);}
        else{ DFS(root); System.out.println(answer);}
    }
    static void DFS(int num){
        visit[num]=true;
        int Node=0;
        for(int i : tree[num]){
            if(visit[i]==false && i != deleteNode){
                Node++;
                DFS(i);
            }
        }
        if(Node==0){
            answer++; //리프 노드 개수 ++
        }
    }
}
/*
제거 대상 노드를 만났을때 탐색중지
*/
