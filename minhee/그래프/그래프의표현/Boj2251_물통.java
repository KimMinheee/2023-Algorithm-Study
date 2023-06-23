package minhee.그래프.그래프의표현;

import java.io.*;
import java.util.*;

public class Boj2251_물통 {
    static int[] abc = new int[3];
    static TreeSet<Integer> answer = new TreeSet<>(); //정답 넣을 hashSet
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<3; i++){
            abc[i] = Integer.parseInt(st.nextToken());
        }

        bfs();

        for(int answer : answer){
            sb.append(answer).append(" ");
        }
        System.out.println(sb.toString());
        br.close();
    }
    static void bfs(){
        Queue<Round> que = new LinkedList<>();
        boolean[] visit = new boolean[6];
        int[] tmp = new int[3];
        tmp[2] = abc[2];
        que.add(new Round(visit, tmp));

        while(!que.isEmpty()){
            Round round = que.poll();
            if(round.tmp[0] == 0) answer.add(round.tmp[2]);

            for(int i=0; i<6; i++){ //A채우기, A털기, B채우기, B털기, C채우기, C털기
                boolean[] copyVisit = round.visit.clone();
                int[] copyTmp = round.tmp.clone();

                if(!copyVisit[i]){ //하지 않은 연산 일 때
                    if(i==0){//A채우기
                        copyVisit[0] = true;
                        for(int j=0; j<3; j++){
                            if(copyTmp[j] >= abc[0]-copyTmp[0]){
                                copyTmp[j] = copyTmp[j] - (abc[0] - copyTmp[0]);
                                copyTmp[0] = abc[0];
                                //System.out.println(i+":"+Arrays.toString(copyTmp));
                                que.add(new Round(copyVisit, copyTmp));
                            }
                        }
                    }
                    else if(i==1){ //A털기
                        copyVisit[1] = true;
                        for(int j=0; j<3; j++){
                            if(abc[j]-copyTmp[j] >= copyTmp[0] && j!=0){
                                copyTmp[j] = copyTmp[j] + copyTmp[0];
                                copyTmp[0] = 0;
                                //System.out.println(i+":"+Arrays.toString(copyTmp)+"ㅗ");
                                que.add(new Round(copyVisit, copyTmp));
                            }
                        }
                    }
                    else if(i==2){ //B채우기
                        copyVisit[2] = true; //연산
                        for(int j=0; j<3; j++){
                            if(copyTmp[j] >= abc[1]-copyTmp[1]){
                                copyTmp[j] = copyTmp[j] - (abc[1] - copyTmp[1]);
                                copyTmp[1] = abc[1];
                                //System.out.println(i+":"+Arrays.toString(copyTmp));
                                que.add(new Round(copyVisit, copyTmp));
                            }
                        }
                    }
                    else if(i==3){ //B털기
                        copyVisit[3] = true;
                        for(int j=0; j<3; j++){
                            if(abc[j]-copyTmp[j] >= copyTmp[1]&& j!=1){
                                copyTmp[j] = copyTmp[j] + copyTmp[1];
                                copyTmp[1] = 0;
                                //System.out.println(i+":"+Arrays.toString(copyTmp));
                                que.add(new Round(copyVisit, copyTmp));
                            }
                        }
                    }
                    else if(i==4){//C채우기
                        copyVisit[4] = true; //연산
                        for(int j=0; j<3; j++){
                            if(copyTmp[j] >= abc[2]-copyTmp[2]){
                                copyTmp[j] = copyTmp[j] - (abc[2] - copyTmp[2]);
                                copyTmp[2] = abc[2];
                                //System.out.println(i+":"+Arrays.toString(copyTmp));
                                que.add(new Round(copyVisit, copyTmp));
                            }
                        }
                    }
                    else{
                        copyVisit[5] = true;
                        for(int j=0; j<3; j++){
                            if(abc[j]-copyTmp[j] >= copyTmp[2] && j!=2){
                                copyTmp[j] = copyTmp[j] + copyTmp[2];
                                copyTmp[2] = 0;
                                //System.out.println(i+":"+Arrays.toString(copyTmp));
                                que.add(new Round(copyVisit, copyTmp));
                            }
                        }
                    }
                }
            }
        }
    }
}

class Round{
    boolean[] visit; //연산
    int[] tmp;

    public Round( boolean[] visit, int[] tmp){
        this.visit = visit;
        this.tmp = tmp;
    }
}