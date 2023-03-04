package D2;

import java.io.*;
import java.util.*;

public class HeightTree {
    static int N;
    static Queue<Integer> q;
    static int result = 0;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());

            q = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int token = Integer.parseInt(st.nextToken());
                q.add(token);
                max = Math.max(max, token);
            }

            // max - list.get(i) 값으로 1의 개수와 2의 개수를 구하자
            int oneCnt = 0;
            int twoCnt = 0;

            for (int j = q.size() - 1; j >=  0; j--) {
                int poll = q.poll();
                if (poll != max){
                    twoCnt += (max - poll) / 2;
                    oneCnt += (max - poll) % 2;
                }
            }

            if (twoCnt > oneCnt) {
                result = oneCnt * 2 + ((Math.abs(twoCnt - oneCnt) * 2) / 3) * 2 + ((Math.abs(twoCnt - oneCnt) * 2) % 3);
            } else if (twoCnt < oneCnt){
                result = twoCnt * 2 + (Math.abs(twoCnt - oneCnt) - 1) * 2 + 1;
            } else {
                result = twoCnt + oneCnt;
            }

            bw.write("#" + i + " " + result + "\n");
            result = 0;
            max = Integer.MIN_VALUE;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}