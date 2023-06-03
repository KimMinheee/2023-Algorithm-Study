package week6;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_21568_방정식해찾기 {

    static ArrayList<Integer> val;
    static int ansX;
    static int ansY;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        val = new ArrayList<>();

        int gcd = getRslt(a, b);

        if(c % gcd != 0) bw.write("-1");
        else {
            getSol(1, 0, val.size()-1);
            bw.write(ansX * (c/gcd) + " " + ansY * (c/gcd)); //업데이트 된 x와 y에 c에 최대공약수가 곱해진 만큼 똑같이 곱해줌
        }
        bw.flush();
        bw.close();
        br.close();
        
    }

    public static int getRslt(int n1, int n2) {
        if(n2 == 0) return n1;
        else{
            int cal = n1/n2;
            val.add(cal); //몫 저장
            return getRslt(n2, n1 % n2);
        }
    }

    //유클리드 호제법의 몫이 저장되는 리스트의 인덱스와 x값, y값을 가지고 방정식의 정수해를 찾는 함수
    public static void getSol(int x, int y, int idx) {

        if (idx < 0) { //역순으로 시작 인덱스까지 탐색 완료되었다면 재귀 종료
            ansX = x;
            ansY = y;
            return;
        }
        int newX = y;
        int newY = x - (y * val.get(idx--));
        getSol(newX, newY, idx);
        
        
    }
}
