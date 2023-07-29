import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1722 {//[BOJ_1722]순열순서 jaehwan solved
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static boolean[] visited = new boolean[21];
    static long[] f = new long[21];

    public static void main(String[] args) throws IOException {

        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());

        arr=new int[N];
        f[0]=1;

        for(int i=1; i<=20; i++) {
            f[i] = f[i-1] * i; //팩토리얼 가짓수 저장해놓음
        }
        // 2. 순열찾기
        if(Q == 1) { // K번째 순열 (최대 20! long으로 받음)
            long K = Long.parseLong(st.nextToken()); // N=4(1234~4321) 총24가지  K=12

            for(int i=0; i<N; i++) { // 팩토리얼 가짓수 치기
                for(int j=1; j<=N; j++) { // 1~N 확인
                    // 순열에 이미 존재하는 숫자면 넘어간다
                    if(visited[j]) continue;

                    // 팩토리얼 값이 k보다 작으면 k에서 팩토리얼 값을 빼준다
                    if(f[N-i-1] < K) K -= f[N-i-1];

                        // 팩토리얼 값이 k보다 크면 해당하는 원소의 숫자를 찾은 것.
                        // a[i]에 저장하고 순열에 존재하는 숫자를 체크해준다
                    else {
                        arr[i] = j; // 2 3 4 1
                        visited[j] = true;
                        break;
                    }
                }
            }

            // Answer
            for(int i=0; i<N; i++) System.out.print(arr[i]+" ");

        } else if (Q==2) {	 // 몇번째 순열
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            } // 2 4 1 3

            /*
             *   2 => 3! + (1)
             *   4 => 2! + 2! + (2 3)
             *   1 => 1!
             *   3 => 0
             */

            long ans = 1L;

            for(int i=0; i<N; i++) {
                for(int j=1; j<arr[i]; j++) {
                    // 1부터 해당하는 원소까지 팩토리얼 값을 늘려가며 더함
                    if(!visited[j]) {
                        ans += f[N-i-1];
                    }
                }
                // 순열에 존재하는 숫자는 있다고 표시
                visited[arr[i]] = true;
            }

            // Answer
            System.out.println(ans);

        }
    }
}
/*
4 입력값의 정렬
1 2 3 4, 1 2 4 3, ★1 3 2 4, 1 3 4 2, 1 4 2 3, 1 4 3 2...
* */
