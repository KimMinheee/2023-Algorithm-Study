package minhee.그래프.그래프의표현;

import java.io.*;
import java.util.*;

/**
 * 최단 거리 번호 리스트(정답) , 연결 정보 저장 리스트, boolean[] visit, 최단 거리 갱신 배열
 */

public class Boj18352_특정거리의도시찾기 {
    static int N,M,K,X; // 도시의 개수, 도로의 개수, 거리 정보, 출발 도시 정보
    static List<List<Integer>> connects = new ArrayList<>();
    static List<Integer> answerList = new ArrayList<>();
    static boolean[] visit;
    static int[] tmpAnswer;
    static int MAX = (int) 1e10;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++){
            connects.add(new ArrayList<>());
        }
        visit = new boolean[N+1];
        tmpAnswer = new int[N+1];


        //연결 정보 저장
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start  = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            connects.get(start).add(end);
        }

        setTmpAnswer(); //출발지점 - 0, 나머지 지점 모두 MAX로 초기화

        findShortestWays(); //최단 거리

        if(answerList.isEmpty()) bw.write("-1");
        else{
            Collections.sort(answerList);
            for(int num : answerList){
                bw.write(String.valueOf(num)+"\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
    static void findShortestWays(){
        //시작지점 X부터 탐색 시작
        visit[X] = true;
        Queue<Integer> que = new LinkedList<>();
        que.add(X);

        while(!que.isEmpty()){
            Integer city = que.poll();
            if(tmpAnswer[city] > K) return; //K보다 큰 수가 나온다면 더 볼 필요가 없음.

            for(Integer go : connects.get(city)){
                if(!visit[go]){
                    visit[go] = true;
                    tmpAnswer[go] = 1 + tmpAnswer[city];
                    if(tmpAnswer[go] == K) answerList.add(go);
                    que.add(go);
                }
            }
        }
    }

    static void setTmpAnswer(){ //출발지점 - 0, 나머지 지점 모두 MAX로 초기화
        for(int i=1; i<=N; i++){
            if(i == X) tmpAnswer[i] = 0;
            else tmpAnswer[i] = MAX;
        }
    }
}
