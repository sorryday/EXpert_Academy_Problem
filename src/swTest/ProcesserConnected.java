package swTest;

import java.io.*;
import java.util.*;

public class ProcesserConnected {
    static int N;
    static int[][] map;
    static boolean[][] visited; // 전선을 연결할 때 교차를 방지하기 위한 방문 배열
    static int[] printArr;        // 전선이 어느 방향으로 연결할 것인가를 결정할 배열

    static int coreCnt = 0; // 가장자리를 제외한 코어의 개수

    static class Core {
        int x;
        int y;

        public Core(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static List<Core> coreList;
    static int resultLine = Integer.MAX_VALUE;
    static int resultCore = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            coreList = new ArrayList<>();
            map = new int[N][N];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());

                    if (j != 0 && k != 0 && j != N - 1 && k != N - 1 && map[j][k] == 1) {
                        coreCnt += 1;
                        coreList.add(new Core(j, k));
                    }
                }
            }

            printArr = new int[coreCnt];
            visited = new boolean[N][N];

            searchCoreDFS(0, 0, 0);

            bw.write("#" + i + " " + resultLine + "\n");

            resultLine = Integer.MAX_VALUE;
            resultCore = Integer.MIN_VALUE;
            coreCnt = 0;
        }
        bw.flush();
        bw.close();
        br.close();
    }

    // 코어들이 어떤 방향으로 탐색할지 선택하는 함수
    // depth : 처리한 코어의 개수, cnt : 전선을 연결한 코어의 개수, length : 탐색하는 코어의 전선 연결 개수
    private static void searchCoreDFS(int depth, int cnt, int length) {
        if (depth == coreCnt) {
            if (cnt > resultCore) {
                resultCore = cnt;
                resultLine = length;
            } else if (cnt == resultCore) {
                resultLine = Math.min(length, resultLine);
            }
            return;
        }

        Core core = coreList.get(depth);
        for (int i = 0; i < 4; i++) {
            int xf = core.x;
            int yf = core.y;

            int len = 0;

            while (true) {
                xf += dx[i];
                yf += dy[i];

                if (isAvailable(xf, yf) && map[xf][yf] == 0) {
                    len += 1;
                } else if (!isAvailable(xf, yf)) {
                    break;
                } else if (map[xf][yf] == 1){
                    len = 0;
                    break;
                }
            }

            int tempX = core.x;
            int tempY = core.y;

            // 카운트한 len 만큼 이동해서 1로 채워준다.
            for (int j = 0; j < len; j++) {
                tempX += dx[i];
                tempY += dy[i];
                map[tempX][tempY] = 1;
            }

            // len 값이 0이 아니라면 배열의 끝에 도달했다는 의미이므로 cnt와 depth를 +1 해준다.
            if (len != 0) {
                searchCoreDFS(depth + 1, cnt + 1, length + len);

                tempX = core.x;
                tempY = core.y;

                for (int j = 0; j < len; j++) {
                    tempX += dx[i];
                    tempY += dy[i];
                    map[tempX][tempY] = 0;
                }
            } else {
                searchCoreDFS(depth + 1, cnt, length);
            }
        }
    }

    // 배열의 범위안에 있는지 확인
    private static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}