package D1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class GetMaxNum {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int order = 1;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            List<Integer> numList = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                numList.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(numList, Collections.reverseOrder());

            bw.write("#" + Integer.toString(order) + " " + Integer.toString(numList.get(0)) + "\n");
            order++;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
