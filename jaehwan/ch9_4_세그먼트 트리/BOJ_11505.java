import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11505 {//[BOJ_11505]구간 곱 jaehwan solved - 인덱스 트리 사용
    static long[] tree;
    static int n;
    static int MOD=1_000_000_007;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        int change = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int size = treeSize();
        int leftSize=size/2-1;

        tree = new long[size+1];
        for(int i=0;i<tree.length;i++){
            tree[i]=1;
        }
        for(int i=leftSize+1;i<=leftSize+n;i++){
            tree[i]=Long.parseLong(br.readLine());
        }

        setTree(size-1);

        for(int i=0; i < change+k;i++) {
            st = new StringTokenizer(br.readLine());

            long a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());

            if (a == 1){ changeVal(leftSize + s, e); }//변경
            else if (a == 2) { //구간곱
                s = s + leftSize;
                e = e + leftSize;
                System.out.println(getMul(s, (int) e));
            } else {return;}
        }
        br.close();
    }

    private static long getMul(int s, int e) {
        long parMul =1;
        while(s<=e){
            if(s%2==1){
                parMul=parMul*tree[s]%MOD;
                s++;
            }
            if(e%2==0){
                parMul=parMul*tree[e]%MOD;
                e--;
            }
            s=s/2;
            e=e/2;
        }
        return parMul;
    }

    private static void changeVal(int index, long val) {
        tree[index]=val;
        while(index>1){
            index=index/2;
            tree[index] = tree[index*2] %MOD * tree[index*2+1]%MOD;
        }
    }
    private static void setTree(int i) {
        while(i!=1){
            tree[i/2]=tree[i/2] * tree[i] % MOD;
            i--;
        }
    }
    private static int treeSize() { //이진트리 크기 구하기
        int h = (int)Math.ceil(Math.log(n)/Math.log(2));
        return (int)Math.pow(2,h+1);
    }
}
