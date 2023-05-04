import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17298 { //오큰수 구하기 (오른쪽 큰수)
    public static void main(String[] args) throws IOException {
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack =new Stack<>();
        int n = Integer.parseInt(bf.readLine()); //배열수 입력받기
        int[] A = new int[n]; // 수열을 받을 배열
        int[] result=new int[n]; //정답으로 다시 채울 배열

        String[] number = bf.readLine().split(" "); //스트링 배열 선언 공백기준 나눠 받음
        for (int i=0;i<n;i++){
            A[i]=Integer.parseInt(number[i]);
        }
        stack.push(0); //비어있는걸 기준으로 하기 때문에 초기화 필요함
        for(int i=1;i<n;i++){
            //스택이 비어있지 않고 현재 원소가 스택의 맨위 원소보다 큰경우 해당
            //조건을 만족할 떄 까지 stack의 원소를 pop하면서 해당 인덱스의 값을 현재와 바꿈
            while (!stack.isEmpty() && A[stack.peek()]<A[i]){
                result[stack.pop()]=A[i];
            }
            stack.push(i); //신규 데이터
        }
        while (!stack.isEmpty()){ //
            result[stack.pop()] = -1; //스택이 비어있지 않다면 빌때까지 스택에 쌓인 INDEX를 -1로 초기화(남아있는거 -1처리)
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);

    }
}
/*
* 문제 해설
* 수열의 크기를 입력하고 두번째 줄에 수열을 입력하면 출력 결과가 각 수열의 인덱스에 따른 오큰수값으로 자리해 출력되어야 한다.
*
* 문제 풀이
* 스택에 들어 오는 수가 top에 존재하는 수보다 크면 그 수가 오큰수이다
* 옆으로 검사해가면서 가장 먼저 큰 값을 발견하면 저장하고 넘어감.
* 스택을 활용하는 이유는 들어온 값을 바로 꺼내 쓸 수 있기 때문
**/
