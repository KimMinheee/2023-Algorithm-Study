import java.util.Scanner;

public class BOJ_1456 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long Min = sc.nextLong(); //시작
    long Max = sc.nextLong(); //끝
    int count = 0; //거의 소수 찾기
    long[] A = new long[10000001]; //10^7
    //처음 초기화
    for (int i = 2; i < A.length; i++) {
      A[i] = i; 
    }
    //소수만 남기기
    for (int i = 2; i <= Math.sqrt(A.length); i++) { //제곱근까지 계산하기
      if (A[i] == 0) {//0이면 패스
        continue;
      }
      for (int j = i + i; j < A.length; j = j + i) { //i배수 탐색
        A[j] = 0;//배수 지우기
      }
    }
    for (int i = 2; i < 10000001; i++) {
      if (A[i] != 0) { //0이외의 숫자가 들어있는 경우만
        long temp = A[i]; // 
        while ((double)A[i] <= (double)Max/(double)temp) { //long형 넘어가지 않게 조절해주기
          if ((double)A[i] >= (double)Min/(double)temp ) { //시작 값보다 큰지 계산해서 체크
            count++;
          }
          temp = temp * A[i];
        }
      }
    }
    System.out.println(count);
  }
}
/*
문제 해설 
주어진 문제에서 10^14승 이라고 하는데 제곱근인 10^7승까지 계산해줘야한다 long형식을 넘어가는 숫자를 방지하기 위해 끝 값보다 작은지 판단해줄때 식을 작게 나눠준다.
*/
