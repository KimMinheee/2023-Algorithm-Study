package minhee.정수론.소수구하기;

import java.io.*;

public class Boj1747_소수팰린드롬 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] primeNums = new int[10000001]; //N보다 크거나 같음.

        for(int i=2; i<=Math.sqrt(primeNums.length); i++){ //에라토스테네스체
            if(primeNums[i] == 0){ //소수인 경우
                for(int j=i*i; j<primeNums.length; j=j+i){
                    primeNums[j] = 1;
                }
            }
        }
        for(int i=N; i<=primeNums.length; i++){
            if(primeNums[i] == 0 && i>1){
                if(isPalindrome(i)) {
                    System.out.println(i);
                    break;
                }
            }
        }
        br.close();

    }
    static boolean isPalindrome(int num){
        boolean isPalindrome = true;
        char[] charNums = String.valueOf(num).toCharArray();

        int start = 0;
        int end = charNums.length-1;
        while(start <= end){
            if(charNums[start] == charNums[end]){
                start++;
                end--;
            }
            else return false;
        }


        return isPalindrome;
    }
}
