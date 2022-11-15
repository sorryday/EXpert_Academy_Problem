import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int order = 1;

        for (int i = 0; i < T; i++) {
            int result = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                int inputNum = Integer.parseInt(st.nextToken());
                if (inputNum % 2 != 0) {
                    result += inputNum;
                }
            }

            bw.write("#" + Integer.toString(order) + " " + Integer.toString(result) + "\n");
            order++;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
