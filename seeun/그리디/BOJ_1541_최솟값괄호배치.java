import java.io.*;

public class BOJ_1541_최솟값괄호배치 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //-로 식을 나누어주어서 첫번째 숫자(그룹)만 더하고 나머지는 빼기
        String[] cal = (br.readLine()).split("-");
        
        int rslt = makeSum(cal[0]); //첫번째 수(그룹) 더해주기
        int len = cal.length;
        for (int i = 1; i < len; i++) {
            int subSum = makeSum(cal[i]);
            rslt -= subSum;
        }

        bw.write(rslt + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int makeSum(String str) {
        int sum = 0;
        String[] calStr = (str).split("\\+"); //정규식에서 사용되는 +과 혼용방지 위해서 escape
        int len = calStr.length;
        for(int j=0; j<len; j++){
            sum += Integer.parseInt(calStr[j]);
        }
        return sum;
    }
}
