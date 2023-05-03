import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11004 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N,K;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());

        tokens = new StringTokenizer(input.readLine());
        byObjectArray(tokens);
    }

    private static void byObjectArray(StringTokenizer tokens) {
        Integer[] nums= new Integer[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.valueOf(tokens.nextToken());
        }
        Arrays.sort(nums);
        System.out.println(nums[K-1]); //인덱스 값이라 -1
    }
}
/*문제 해설 
N개의 수를 정렬하고 K번째 수를 구하라는 직관적인 문제이다.
 문제 풀이
이 문제는 N의 값을 굉장히 크게 잡아놓아 시간복잡도가 N^2이상인 경우 풀리지가 않는다.
NlogN의 경우 1.5억이라는 값으로 2초안에 연산이 가능해 풀리는데 일반적으로 사용하는 Array.sort의 경우 
최대 시간복잡도가 N^2이다. 퀵정렬을 사용하도록 유도한 문제지만 Mergesort를 사용하면 NlogN으로 간단히 풀이가 가능하다.
*/
