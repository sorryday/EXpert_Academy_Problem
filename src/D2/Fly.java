package D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Fly {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] flyMap = new int[N][N];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    flyMap[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            for (int j = 0; j < N - M + 1; j++) {
                for (int k = 0; k < N - M + 1; k++) {
                    int sum = 0;

                    for (int q = 0; q < M; q++) {
                        for (int p = 0; p < M; p++) {
                            sum += flyMap[j + q][k + p];
                        }
                    }
                    result = Math.max(result, sum);
                }
            }

            bw.write("#" + Integer.toString(i + 1) + " " + Integer.toString(result) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
