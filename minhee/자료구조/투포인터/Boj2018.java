package minhee.자료구조.투포인터;

import java.io.*;

public class Boj2018 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(getAnswer(num)));
        bw.flush();
        bw.close();
        br.close();
    }
    static int getAnswer(int num){
        int start = 1;
        int end = 1;
        int sum = 1;
        int answer = 1;

        while(start != num){
            if(sum == num){
                answer++;
                end++;
                sum+=end;
            }
            else if(sum < num){
                end++;
                sum += end;
            }
            else{
                sum -= start;
                start++;
            }
        }

        return answer;
    }
}
