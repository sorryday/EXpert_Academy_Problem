package D2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class TwoNumArr {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            List<Integer> numArr = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }

            if (N < M) {
                for (int j = 0; j <= Math.abs(N - M); j++) {
                    int sum = 0;
                    for (int k = 0; k < N; k++) {
                        sum += A[k] * B[k + j];
                    }

                    numArr.add(sum);
                }
            } else if (N == M) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += A[k] * B[k];
                }

                numArr.add(sum);
            } else {
                for (int j = 0; j <= Math.abs(N - M); j++) {
                    int sum = 0;
                    for (int k = 0; k < M; k++) {
                        sum += A[k + j] * B[k];
                    }

                    numArr.add(sum);
                }
            }

            Collections.sort(numArr, Collections.reverseOrder());
            bw.write("#" + (i + 1) + " " + Integer.toString(numArr.get(0)) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}