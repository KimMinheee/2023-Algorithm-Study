package minhee.그리디.그리디알고리즘;

import java.io.*;
import java.util.*;

public class BOJ1541_잃어버린괄호 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split("-"); //55 50+40
        int answer = 0;
        for(int i=0;i<data.length;i++) {
            int sum = 0;
            String[] remain = data[i].split("\\+");
            for(int j=0;j<remain.length;j++) {
                sum += Integer.parseInt(remain[j]); //55, 90
            }
            if(i==0) { //맨 처음 값일때 -> 뺄 수 없음 무조건 더해야 한다.
                answer += sum;
            }else {
                answer -= sum;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
