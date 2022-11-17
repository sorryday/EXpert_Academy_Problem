package D1;

import java.io.*;
import java.util.StringTokenizer;

public class MaxMinEqual {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int order = 1;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            bw.write("#" + Integer.toString(order) + " ");
            if (num1 > num2) {
                bw.write(">" + "\n");
            } else if (num1 == num2) {
                bw.write("=" + "\n");
            } else {
                bw.write("<" + "\n");
            }
            order += 1;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
