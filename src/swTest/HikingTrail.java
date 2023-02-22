package swTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class HikingTrail {
    static int N, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int maxHeight = 0;
            map = new int[N][N];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int p = 0; p < N; p++) {
                    map[j][p] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(map[j][p], maxHeight);
                }
            }

            for (int j = 0; j < N; j++) {
                for (int p = 0; p < N; p++) {
                    if (map[j][p] == maxHeight) {
                        visited = new boolean[N][N];
                        visited[j][p] = true;
                        hikingTrailDFS(j, p, true, 1);
                    }
                }
            }

            bw.write("#" + i + " " + result + "\n");
            result = 0;
            // 재귀를 2개를 나누어 탄다. 1 -> 안깍고 돌리기, 2- > 깍고 돌리기
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void hikingTrailDFS(int x, int y, boolean flag, int sum) {
        for (int i = 0; i < 4; i++) {
            int xf = x + dx[i];
            int yf = y + dy[i];

            if (xf >= 0 && xf < N && yf >= 0 && yf < N && !visited[xf][yf]) {
                if (map[xf][yf] < map[x][y]) {
                    visited[xf][yf] = true;
                    hikingTrailDFS(xf, yf, flag, sum + 1);
                    visited[xf][yf] = false;
                }

                else {
                    if (flag) {
                        for (int j = 1; j <= K; j++) {
                            if (map[xf][yf] - j < map[x][y]) {
                                visited[xf][yf] = true;
                                map[xf][yf] -= j;

                                hikingTrailDFS(xf, yf, false, sum + 1);

                                map[xf][yf] += j;
                                visited[xf][yf] = false;
                            }
                        }
                    }
                }
            }
        }
        result = Math.max(result, sum);
    }
}
