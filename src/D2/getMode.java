package D2;

import java.io.*;
import java.util.StringTokenizer;

public class getMode {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String order = br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[101];
            for (int i = 0; i < 1000; i++) {
                arr[Integer.parseInt(st.nextToken())] += 1;
            }

            int idx = 0;
            for (int i = 0; i <= 100 ; i++) {
                if (arr[idx] <= arr[i]) {
                    idx = i;
                }
            }

            bw.write("#" + order + " " + Integer.toString(idx) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
