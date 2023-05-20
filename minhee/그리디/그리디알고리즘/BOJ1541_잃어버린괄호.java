package minhee.그리디.그리디알고리즘;

import java.io.*;
import java.util.*;

public class BOJ1541_잃어버린괄호 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split("-");
        int answer = 0;
        for(int i=0;i<data.length;i++) {
            int sum = 0;
            String[] remain = data[i].split("\\+");
            for(int j=0;j<remain.length;j++) {
                sum += Integer.parseInt(remain[j]);
            }
            if(i==0) {
                answer += sum;
            }else {
                answer -= sum;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
