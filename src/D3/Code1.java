package D3;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Code1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= 10; i++) {
            int stringLength = Integer.parseInt(br.readLine());
            List<String> list = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < stringLength; j++) {
                list.add(st.nextToken());
            }

            int commandCnt = Integer.parseInt(br.readLine());
            String[] commandLine = br.readLine().split("I ");

            for (int j = 1; j <= commandCnt; j++) {
                String[] s = commandLine[j].split(" ");

                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);

                int idx = 2;
                for (int l = start; l < start + end; l++) {
                    list.add(l, s[idx]);
                    ++idx;
                }
            }

            bw.write("#" + i + " ");
            for (int j = 0; j < 10; j++) {
                bw.write(list.get(j) + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}