package D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class supplyPlace {

    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static boolean[][] visited;
    static int N;
    static int[][] map;
    static int sum = 0;
    static int result = Integer.MAX_VALUE;

    static class Point implements Comparable<Point>{
        int x = 0;
        int y = 0;
        int deep = 0;

        public Point(int x, int y, int deep) {
            this.x = x;
            this.y = y;
            this.deep = deep;
        }

        @Override
        public int compareTo(Point o) {
            if (o.deep < this.deep) {
                return 1;
            } else if (o.deep > this.deep) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            result = Integer.MAX_VALUE;

            map = new int[N][N];
            for (int j = 0; j < N; j++) {
                String input = br.readLine();

                for (int k = 0; k < N; k++) {
                    map[j][k] = input.charAt(k) - '0';
                }
            }

            visited = new boolean[N][N];
            roadBFS(0, 0);

            bw.write("#" + Integer.toString(i + 1) + " " + Integer.toString(result) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static public void roadBFS(int x, int y) {
        PriorityQueue<Point> q = new PriorityQueue();

        q.add(new Point(x, y, 0));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == N - 1 && p.y == N - 1) {
                result = result > p.deep ? p.deep : result;
            }

            for (int i = 0; i < 4; i++) {
                int xf = p.x + dx[i];
                int yf = p.y + dy[i];

                if (xf < 0 || yf < 0 || xf >= N || yf >= N) continue;

                if (!visited[xf][yf]) {
                    int df = p.deep + map[xf][yf];
                    q.add(new Point(xf, yf, df));
                    visited[xf][yf] = true;
                }
            }
        }
    }
}