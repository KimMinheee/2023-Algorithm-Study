package week2;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class BOJ_1377_버블소트프로그램1{
    private static int[] num;
    public static void main (String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Pair> arr = new ArrayList<>(N);
        for(int i=0; i<N; i++){
            arr.add(new Pair(i, Integer.parseInt(br.readLine())));
        }

        arr.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });

        int max = 0;
        for(int i=0; i<N; i++){
            if(max < arr.get(i).idx-i) { //정렬 전의 인덱스 - 정렬 후 인덱스(왼쪽으로 온 만큼)
                max = arr.get(i).idx-i;
            }
        }

        bw.write(max+1 + "\n");
        bw.flush();
        bw.close();
    }
    private static void swap(int idx1, int idx2){
        int tmp = num[idx1];
        num[idx1] = num[idx2];
        num[idx2] = tmp;
    }

    private static class Pair{
        int idx;
        int value;

        public Pair(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}