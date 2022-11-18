package D1;

import java.io.*;

public class Days {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int order = 1;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            int month = Integer.parseInt(input.substring(4, 6));
            int days = Integer.parseInt(input.substring(6, 8));

            if (month == 2) {
                if (days >= 1 && days <= 28) {
                    bw.write("#" + order + " " + input.substring(0, 4) + "/" + input.substring(4, 6) + "/" + input.substring(6, 8)  + "\n");
                } else {
                    bw.write("#" + order + " -1" + "\n");
                }
            } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
                    || month == 10 || month == 12) {
                if (days >= 1 && days <= 31) {
                    bw.write("#" + order + " " + input.substring(0, 4) + "/" + input.substring(4, 6) + "/" + input.substring(6, 8)  + "\n");
                } else {
                    bw.write("#" + order + " -1" + "\n");
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (days >= 1 && days <= 30) {
                    bw.write("#" + order + " " + input.substring(0, 4) + "/" + input.substring(4, 6) + "/" + input.substring(6, 8)  + "\n");
                } else {
                    bw.write("#" + order + " -1" + "\n");
                }
            } else {
                bw.write("#" + order + " -1" + "\n");
            }

            order++;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
