package D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Rukh {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            char[][] map = new char[8][8];
            boolean[][] visited = new boolean[8][8];
            int cnt = 0;

            for (int j = 0; j < 8; j++) {
                String input = br.readLine();
                for (int k = 0; k < 8; k++) {
                    map[j][k] = input.charAt(k);

                    if (map[j][k] == 'O') {
                        visited[j][k] = true;
                        cnt += 1;
                    }
                }
            }

            if (cnt != 8) {
                bw.write("#" + Integer.toString(i + 1) + " " + "no" + "\n");
            } else {
                boolean flag = true;
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 8; k++) {
                        if (map[j][k] == 'O') {

                            // 왼쪽
                            for (int q = k - 1; q >= 0; q--) {
                                if (map[j][q] == 'O') {
                                    flag = false;
                                }
                            }

                            // 오른쪽
                            for (int q = k + 1; q < 8; q++) {
                                if (map[j][q] == 'O') {
                                    flag = false;
                                }
                            }

                            // 위
                            for (int q = j - 1; q >= 0; q--) {
                                if (map[q][k] == 'O') {
                                    flag = false;
                                }
                            }

                            // 아래
                            for (int q = j + 1; q < 8; q++) {
                                if (map[q][k] == 'O') {
                                    flag = false;
                                }
                            }
                        }
                    }
                }

                if (flag) {
                    bw.write("#" + Integer.toString(i + 1) + " " + "yes" + "\n");
                } else {
                    bw.write("#" + Integer.toString(i + 1) + " " + "no" + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}