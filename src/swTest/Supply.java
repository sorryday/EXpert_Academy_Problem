package swTest;

import java.io.*;
import java.util.*;

public class Supply {
    static int N;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class RecoverPoint {
        int x;
        int y;
        int val;  // x, y 값에 갈 때까지 복구한 시간의 누적합

        public RecoverPoint(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    static int result = Integer.MAX_VALUE;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 값 Setting
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int j = 0; j < N; j++) {
                String input = br.readLine();
                for (int k = 0; k < N; k++) {
                    map[j][k] = input.charAt(k) - '0';
                }
            }

            // BFS 탐색을 위한 visited 배열
            visited = new boolean[N][N];

            // 최단경로 찾기 함수 시작
            searchMinRecover();

            // 결과 출력
            bw.write("#" + i + " " + result + "\n");

            // result는 static 변수이므로 다시 초기화해준다.
            result = Integer.MAX_VALUE;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 최소값으로 이동하는 경로를 탐색하는 함수
    private static void searchMinRecover() {
        // 우선순위 탐색을 위한 우선순위 큐를 선언
        PriorityQueue<RecoverPoint> pq = new PriorityQueue<>(new Comparator<RecoverPoint>() {
            @Override
            public int compare(RecoverPoint o1, RecoverPoint o2) {
                return o1.val - o2.val;
            }
        });

        // 초기 값인 0,0을 넣어주고 방문처리 해준다.
        pq.add(new RecoverPoint(0, 0, 0));
        visited[0][0] = true;

        // 큐가 비어있을 때까지 BFS 탐색을 해준다.
        while (!pq.isEmpty()) {
            RecoverPoint poll = pq.poll();

            // N - 1, N - 1에 도착했다면 그때까지 복구한 시간의 누적합을 갱신해준다.
            if (poll.x == N - 1 && poll.y == N - 1) {
                result = Math.min(result, poll.val);
            }

            // 이동할 수 있는 곳을 탐색한다.(사방)
            for (int i = 0; i < 4; i++) {
                int xf = poll.x + dx[i];
                int yf = poll.y + dy[i];

                if (xf >= 0 && xf < N && yf >= 0 && yf < N && !visited[xf][yf]){
                    /* 우선순위 큐의 Comparator에서 val을 오름차순으로 선언해주었고
                       객체의 val 값이 그 위치까지 간 누적합이므로 다른 조건으로 가치지기를 해주지 않아도
                       BFS의 레벨별로 탐색이 가능하다.
                    */
                    visited[xf][yf] = true;
                    pq.add(new RecoverPoint(xf, yf, poll.val + map[xf][yf]));
                }
            }
        }
    }
}
