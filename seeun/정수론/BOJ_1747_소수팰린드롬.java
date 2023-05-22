import java.io.*;
import java.util.ArrayList;

public class BOJ_1747_소수팰린드롬 {

    static int Max = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[Max + 1]; //소수 후보들 체킹배열, n최대까지 저장
        ArrayList<Integer> arr = new ArrayList<>();
        //배열에 소수 먼저 구해놓기, n최대인 1000000 그 이상의 소수까지 저장해야함
        for(int i=2; i<=Max; i++){
            if(!check[i]){
                arr.add(i); //소수만 넣기
                for(int j=i; j<=Max; j+=i) //배수들 모두 소수불가 하므로 true처리
                    check[j] = true;
            }
        }

        //arr 배열 요소를 n이하에 해당하는 요소까지 넘겨주기
        for (int i=0; i < arr.size(); i++) {
            if(n<=arr.get(i)){ //n보다 크거나 작은 요소까지 왔다면
                if(ispalindrome(arr.get(i))){ //해당 요소가 팰린드롬이라면 바로 break
                    bw.write(arr.get(i) + "\n");
                    bw.flush();
                    break;
                }
            }
        }
        br.close();
        bw.close();
    }

    public static boolean ispalindrome(int n) {
        String str = String.valueOf(n);
        int len = str.length();
        for (int i = 0; i < len/2; i++) { //중앙 인덱스 전까지 탐색하면서 양쪽 인덱스 서로 같지 않다면 바로 false
            if(!str.substring(i, i+1).equals(str.substring(len-i-1, len-i)))
                return false;
        }
        return true;
    }
}
