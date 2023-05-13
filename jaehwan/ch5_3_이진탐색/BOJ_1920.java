import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1920 { //원하는 정수 찾기
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]= sc.nextInt();
        }
        Arrays.sort(a);
        int num= sc.nextInt();
        for(int i=0;i<num;i++){
            if(Search(a, sc.nextInt())>=0){
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
    }

    private static int Search(int[] a,int numData) { //이진탐색 O(logN)
        int start=0;
        int end = a.length-1;
        while (start<=end){
            int mid = (start+end)/2;
            if(a[mid] > numData){
                end=mid-1;
            }
            else if(a[mid]<numData){
                start=mid+1;
            }
            else{
                return 1;
            }
        }
        return -1;
    }
}
/*
문제분석
주어진 숫자를 주어진 데이터에서 있는 숫자인지 없는 숫자인지 판단하는 문제로 각 숫자가 존재하는 숫자인지 판단해야한다.


* 이진 탐색 메커니즘
1. 탐색 범위내의 배열의 중간인덱스를 구한다.
2. 중간 인덱스의 값과 key값을 비교한다.
3. 값이 중간 값보다 작다면 왼쪽 부분을, 값이 중간 보다 크다면 오른쪽 부분을 탐색하고, 같다면 해당 인덱스를 반환하고 종료한다.
* */
