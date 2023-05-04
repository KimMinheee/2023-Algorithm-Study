import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq= new PriorityQueue<>((o1,o2)->
        Math.abs(o1) ==Math.abs(o2) ? Integer.compare(o1,o2):Integer.compare(Math.abs(o1),Math.abs(o2)));
        for(int i=0;i<N;i++){
            int x=Integer.parseInt(br.readLine());
            if(x==0){
                if(!pq.isEmpty()){
                    System.out.println(pq.poll());
                }
                else{
                    System.out.println(0);
                }
            }else {
                pq.add(x);
            }
        }
    }
}
//문제 해석과 요구사항을 코드로 구현하는게 중요한 문제이다 같은 수가 있을때 적은 값이란 소리는 곧 음수를 뜻한다고 생각된다 
