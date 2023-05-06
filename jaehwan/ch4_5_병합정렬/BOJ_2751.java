import java.io.IOException;
import java.util.*; 

public class BOJ_2751 {
    public static void main(String[] args) throws IOException {
        Scanner sc =new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> A=new ArrayList<>();
        int N =sc.nextInt();
        for(int i=0;i<N;i++){
            A.add(sc.nextInt());
        }
        Collections.sort(A);
        for(int value:A){
            sb.append(value).append('\n');
        }
            System.out.println(sb);
    }
}
//문제해설
//몇개의 수와 수의 배열이 한줄씩 주어졌을때 이를 정렬하는 프로그램이다.

//기본 sort는 시간초과가 떠서 
//리스트를 사용해 시간복잡도 nlogn을 보장하는 합병정렬 Collections.sort를 사용해서 풀었습니다.
