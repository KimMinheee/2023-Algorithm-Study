import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_14501 {//[BOJ_14501]퇴사 jaehwan solved - dp 사용
    static int N;
    static int[] D;//i번째 날부터 퇴사일까지 벌 수 있는 최대 수입
    static int[] T;//상담일자
    static int[] P;//비용
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();//퇴사날
        D=new int[N+2];//날짜별 최대 수입
        T=new int[N+1];//시간
        P=new int[N+1];//비용

        for(int i=1;i<=N;i++) { //값 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i]=Integer.parseInt(st.nextToken());
            P[i]=Integer.parseInt(st.nextToken());
        }
        /* 3 | 5 | 1 | 1 | 2 | 4 | 2 
           10| 20| 10| 20| 15| 40|200 
        */        
        for(int i=N; i>0; i--){ 
            if(i+T[i] > N + 1){//i번째 상담일을 퇴사일까지 끝낼 수 없을때 
                D[i]=D[i+1]; //i+1일 ~ 퇴사일에 벌 수 있는 최대 수입
            }
            else{
                D[i]=Math.max(D[i+1], P[i]+D[i+T[i]]);//
                //상담 가능 한경우 i+1일 ~ 퇴사일에 벌 수 있는 최대 수입 & i번째 상담 비용 
                //+ i번째 상담이 끝난 다음날부터 퇴사일까지의 최대 수입 비교
            }
        }
        System.out.println(D[1]);//첫번째 날부터 세야하니까
    }
}
/*
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200
*/
