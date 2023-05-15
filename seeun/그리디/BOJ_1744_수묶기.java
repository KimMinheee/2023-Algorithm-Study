import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_1744_수묶기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pqDesc = new PriorityQueue<>(Collections.reverseOrder()); //내림차순 정렬(양수저장)
        PriorityQueue<Integer> pqAsc = new PriorityQueue<>(); //오름차순 정렬(음수저장)

        int n = Integer.parseInt(br.readLine());
        int one = 0; //1개수
        int zero = 0; //0개수
        int rslt = 0; //정답

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            //음수는 오름차순 우선순위큐에 저장
            if(val<0){
                pqAsc.add(val);
            }
            //1 이상 양수는 내림차순 우선순위큐에 저장
            else if(val > 1){
                pqDesc.add(val);
            }
            //1과 0 개수 저장
            else if(val == 1){
                one++;
            }
            else{
                zero++;
            }
        }

        int mul = 0;
        // 양수끼리 곱
        while (pqDesc.size()>1) {
            mul = pqDesc.poll() * pqDesc.poll(); //두개 뽑기
            rslt += mul;
        }
        //하나 남은 양수
        if(!pqDesc.isEmpty())
            rslt += pqDesc.poll(); //마지막 양수 더해주기

        // 음수끼리 곱
        while (pqAsc.size()>1) {
            mul = pqAsc.poll() * pqAsc.poll();
            rslt += mul;
        }

        //하나 남은 음수
        if(!pqAsc.isEmpty()){
            if(zero > 0){ //0이 있다면 상쇄시키기
                pqAsc.poll();
            }
            else{ //0 없다면 남은 음수 더하기
                rslt += pqAsc.poll();
            }
        }

        //1 있는만큼 더하기
        while (one-- > 0) {
            rslt++;
        }

        bw.write(rslt + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
