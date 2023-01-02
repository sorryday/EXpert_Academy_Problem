package D2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SUM {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 10; i++) {
            String order = br.readLine();

            int rowSum = 0;
            int colSum = 0;
            int diagonalSum = 0;

            List<Integer> sumList = new ArrayList<>();
            int[][] numArr = new int[100][100];

            for (int j = 0; j < 100; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 100; k++) {
                    numArr[j][k] = Integer.parseInt(st.nextToken());

                    // 1. 행 더하기
                    rowSum += numArr[j][k];
                }
                sumList.add(rowSum);
                rowSum = 0;
            }

            // 2. 열 더하기
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 100; k++) {
                    colSum += numArr[k][j];
                }
                sumList.add(colSum);
                colSum = 0;
            }

            // 3. 대각선 더하기
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 100; k++) {
                    if (j != k) {
                        continue;
                    } else {
                        diagonalSum += numArr[j][k];
                    }
                }
                sumList.add(diagonalSum);
                diagonalSum = 0;
            }

            // 정렬 후 출력
            Collections.sort(sumList, Collections.reverseOrder());
            bw.write("#" + order + " " + Integer.toString(sumList.get(0)) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}