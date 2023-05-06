import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_1427 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        Integer A[] =new Integer[str.length()];
        for(int i=0;i<str.length();i++){
            A[i] =Integer.parseInt(str.substring(i,i+1));
        }
        Arrays.sort(A, Collections.reverseOrder()); //내림차순으로 할건데 객체타입이어야
        for(int i=0;i<str.length();i++){
            System.out.print(A[i]);
        }
    }
}
//문제 해설 선택 정렬을 사용해서 일자로 주어진 숫자를 정렬하는 문제이다.
//String  값으로 받아서 substring으로 나눈다음 내림차순 sort 해버리면 풀린다
