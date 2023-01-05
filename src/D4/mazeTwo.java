package D4;

import java.io.*;

public class mazeTwo {
    static int[][] map;
    static boolean[][] visited;

    static int startX, startY;
    static int endX, endY;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 10; i++) {
            int T = Integer.parseInt(br.readLine());

            visited = new boolean[100][100];
            map = new int[100][100];

            for (int j = 0; j < 100; j++) {
                String inputMap = br.readLine();
                for (int k = 0; k < 100; k++) {
                    char c = inputMap.charAt(k);

                    if (c == '2') {
                        startX = j;
                        startY = k;
                    } else if (c == '3'){
                        endX = j;
                        endY = k;
                    }
                    map[j][k] = c - '0';
                }
            }

            isReachMaze(startX, startY);
            if (flag)
                bw.write("#" + Integer.toString(T) + " " + "1" + "\n");
            else
                bw.write("#" + Integer.toString(T) + " " + "0" + "\n");

            flag = false;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void isReachMaze(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int xf = x + dx[i];
            int yf = y + dy[i];

            if (xf >= 0 && xf < 100 && yf >= 0 && yf < 100 && !visited[xf][yf] && map[xf][yf] != 1) {
                if (xf == endX && yf == endY) {
                    flag = true;
                } else {
                    isReachMaze(xf, yf);
                }
            }
        }
    }
}
