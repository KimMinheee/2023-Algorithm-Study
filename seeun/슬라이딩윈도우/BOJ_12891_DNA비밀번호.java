package week1;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_12891_DNA비밀번호 {

    static private int[] dnaCnt;
    static private HashMap<String, Integer> hashMap;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); //DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken()); //부분 문자열 길이
        String str = br.readLine(); //DNA 문자열
        dnaCnt = new int[4]; //dna 각 알파벳 별 현재개수 저장배열, A C G T 차례로 저장
        hashMap = new HashMap<>(); //dna 각 알파벳 별 필요개수 저장 해시맵

        //각 알파벳에 해당하는 필요조건 대입
        st = new StringTokenizer(br.readLine());
        hashMap.put("A", Integer.parseInt(st.nextToken()));
        hashMap.put("C", Integer.parseInt(st.nextToken()));
        hashMap.put("G", Integer.parseInt(st.nextToken()));
        hashMap.put("T", Integer.parseInt(st.nextToken()));

        //범위 설정
        int ptr1 = 0;
        int ptr2 = P-1;
        int cnt = 0; //비밀번호 종류 수

        //처음 P만큼의 문자열 add
        for(int i=0; i<P; i++)
            add(str.charAt(i));

        //그 다음부터 이동하면서 P만큼 탐색
        while(ptr2 < S){

            //비밀번호로 선택할 수 있는지 체크
            if(isOkWithPassword()){
                cnt++;
            }

            delete(str.charAt(ptr1)); //왼쪽 끝 요소 개수에서 제거
            //포인터 업데이트
            ptr1++;
            ptr2++;
            if(ptr2 == S) //S범위 넘어갈 경우 끝내기
                break;
            add(str.charAt(ptr2)); //ptr+1 인덱스 요소 개수에 추가
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    //비밀번호 요건을 충족하는지 확인하는 메서드
    private static boolean isOkWithPassword() {
        if(dnaCnt[0] >= hashMap.get("A") && dnaCnt[1] >= hashMap.get("C") && dnaCnt[2] >= hashMap.get("G") && dnaCnt[3] >= hashMap.get("T"))
            return true;
        else return false;

    }

    //문자 c의 개수를 현재개수 저장배열에서 +1해주는 메서드
    private static void add(char c){
        if(c == 'A')
            dnaCnt[0]++;
        else if(c == 'C')
            dnaCnt[1]++;
        else if(c == 'G')
            dnaCnt[2]++;
        else if(c == 'T')
            dnaCnt[3]++;
    }

    //문자 c의 개수를 현재개수 저장배열에서 -1해주는 메서드
    private static void delete(char c){
        if(c == 'A')
            dnaCnt[0]--;
        else if(c == 'C')
            dnaCnt[1]--;
        else if(c == 'G')
            dnaCnt[2]--;
        else if(c == 'T')
            dnaCnt[3]--;
    }

}
