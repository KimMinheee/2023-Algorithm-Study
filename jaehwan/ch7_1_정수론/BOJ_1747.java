import java.util.Scanner;

public class BOJ_1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] A = new int[10000001]; //10^6
        //처음 초기화
        for (int i = 2; i < A.length; i++) {
            A[i] = i;
        }
        //소수만 남기기
        for (int i = 2; i < Math.sqrt(A.length); i++) { //제곱근까지 계산하기
            if (A[i] == 0) {//0이면 패스
                continue;
            }
            for (int j = i + i; j < A.length; j = j + i) { //i배수 탐색
                A[j] = 0;//배수 지우기
            }
        }
        while(true){ //1씩 증가시키며 펠린드롬 수가 맞는지 체크
            if (A[n] != 0) { //0이외의 숫자가 들어있는 경우만
                int num=A[n];
                if(pelin(num)){
                    System.out.println(num); //맞으면 출력
                    break;
                }
            }
            n++;
        }
    }
    private static boolean pelin(int num) {
        char[] temp = String.valueOf(num).toCharArray();
        int start=0;
        int end=temp.length-1;
        while(start<end){
            if(temp[start] != temp[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
