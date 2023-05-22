package ch07_1_정수론;

import java.util.Scanner;

public class BOJ_1456_거의소수 {
    static long A, B;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextLong();
        B = sc.nextLong();
        int[] number = new int[(int)Math.ceil(Math.sqrt(B))+1];
        long count=0;
        for(int i=2; i<=number.length-1; i++) {
            number[i]= i;
        }
        primeNumber(number);
        for(int i=2; i <= Math.sqrt(B); i++) {
            for(int square=2; square<=Math.log(B)/Math.log(i); square++) {
                if(number[i] != 0) {
                    long num = (long)Math.pow(i,square);
                    if(num >= A && num <= B) count++;
                }
            }
        }
        System.out.println(count);
    }
    public static void primeNumber(int[] number) {
        for(int i=2; i<Math.sqrt(B); i++){
            for(int j=2*i; j<=number.length-1; j = j+i) {
                if(number[j] == 0) {
                    continue;
                }
                number[j] =0;
            }
        }
    }
}