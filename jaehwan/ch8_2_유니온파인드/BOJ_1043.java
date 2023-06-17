import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1043 {
    public static int[] parent;//대표배열
    public static int[] trueP;//진실을 아는 사람 배열
    public static ArrayList<Integer>[] party; //파티 배열
    public static int result; //결과값

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//사람수
        int m = sc.nextInt();//파티수
        int t= sc.nextInt();//진실을 아는 사람수
        result=0;
        trueP=new int[t];
        for(int i=0;i<t;i++){//진실을 아는 사람수 초기화
            trueP[i]=sc.nextInt();
        }
        party = new ArrayList[m];
        for(int i=0;i<m;i++){ //파티데이터 저장
            party[i]=new ArrayList<Integer>();
            int partySize=sc.nextInt();
            for(int j=0;j<partySize;j++){
                party[i].add(sc.nextInt());
            }
        }
        parent=new int[n+1];
        for (int i=0;i<=n;i++){//대표 노드를 자기 자신으로 초기화
            parent[i]=i;
        }
        //여기까지 초기화 및 입력처리

        for(int i=0;i<m;i++){
            int firstPeople=party[i].get(0); //i번째 파티 1번 사람
            for(int j=1;j<party[i].size();j++){
                union(firstPeople,party[i].get(j)); //유니온 연산 대표 배열 대표 노드끼리 연결해서 합집합으로 만들어줌
            }
        }
        for(int i=0;i<m;i++){ //파티를 돌면서
            boolean isPossible =true;
            int cur=party[i].get(0);

            for(int j=0;j<trueP.length;j++){ //진실을 아는 사람들과 같은 그룹에 있는지 검사
                if(find(cur)==find(trueP[j])){
                    isPossible=false;
                    break;
                }
            }
            if(isPossible){ //과장을 할수 있으면
                result++; //출력값 ++
            }
        }
        System.out.println(result);
    }
    private static void union(int a,int b) {
        a=find(a);
        b=find(b);
        if(a != b){
            parent[b]=a;
        }
    }
    private static int find(int a) {
    if(a==parent[a]){
        return a;
    }
    else
        return parent[a]=find(parent[a]);
    }
}
/*
파티에 참여한 사람들을 하나의 집합으로 보고 진실을 아는 사람을 만난적이 있는지 체크하면된다.
* */
