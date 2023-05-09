import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        Scanner sc =new Scanner(System.in);
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st =new StringTokenizer(bf.readLine()," ");

        int[] arr=new int[N];

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum=0;
        int pre=0;
        for(int i=0;i<N;i++){
            sum+=pre+arr[i];
            pre+=arr[i];
        }
        System.out.println(sum);
    }
}
 
