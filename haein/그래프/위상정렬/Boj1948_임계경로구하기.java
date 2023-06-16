package haein.그래프.위상정렬;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
public class Boj1948_임계경로구하기 {
    public static ArrayList<dNode>[] list;
    public static ArrayList<dNode>[] reverseList;
    public static int[] time;
    public static int[] indegree;
    public static int n;
    public static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        reverseList = new ArrayList[n+1];
        indegree = new int[n+1];
        time = new int[n+1];
        for(int i=0; i<n+1; i++) {
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            list[start].add(new dNode(end, time));
            reverseList[end].add(new dNode(start, time));
            indegree[end]++;
        }
        st = new StringTokenizer(br.readLine());
        int here = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        q.offer(here);
        topologicalSort(list, indegree);
        System.out.println(time[goal]);
        System.out.println(reverseTopologicalSort(reverseList, goal));
    }

    public static void topologicalSort(ArrayList<dNode>[] list, int[] indegree) {
        while(!q.isEmpty()) {
            int node = q.poll();
            for(dNode d : list[node]) {
                if(--indegree[d.targetNode]==0) q.offer(d.targetNode);
                time[d.targetNode] = Math.max(time[d.targetNode], time[node]+ d.value);
            }
        }
    }

    public static int reverseTopologicalSort(ArrayList<dNode>[] reverseList, int goal) {
        int resultCount=0;
        boolean visited[] = new boolean[n+1];
        q = new LinkedList<>();
        q.offer(goal);
        visited[goal] = true;
        while(!q.isEmpty()) {
            int now = q.poll();
            for(dNode next : reverseList[now]) {
                if(time[next.targetNode] + next.value == time[now]) {
                    resultCount++;
                    if(!visited[next.targetNode]) {
                        visited[next.targetNode] = true;
                        q.offer(next.targetNode);
                    }
                }
            }
        }
        return resultCount;
    }
}
class dNode {
    int targetNode;
    int value;

    dNode(int targetNode, int value) {
        this.targetNode = targetNode;
        this.value = value;
    }

}
