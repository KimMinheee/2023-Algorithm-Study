import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10868 { //[BOJ_10868]최솟값 찾기 jaehwan solved - 인덱스 트리 사용
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] tree;
    public static void main(String[] args) throws IOException {
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int treeH=0; //몇단으로 이루어진 트리인가?
        int treeL=N; //길이
        while (treeL !=0){
            treeL /=2;
            treeH++; //예제에선 4
        }
        //배열의 크기 = 2^(h+1) = 2^k*2
        //시작인덱스 = 2^k
        int treeSize= (int)Math.pow(2,treeH+1); //이진트리에서 높이가 h라면 필요한 배열의 크기는 2^(h+1) = 2^k*2
        int NodeStartIndexLeft = treeSize / 2 - 1 ; //채워야하는 원본 리프노드 값 시작점예제 기준 15
        tree=new long[treeSize+1];
        for(int i=0;i<tree.length;i++){
            tree[i] = Integer.MAX_VALUE;
        }
        //16부터 25까지
        for(int i=NodeStartIndexLeft+1; i <= NodeStartIndexLeft + N; i++){ //리프노드 입력
            tree[i]=Long.parseLong(br.readLine());
        }
        setTree(treeSize-1); //초기 트리 생성
        for(int i=0;i<M;i++){ //질의 
            st=new StringTokenizer(br.readLine());  // 1 10가 왔다 하면  
            int s=Integer.parseInt(st.nextToken()); // 1
            int e=Integer.parseInt(st.nextToken()); // 10
            s= s+NodeStartIndexLeft;                // 16 
            e= e+NodeStartIndexLeft;                // 25
            System.out.println(getMin(s,e));        // 16 25
        }
        br.close();
    }

    private static long getMin(int s, int e) { //16 25
        long Min= Long.MAX_VALUE; 
        while(s <= e){ 
            if(s%2==1){ //0 0 
                Min=Math.min(Min,tree[s]); //[1] = 5 
                s++;
            }
            s=s/2; //8 4 2 1 1
            if(e%2==0){ //1 0 0
                Min=Math.min(Min,tree[e]); //[12] = 5
                e--; // 11 1
            }
            e=e/2; //5 2 0
        }
        return Min; //5 
    }

    private static void setTree(int i) { //31
        while(i!=1){ //인덱스가 루트가 아닐때까지
            if(tree[i/2] > tree[i]){ // 현재값과 비교해서 현재 값이 더 작을때
                tree[i/2] = tree[i]; //해당 값을 부모노드에 저장하기
            }
            i--;
        }
    }
}
/*
10 4
75
30
100
38
50
51
52
20
81
5
1 10
* */
