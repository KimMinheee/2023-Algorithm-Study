package sojeong.ch03_5_스택과큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11062_카드게임 {

    static int[] cards;
    static int[][][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            cards = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
            }

            dp = new int[2][N + 1][N + 1]; // 근우와 명우의 차례, 카드의 맨 왼쪽, 카드의 맨 오른쪽 -> dp 값은 근우가 얻는 점수임.
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j <= N; j++) {
                    for (int k = 1; k <= N; k++) {
                        dp[i][j][k] = -1;
                    }
                }
            }

            sb.append(recursion(0, 1, N) + "\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static int recursion(int turn, int start, int end) {
        if (dp[turn][start][end] != -1) {
            return dp[turn][start][end];
        }

        // 기저 사례
        if (start >= end) {
            if (turn == 0) { // 근우 차례
                return cards[start];
            } else { // 명우 차례
                return 0;
            }
        }

        dp[turn][start][end] = 0;

        if (turn == 0) { // 근우 차례에 경우는 왼쪽 카드를 뽑았을 떄와 오른쪽 카드를 뽑았을 때 중, 숫자의 합이 크도록 설정.
            dp[turn][start][end] = Math.max(recursion(turn + 1, start + 1, end) + cards[start],
                recursion(turn + 1, start, end - 1) + cards[end]);
        } else { // 명우 차례에 경우는 근우가 더 작은 카드를 뽑게 해야하므로, 왼쪽 카드를 뽑았을 때와 오른쪽 카드를 뽑았을 때 중, 숫자의 합이 작도록 설정.
            dp[turn][start][end] = Math.min(recursion(turn - 1, start + 1, end),
                recursion(turn - 1, start, end - 1));
        }

        return dp[turn][start][end];
    }
}