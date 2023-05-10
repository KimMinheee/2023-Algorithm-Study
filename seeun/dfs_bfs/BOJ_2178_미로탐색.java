import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {

    private static int[] moveX = {-1, 0, 1, 0};
    private static int[] moveY = {0, 1, 0, -1};
    private static int[][] board;

    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++)
                board[i][j] = Integer.parseInt(str.substring(j, j + 1));
        }

        search(0, 0);
        bw.write(board[n-1][m-1] + "\n");
        bw.flush();
        bw.close();
    }

    private static void search(int x, int y) {
        int n = board.length;
        int m = board[0].length;

        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;

        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] node = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = node[0] + moveX[i];
                int newY = node[1] + moveY[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && board[newX][newY] != 0 && !visited[newX][newY]) {

                    visited[newX][newY] = true;
                    board[newX][newY] = board[node[0]][node[1]] + 1; //현재 칸 +1해서 깊이표현
                    q.add(new int[]{newX, newY});
                }
            }
        }
    }
}
