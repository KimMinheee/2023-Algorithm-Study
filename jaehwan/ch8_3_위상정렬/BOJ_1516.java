import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1516 {
    static ArrayList<ArrayList<Integer>> A;//다차원
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        A=new ArrayList<>();//리스트구현
        int N = Integer.parseInt(br.readLine()); //건물
        for(int i=0;i<=N;i++){//인접리스트 초기화 건물 개수만큼
            A.add(new ArrayList<>());
        }
        int[] indegree=new int[N+1];//진입 차수 배열
        int[] self=new int[N+1]; //마지막에 자신값 더함
        for(int i=1;i<=N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            self[i]=Integer.parseInt(st.nextToken()); //맨처음 값은 자기 자신 배열로 저장
            while(true){
                int preTemp=Integer.parseInt(st.nextToken());//토큰 값을 -1까지 읽어옴
                if(preTemp== -1){
                    break;
                }
                A.get(preTemp).add(i); //인접리스트 i에 읽어온 토큰 노드 기록
                indegree[i]++; //진입차수 ++
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(indegree[i]==0){ //0인거 체크해서 집어넣음
                queue.offer(i);
            }
        }
        int[] result=new int[N+1];
        while(!queue.isEmpty()){
            int now=queue.poll();
            for(int next: A.get(now)){
                indegree[next]--;
                result[next]=Math.max(result[next],result[now]+self[now]);
                if(indegree[next]==0){
                    queue.offer(next);
                }
            }
        }
        for(int i=1;i<=N;i++){
            bw.write(result[i]+self[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
/*
건물을 노드라고 했을때 노드간의 순서가 존재하고 이를 정렬 -> 위상 정렬
*/
