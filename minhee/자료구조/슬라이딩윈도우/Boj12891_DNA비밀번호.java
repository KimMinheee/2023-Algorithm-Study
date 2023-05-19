package minhee.자료구조.슬라이딩윈도우;

import java.io.*;
import java.util.*;

/**
 * BOJ12891 - DNA 비밀번호
 */
public class Boj12891_DNA비밀번호 {
    static int S;
    static int P;
    static int[] minimums;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        minimums = new int[4];

        String data =  br.readLine();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){ //A,C,G,T 순서는 보장
            minimums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getTotalAnswer(data));
        br.close();

    }
    static int getTotalAnswer(String data) {
        char[] charArr = data.toCharArray();
        int[] counts = new int[4];//A,C,G,T 횟수 저장
        int answer = 0;

        for (int a = 0; a <= S - P; a++) {
            if(a == 0){
                for (int b = a; b < a + P; b++){
                    //처음
                    if(charArr[b] == 'A') counts[0] += 1;
                    else if(charArr[b] == 'C') counts[1] += 1;
                    else if(charArr[b] == 'G') counts[2] += 1;
                    else if(charArr[b] == 'T') counts[3] += 1;
                }
            }
            else{
                //앞에 꺼 삭제
                if(charArr[a-1] == 'A') counts[0] -= 1;
                else if(charArr[a-1] == 'C') counts[1] -= 1;
                else if(charArr[a-1] == 'G') counts[2] -= 1;
                else if(charArr[a-1] == 'T') counts[3] -= 1;

                //뒤에꺼 추가
                if(charArr[a+P-1] == 'A') counts[0] += 1;
                else if(charArr[a+P-1] == 'C') counts[1] += 1;
                else if(charArr[a+P-1] == 'G') counts[2] += 1;
                else if(charArr[a+P-1] == 'T') counts[3] += 1;
            }
            boolean isUsable = true;
            for(int i=0; i<4; i++){ //최소 A,C,G,T와 이상인지 비교
                if(counts[i] < minimums[i]){
                    isUsable = false;
                    break;
                }
            }
            if(isUsable) answer++;

        }
        return answer;
    }


}
