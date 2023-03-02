package swTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class BreakRock {
    static int N, W, H;
    static int[][] map;
    static int[] printArr;
    static int result = Integer.MAX_VALUE;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class BrakePoint {
        int x;
        int y;
        int val;

        public BrakePoint(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            for (int j = 0; j < H; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < W; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // 구슬을 놓는 위치를 정해줄 백트래킹 함수
            printArr = new int[N];
            selectedBall(0, 0);

            if (result == Integer.MAX_VALUE) {
                bw.write("#" + i + " " + 0 + "\n");
            } else {
                bw.write("#" + i + " " + result + "\n");
            }
            result = Integer.MAX_VALUE;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 구슬을 놓는 위치를 정해줄 백트래킹 함수
    private static void selectedBall(int depth, int cnt) {
        // 구슬을 놓을 위치를 다 정했다면 게임함수 시작
        if (cnt == N) {
            startGame();
            return;
        }

        for (int i = 0; i < W; i++) {
            printArr[cnt] = i;
            selectedBall(i, cnt + 1);
        }
    }

    // 블럭을 부수는 게임 함수
    private static void startGame() {
        // 원본 배열을 부수면 안되므로 복사본 배열을 만들어 처리
        int[][] cpMap = new int[H][W];
        for (int j = 0; j < H; j++) {
            for (int p = 0; p < W; p++) {
                cpMap[j][p] = map[j][p];
            }
        }

        // 구슬을 놓을 위치를 찾고 그 위치부터 시작
        for (int i = 0; i < printArr.length; i++) {
            // 블럭을 부순 위치를 저장할 큐
            Queue<BrakePoint> bpQueue = new ArrayDeque<>();

            // 구슬마다 가로로 내려가면서 블럭이 나올 때까지 찾는다.
            for (int j = 0; j < H; j++) {
                if (cpMap[j][printArr[i]] != 0) {
                    bpQueue.add(new BrakePoint(j, printArr[i], cpMap[j][printArr[i]]));
                    cpMap[j][printArr[i]] = 0;
                    break;
                }
            }

            // 사방으로 탐색하면서 지워지는 블럭을 큐에 넣는다.
            BrakePoint firstBP = bpQueue.poll();
            if (firstBP == null) return;

            // 아래
            for (int j = 1; j <= firstBP.val - 1; j++) {
                if (isAvailable(firstBP.x + j, firstBP.y)) {
                    bpQueue.add(new BrakePoint(firstBP.x + j, firstBP.y, cpMap[firstBP.x + j][firstBP.y]));
                }
            }
            // 오른쪽
            for (int j = 1; j <= firstBP.val - 1; j++) {
                if (isAvailable(firstBP.x, firstBP.y + j)) {
                    bpQueue.add(new BrakePoint(firstBP.x, firstBP.y + j, cpMap[firstBP.x][firstBP.y + j]));
                }
            }
            // 왼쪽
            for (int j = 1; j <= firstBP.val - 1; j++) {
                if (isAvailable(firstBP.x, firstBP.y - j)) {
                    bpQueue.add(new BrakePoint(firstBP.x, firstBP.y - j, cpMap[firstBP.x][firstBP.y - j]));
                }
            }


            // 큐에 들어있는 값들에 대해서 하나씩 꺼내면서 왼쪽, 위, 아래, 오른쪽을 판단한다.
            while(!bpQueue.isEmpty()){
                BrakePoint poll = bpQueue.poll();
                cpMap[poll.x][poll.y] = 0;

                // 위
                for (int p = 1; p <= poll.val - 1; p++) {
                    if (isAvailable(poll.x - p, poll.y)) {
                        if (cpMap[poll.x - p][poll.y] > 0) {
                            bpQueue.add(new BrakePoint(poll.x - p, poll.y, cpMap[poll.x - p][poll.y]));
                        }
                        cpMap[poll.x - p][poll.y] = 0;
                    }
                }
                // 아래
                for (int p = 1; p <= poll.val - 1; p++) {
                    if (isAvailable(poll.x + p, poll.y)) {
                        if (cpMap[poll.x + p][poll.y] > 0) {
                            bpQueue.add(new BrakePoint(poll.x + p, poll.y, cpMap[poll.x + p][poll.y]));
                        }
                        cpMap[poll.x + p][poll.y] = 0;
                    }
                }
                // 왼쪽
                for (int p = 1; p <= poll.val - 1; p++) {
                    if (isAvailable(poll.x, poll.y - p)) {
                        if (cpMap[poll.x][poll.y - p] > 0) {
                            bpQueue.add(new BrakePoint(poll.x, poll.y - p, cpMap[poll.x][poll.y - p]));
                        }
                        cpMap[poll.x][poll.y - p] = 0;
                    }
                }
                // 오른쪽
                for (int p = 1; p <= poll.val - 1; p++) {
                    if (isAvailable(poll.x, poll.y + p)) {
                        if (cpMap[poll.x][poll.y + p] > 0) {
                            bpQueue.add(new BrakePoint(poll.x, poll.y + p, cpMap[poll.x][poll.y + p]));
                        }
                        cpMap[poll.x][poll.y + p] = 0;
                    }
                }
            }

            // 다 부쉈으면 남은 블럭들을 한 칸씩 내려준다.
            for (int j = H - 1; j >= 0; j--) {
                for (int p = W - 1; p >= 0; p--) {
                    int idx = j;
                    while (true) {
                        if (isAvailable(idx + 1, p) && cpMap[idx][p] >= 1 && cpMap[idx + 1][p] == 0) {
                            cpMap[idx + 1][p] = cpMap[idx][p];
                            cpMap[idx][p] = 0;
                            idx++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        // 로직을 완료했다면 남은 블럭의 개수를 세준다.
        int cnt = 0;
        for (int j = 0; j < H; j++) {
            for (int p = 0; p < W; p++) {
                if (cpMap[j][p] != 0) {
                    cnt += 1;
                }
            }
        }

        // 최소 값 계산
        result = Math.min(result, cnt);
    }

    // 범위를 벗어나는지 판단하는 함수
    private static boolean isAvailable(int x, int y) {
        if (x >= 0 && x < H && y >= 0 && y < W) {
            return true;
        }
        return false;
    }
}