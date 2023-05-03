package week2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164_카드게임 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++){
            q.add(i);
        }

        int rm;
        while(true){
            rm = q.remove();
            if(q.isEmpty()) {
                break;
            }
            int val = q.remove();
            q.add(val);
        }
        bw.write(rm + "\n");
        bw.flush();
        bw.close();
    }
}
