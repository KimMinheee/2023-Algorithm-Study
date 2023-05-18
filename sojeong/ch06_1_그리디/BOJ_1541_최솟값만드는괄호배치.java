package ch06_1_그리디;

import java.util.Scanner;

public class BOJ_1541_최솟값만드는괄호배치 {

    static int ans = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String[] str = data.split("-");
        for (int i = 0; i < str.length; i++) {
            int temp = mySum(str[i]);
            if (i == 0) {
                ans += temp; // 문자열 가장 앞에 있는 값 더함
            } else {
                ans -= temp; // 그 이후부터 플러스 연산한 값들은 빼줌
            }
        }
        System.out.println(ans);
    }

    static int mySum(String a) {
        int sum = 0;
        String temp[] = a.split("[+]");
        for (int k = 0; k < temp.length; k++) {
            sum += Integer.parseInt(temp[k]);
        }
        return sum;
    }
}
