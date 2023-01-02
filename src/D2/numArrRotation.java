package D2;

import java.io.*;
import java.util.StringTokenizer;

public class numArrRotation {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String[][] numArr = new String[N][N];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    numArr[j][k] = st.nextToken();
                }
            }

            String[] numArr90 = new String[N];
            for (int j = 0; j < N; j++) {
                StringBuffer sb = new StringBuffer();
                for (int k = N - 1; k >= 0; k--) {
                    sb.append(numArr[k][j]);
                }
                numArr90[j] = sb.toString();
            }

            String[] numArr180 = new String[N];
            int idx = 0;
            for (int j = N - 1; j >= 0; j--) {
                StringBuffer sb = new StringBuffer();
                for (int k = N - 1; k >= 0; k--) {
                    sb.append(numArr[j][k]);
                }
                numArr180[idx] = sb.toString();
                idx++;
            }

            String[] numArr270 = new String[N];
            idx = 0;
            for (int j = N - 1; j >= 0; j--) {
                StringBuffer sb = new StringBuffer();
                for (int k = 0; k < N; k++) {
                    sb.append(numArr[k][j]);
                }
                numArr270[idx] = sb.toString();
                idx++;
            }

            bw.write("#" + (i + 1) + "\n");
            for (int j = 0; j < N; j++) {
                bw.write(numArr90[j] + " " + numArr180[j] + " " + numArr270[j] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}