package D5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WirelessCharging {

    static int M; // 총 이동시간
    static int A; // BC의 개수
    static int[] aMove; // A의 이동경로
    static int[] bMove; // B의 이동경로

    static class BC {
        int x;
        int y;
        int range; // 충전 범위
        int val; // 충전 값

        public BC(int x, int y, int range, int val) {
            this.x = x;
            this.y = y;
            this.range = range;
            this.val = val;
        }
    }

    static List<BC> bcList;

    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};

    static int result = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            aMove = new int[M];
            for (int j = 0; j < M; j++) {
                aMove[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            bMove = new int[M];
            for (int j = 0; j < M; j++) {
                bMove[j] = Integer.parseInt(st.nextToken());
            }

            bcList = new ArrayList<>();

            for (int j = 0; j < A; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int range = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());

                bcList.add(new BC(y, x, range, val));
            }

            isCharged(0, 0, 9, 9);
            startMove(0, 0, 9, 9);

            bw.write("#" + i + " " + Integer.toString(result) + "\n");
            result = 0;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void startMove(int a1, int a2, int b1, int b2) {
        int timeStamp = 0;
        while (timeStamp < M) {

            a1 += dx[aMove[timeStamp]];
            a2 += dy[aMove[timeStamp]];

            b1 += dx[bMove[timeStamp]];
            b2 += dy[bMove[timeStamp]];

            isCharged(a1, a2, b1, b2);
            timeStamp++;
        }
    }

    private static void isCharged(int a1, int a2, int b1, int b2) {
        List<BC> aChargedList = new ArrayList<>();         // a가 충전할 수 있는 bc 구하기
        List<BC> bChargedList = new ArrayList<>();        // b가 충전할 수 있는 bc 구하기

        for (int i = 0; i < bcList.size(); i++) {
            BC bc = bcList.get(i);
            if (Math.abs(bc.x - a1) + Math.abs(bc.y - a2) <= bc.range) {
                aChargedList.add(new BC(bc.x, bc.y, bc.range, bc.val));
            }

            if (Math.abs(bc.x - b1) + Math.abs(bc.y - b2) <= bc.range) {
                bChargedList.add(new BC(bc.x, bc.y, bc.range, bc.val));
            }
        }

        // a만 충전할 수 있는 경우
        if (aChargedList.size() != 0 && bChargedList.size() == 0) {
            int aTemp = Integer.MIN_VALUE;
            for (int i = 0; i < aChargedList.size(); i++) {
                aTemp = Math.max(aChargedList.get(i).val, aTemp);
            }
            result += aTemp;

        } else if (aChargedList.size() == 0 && bChargedList.size() != 0) { // b만 충전할 수 있는 경우
            int bTemp = Integer.MIN_VALUE;
            for (int i = 0; i < bChargedList.size(); i++) {
                bTemp = Math.max(bChargedList.get(i).val, bTemp);
            }
            result += bTemp;

        } else if (aChargedList.size() == 0 && bChargedList.size() == 0) { // 둘다 충전할 수 없는 경우
            return;
        } else {        // 둘 다 충전할 수 있는 경우
            int tempSum = Integer.MIN_VALUE;
            for (int i = 0; i < aChargedList.size(); i++) {
                BC aBC = aChargedList.get(i);
                for (int j = 0; j < bChargedList.size(); j++) {
                    BC bBC = bChargedList.get(j);

                    if (aBC.x == bBC.x && aBC.y == bBC.y) {
                        tempSum = Math.max(tempSum, bBC.val);
                    } else {
                        tempSum = Math.max(tempSum, aBC.val + bBC.val);
                    }
                }
            }
            result += tempSum;
        }
    }
}