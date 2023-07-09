package ch09_2_트라이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14425_문자열찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");

        int n = Integer.parseInt(in[0]), m = Integer.parseInt(in[1]);
        Node root = new Node();
        while (n --> 0) { // 트라이 구축
            String str = br.readLine();
            Node cur = root;
            for (int i = 0; i < str.length(); ++i) {
                char c = str.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Node();
                }
                cur = cur.children[c - 'a'];

                if (i == str.length() - 1) {
                    cur.isLast = true;
                }
            }
        }

        int ans = 0;
        while (m --> 0) { // 트라이 탐색
            String str = br.readLine();
            Node cur = root;
            for (int i = 0; i < str.length(); ++i) {
                char c = str.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    break;
                }
                cur = cur.children[c - 'a'];

                if (i == str.length() - 1 && cur.isLast) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static class Node {

        Node[] children = new Node[26];
        boolean isLast;

        public Node() {
        }
    }
}