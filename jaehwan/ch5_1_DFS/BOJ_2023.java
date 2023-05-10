import java.util.Scanner;

public class BOJ_2023 {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }
    static void DFS(int num, int cnt) {//숫자,자릿수
        if (cnt == n) {//자릿수 같으면 소수 판별
            if (isPrime(num)) { System.out.println(num); }
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) { continue; }//뒤에 붙을수가 2의 배수면 패스
            if (isPrime(num * 10 + i)) {//자리수가 같지 않다고 판별했기 때문에 자리수 늘림
                DFS(num * 10 + i, cnt + 1);
            }
        }
    }
    private static boolean isPrime(int num) { //소수판별하기
        for (int i = 2; i*i <= num; i++) {//시간복잡도 O(n^(1/2))
            //제곱근을 기준으로 앞에서 약수가 있다면 뒤에 반드시있다.
            //반대로 제곱근까지 계산했을때 약수가 안나왔다면 뒤에서도 안나온다.
            if (num % i == 0) { return false; }
        }
        return true;
    }
}
/*
문제해설 
소수를 좋아하는 이상한 친구가, 특정 자리수의 수 중에 왼쪽부터 한자리씩 더해가며 특정 숫자를 봤을때 모든 자리수가 소수인 수를 찾는 문제

문제풀이
소수 = 1과 자기자신만으로 나뉘는 수이다 그래서 첫 시작 숫자는 항상 2,3,5,7로 고정이된다.
그리고 두번째로 추가되는 자리부터는 2로 나뉘는 숫자들을 제거해 또한번 시간복잡도를 줄인다.
1,3,5,7,9번 숫자를 순서대로 탐색하며 정해진 자리수까지 늘린다음 나오면서 다시 반복한다. 이러한 작동방식에서 DFS를 떠올릴수 있어야한다.
소수를 판별하기위한 소수 판별법과 가지치기를 통한 시간 복잡도 줄이기 필요하다.
소수는 제곱근까지 계산했을때 약수가 안나왔다면 뒤에서도 안나온다는 개념을 사용해 시간복잡도를 더 줄일 수 있다.
*/
