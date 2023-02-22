package D5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BattleField {
    static int H, W;
    static char[][] map;

    static int dir;  // 0 : 위 , 1 : 오른쪽, 2 : 아래, 3: 왼쪽
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            int x = 0;
            int y = 0;

            map = new char[H][W];
            for (int j = 0; j < H; j++) {
                String input = br.readLine();
                for (int k = 0; k < W; k++) {
                    map[j][k] = input.charAt(k);

                    if (map[j][k] == '^' || map[j][k] == '>' ||
                            map[j][k] == 'v' ||	map[j][k] == '<') {
                        x = j;
                        y = k;

                        switch (map[j][k]) {
                            case '^':
                                dir = 0;
                                break;
                            case '>':
                                dir = 1;
                                break;
                            case 'v':
                                dir = 2;
                                break;
                            case '<':
                                dir = 3;
                                break;
                        }
                    }
                }
            }

            int commandCnt = Integer.parseInt(br.readLine());
            char[] commandArr = br.readLine().toCharArray();

            startGame(commandCnt, x, y, commandArr);

            bw.write("#" + i + " ");
            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++) {
                    bw.write(map[j][k]);
                }
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void startGame(int commandCnt, int x, int y, char[] commandArr) {
        int idx = 0;
        while (commandCnt > idx) {
            char c = commandArr[idx];

            switch (c) {
                case 'U':
                    dir = 0;

                    if (isSafe(x + dx[dir], y + dy[dir]) && map[x + dx[dir]][y + dy[dir]] == '.') {
                        map[x][y] = '.';
                        x += dx[dir];
                        y += dy[dir];
                    }

                    map[x][y] = '^';
                    break;
                case 'D':
                    dir = 2;

                    if (isSafe(x + dx[dir], y + dy[dir]) && map[x + dx[dir]][y + dy[dir]] == '.') {
                        map[x][y] = '.';
                        x += dx[dir];
                        y += dy[dir];
                    }

                    map[x][y] = 'v';
                    break;
                case 'L':
                    dir = 3;

                    if (isSafe(x + dx[dir], y + dy[dir]) && map[x + dx[dir]][y + dy[dir]] == '.') {
                        map[x][y] = '.';
                        x += dx[dir];
                        y += dy[dir];
                    }

                    map[x][y] = '<';
                    break;
                case 'R':
                    dir = 1;

                    if (isSafe(x + dx[dir], y + dy[dir]) && map[x + dx[dir]][y + dy[dir]] == '.') {
                        map[x][y] = '.';
                        x += dx[dir];
                        y += dy[dir];
                    }

                    map[x][y] = '>';
                    break;

                case 'S':
                    int t_x = x;
                    int t_y = y;
                    while (true) {

                        t_x += dx[dir];
                        t_y += dy[dir];

                        if (isSafe(t_x, t_y)) {
                            if (map[t_x][t_y] == '*') {
                                map[t_x][t_y] = '.';
                                break;
                            }

                            else if (map[t_x][t_y] == '#'){
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    break;
            }
            idx++;
        }
    }

    private static boolean isSafe(int x, int y) {
        if (x >= 0 && x < H && y >= 0 && y < W) {
            return true;
        }
        return false;
    }
}
