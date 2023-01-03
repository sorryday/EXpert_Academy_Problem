package D2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SudokuVali {
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            map = new int[9][9];
            for (int j = 0; j < 9; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 9; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            boolean rowValiFlag = rowValidate();
            boolean colValiFlag = colValidate();
            boolean squareValiFlag = squareValidate();

            if (rowValiFlag && colValiFlag && squareValiFlag) {
                bw.write("#" + Integer.toString(i + 1) + " " + "1" + "\n");
            } else {
                bw.write("#" + Integer.toString(i + 1) + " " + "0" + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean rowValidate() {
        List<Integer> checkList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (checkList.contains(map[i][j])) {
                    return false;
                } else {
                    checkList.add(map[i][j]);
                }
            }
            checkList.clear();
        }
        return true;
    }

    static boolean colValidate() {
        List<Integer> checkList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (checkList.contains(map[j][i])) {
                    return false;
                } else {
                    checkList.add(map[j][i]);
                }
            }
            checkList.clear();
        }
        return true;
    }

    static boolean squareValidate() {
        List<Integer> checkList = new ArrayList<>();
        for (int q = 0; q <= 6; q += 3) {
            for (int k = 0; k <= 6; k += 3) {
                for (int i = q; i < q + 3; i++) {
                    for (int j = k; j < k + 3; j++) {
                        if (checkList.contains(map[i][j])) {
                            return false;
                        } else {
                            checkList.add(map[i][j]);
                        }
                    }
                }
                checkList.clear();
            }
        }
        return true;
    }
}