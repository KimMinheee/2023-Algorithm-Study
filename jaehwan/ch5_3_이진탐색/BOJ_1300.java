import java.util.Scanner;

public class BOJ_1300 { // 배열에서 k번째 수 찾기
    static int n,k;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        k=sc.nextInt();
        System.out.println(binarySearch());
    }
    public static int binarySearch() {
        int start=1;
        int end=k;
        int mid=0;
        while (start <= end){
            mid = (start+end)/2;
            int count =0; //k랑 같거나 작은 수들의 개수
            for(int i=1;i<=n;i++){
                count+=Math.min(mid/i,n);
            }
            if(count < k)
                start=mid+1;
            else end=mid-1;
        }
        return start;
    }
}
// 이중배열 만들어서 해보려다가 실패한 문제 ㅠ 시간초광 걸린다 컬랙션 솔트로 바꿔서 해봐도 마찬가지
