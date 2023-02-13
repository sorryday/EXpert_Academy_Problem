package D3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MakeCode {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String T = br.readLine();
            if (T == null) {
                break;
            } else {
                int testCast = Integer.parseInt(T);
                StringTokenizer st = new StringTokenizer(br.readLine());

                Queue<Integer> arr = new LinkedList<>();
                for (int i = 0; i < 8; i++) {
                    arr.add(Integer.parseInt(st.nextToken()));
                }

                int idx = 1;
                while (true) {
                    if (idx == 6) {
                        idx = 1;
                    }

                    if (arr.peek() - idx <= 0) {
                        arr.poll();
                        arr.add(0);
                        break;
                    } else {
                        arr.add(arr.poll() - idx);
                    }
                    ++idx;
                }

                bw.write("#" + testCast + " ");
                for (int i = 0; i < 8; i++) {
                    bw.write(Integer.toString(arr.poll()) + " ");
                }
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
