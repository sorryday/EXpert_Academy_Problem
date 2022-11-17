package D2;

import java.io.*;
public class SnailNum {

    static int dir = 1; // 동 :1, 남 : 2, 서 : 3 , 북 : 4
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int order = 1;

        for (int k = 0; k < T; k++) {
            int N = Integer.parseInt(br.readLine());
            int[][] snailMap = new int[N][N];

            int row = 0;
            int col = 0;
            dir = 1;

            for (int i = 0; i < N * N; i++) {
                switch (dir) {
                    case 1 :
                        snailMap[row][col] = i + 1;
                        if (col == N - 1 || snailMap[row][col + 1] != 0) {
                            setDir();
                            row += 1;
                        } else  {
                            col += 1;
                        }
                        break;

                    case 2 :
                        snailMap[row][col] = i + 1;
                        if (row == N - 1 || snailMap[row + 1][col] != 0) {
                            setDir();
                            col -= 1;
                        } else  {
                            row += 1;
                        }
                        break;

                    case 3 :
                        snailMap[row][col] = i + 1;
                        if (col == 0 || snailMap[row][col - 1] != 0) {
                            setDir();
                            row -= 1;
                        } else  {
                            col -= 1;
                        }
                        break;

                    case 4 :
                        snailMap[row][col] = i + 1;
                        if (row == 0 || snailMap[row - 1][col] != 0) {
                            setDir();
                            col += 1;
                        } else  {
                            row -= 1;
                        }
                        break;
                }
            }

            bw.write("#" + Integer.toString(order) + "\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    bw.write(Integer.toString(snailMap[i][j]) + " ");
                }
                bw.write("\n");
            }
            order++;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void setDir() {
        ++dir;
        if (dir > 4) {
            dir = 1;
        }
    }
}

