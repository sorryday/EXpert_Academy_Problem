package D1;

import java.io.*;
import java.util.StringTokenizer;

public class OneToOneRockPaperScissors {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A_Input = Integer.parseInt(st.nextToken());
        int B_Input = Integer.parseInt(st.nextToken());

        /**
         * 가위는 1, 바위는 2, 보는 3
         * 비기는 경우는 없음.
         */

        switch (A_Input) {
            case 1:
                if (B_Input == 2)
                    bw.write("B");
                else
                    bw.write("A");
                break;
            case 2:
                if (B_Input == 1)
                    bw.write("A");
                else
                    bw.write("B");
                break;
            case 3:
                if (B_Input == 1)
                    bw.write("B");
                else
                    bw.write("A");
                break;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}