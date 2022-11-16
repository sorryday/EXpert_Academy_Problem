package D1;

import java.io.*;
import java.util.*;
public class AvgNum {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int order = 1;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double sum = 0;

            for (int j = 0; j < 10; j++) {
                sum += Double.parseDouble(st.nextToken());
            }

            bw.write("#" + Integer.toString(order) + " " + Math.round(sum / 10) + "\n");
            order++;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
