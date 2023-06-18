package minhee.정수론.확장유클리드호제법;


import java.util.Scanner;

public class Boj21568_확장유클리드 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        int[] result = extendedEuclidean(A, B);

        if (C % result[0] != 0) {
            System.out.println("-1");
        } else {
            int x = result[1] * (C / result[0]); //배수
            int y = result[2] * (C / result[0]); //배수
            System.out.println(x + " " + y);
        }
    }

    // 확장 유클리드 호제법을 사용하여 최대공약수와 그에 해당하는 x, y 계수를 구하는 함수
    public static int[] extendedEuclidean(int a, int b) {
        if (b == 0) {
            return new int[] { a, 1, 0 };
        }

        int[] result = extendedEuclidean(b, a % b);
        int gcd = result[0];
        int x = result[2];
        int y = result[1] - (a / b) * result[2];
        return new int[] { gcd, x, y };
    }
}