import java.util.Scanner;

public class BOJ_1541 {
    static String A;
    static String[] st;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        A = sc.nextLine();
        st = A.split("-"); // -기준으로 자름
        int firstSum=0;
        firstSum += mSum(st[0]); //첫번째 자리는 방법 없으므로 따로 처리
        int answer=0;
        for(int i=1;i<st.length;i++){
            int sum = mSum(st[i]);
            answer= answer-sum;
        }
        answer+=firstSum;
        System.out.println(answer);
    }
    public static int mSum(String a) {
        int sum=0;
        String[] pString = a.split("[+]");
        for(int i=0;i<pString.length;i++){
            sum+=Integer.parseInt(pString[i]);
        }
        return sum;
    }
}
/*
문제해설 
+-를 이용한 연산더미에서 ()를 사용해 최소값을 만들어라
문제 풀이
-기준으로 +연산을 묶으라는 이야기구나라고 떠올라서 -를 기준으로 나눠 +구간에 있는 수들을 int로 바꿔서 더해주고 리턴시켜 더해줬다.
*/
