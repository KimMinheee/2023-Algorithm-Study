import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1517 {
    static int a[];
    public static long merge_sort(int start, int end) {
        if (start == end) {//처음과 끝이 같아질때까지 배열을 반으로 나눔(정렬할 부분 배열의 크기가 1인경우)
            return 0;
        }
        int mid = (start + end) / 2;
        long num = merge_sort(start, mid) + merge_sort(mid + 1, end); //출력할것 반 짤린것과 나머지 반 짤린거 더한
        int[] tmp = new int[a.length]; //정렬할때 잠시 사용

        int i = start;
        int j = mid + 1;
        int k = 0; //실제 a배열에서 어느위치에 데이트가 들어가야 하는지 나타내주는 변수
        while (i <= mid || j <= end) { //두 그룹을 병합하는 로직
            if (i <= mid && (j > end || a[i] <= a[j])) { //시작점이 중간보다 작고 끝지점이 엔드보다 크거나 배열 a[시작점]이 a[끝지점]보다 작거나 같은=ㄹ때
                tmp[k++] = a[i++];//임시 배열 k인덱스에 a[시작점++]배열을 옮겨 담음
            } else {//변경이 일어나는 경우
                num += (mid - i + 1); //두번째 그룹의 숫자가 들어갈때 첫번째 그룹의 원소 개수를 정답에 추가
                tmp[k++] = a[j++];
            }
        }
        for (int q = start; q <= end; q++) {
            a[q] = tmp[q - start]; //반복문이 끝날때 임시배열 tmp를 다시 배열 a에 복사
        }
        return num;
    } 
    //기존 재귀를 사용한 병합 정렬 알고리즘에서 두번째 그룹의 숫자를 tmp라는 배열에 담을때 첫번째 그룹의 원소 개수를 정답에 추가해주었다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int n = Integer.valueOf(br.readLine()); //몇개인지 입력받음
        a = new int[n];
        String st[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.valueOf(st[i]);
        }
        System.out.println(merge_sort(0, n - 1));
    }
}
/*문제 해설
특정 수열에서 버틀 정렬을 할 때 swap이 총 몇번 발생하는지 알아내는 프로그램

문제 풀이
해결 아이디어가 중요한 문제이다.
N의 최대 범위가 500,000이므로 버블 소트를 바로 사용할시 제한시간을 초과 nlogn으로 풀어야함
버블 정렬의 swap을 나타내는데 시간복잡도는 nlogn이 필요함 -> 아이디어 필요 -> 병합 정렬이 필요함
병합 정렬의 과정에서 swap이 포함되어 있다는 사실을 떠올려야함
버블은 정렬위치로 가기 위해서는 무조건 한번에 1칸만 이동이 가능하다 -> 앞에 있는 개수만큼 swap이 일어남
*/
