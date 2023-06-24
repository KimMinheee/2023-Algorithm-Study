import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11657 { //[BOJ_11657]타임머신 jaehwan solved - 벨만포드 사용
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,M;
    static long distance[];
    static Edge edges[];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        edges=new Edge[M+1];
        distance=new long[N+1];
        Arrays.fill(distance,Integer.MAX_VALUE);//최대한 큰수로 채움
        for(int i=0;i<M;i++){//에지 리스트 배열에 정보 저장
            st=new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int time=Integer.parseInt(st.nextToken());
            edges[i]=new Edge(start,end,time);
        }
        distance[1]=0; //시작점 0으로 초기화
        for(int i=1;i<N;i++){ //n-1만큼
            for(int j=0; j<M; j++){//n만큼
                Edge edge=edges[j]; //현재 에지 데이터 가져옴
                //출발 노드가 무한대가 아니라 종료 노드값 > 출발 노드값 + 에지 가중치 일때 거리 배열 업데이트
                if(distance[edge.start]!= Integer.MAX_VALUE && distance[edge.end]>distance[edge.start]+edge.time){
                    distance[edge.end]=distance[edge.start]+edge.time;
                }
            }
        }
        boolean mCycle=false;
        for(int i=0;i< M;i++){ //음수사이클이 있는지 확인하기
            Edge edge =edges[i];
            if(distance[edge.start]!= Integer.MAX_VALUE && distance[edge.end]>distance[edge.start]+edge.time){
                mCycle=true;
            }
        }
        if(!mCycle){
            for(int i=2;i<=N;i++){
                if(distance[i]==Integer.MAX_VALUE){bw.write("-1\n");}//이어지는 에지 없음
                else {bw.write(distance[i]+"\n");}
            }
        }
        else{
            bw.write("-1\n");
        }
        bw.flush();
        bw.close();
    }
}
class Edge {
    int start,end,time;
    public Edge(int start,int end,int time){
        this.start=start;
        this.end=end;
        this.time=time;
    }
}
/*
음수일 경우를 찾는 벨만포드를 구현하는 문제
*/
