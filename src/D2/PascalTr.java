package D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PascalTr {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int order = 1;

        int T = Integer.parseInt(br.readLine());
        for (int k = 0; k < T; k++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];

            int flag = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < flag; j++) {
                    if (j == 0 || j == flag) {
                        map[i][j] = 1;
                    } else {
                        map[i][j] = map[i - 1][j - 1] + map[i - 1][j];
                    }
                }
                flag++;
            }

            bw.write("#" + Integer.toString(order) + "\n");

            int printFlag = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < printFlag; j++) {
                    bw.write(Integer.toString(map[i][j]) + " ");
                }
                bw.write("\n");
                printFlag++;
            }
            order++;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}