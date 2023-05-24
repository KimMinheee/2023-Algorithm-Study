import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            priorityQueue.add(sc.nextInt());
        }

        int result = 0;
        while (priorityQueue.size() > 1) {
            int sum = priorityQueue.poll() + priorityQueue.poll();
            result += sum;
            priorityQueue.add(sum);
        }

        System.out.println(result);
    }
}
