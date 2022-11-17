package D1;

import java.io.*;

public class DigitPlus {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            result += input.charAt(i) - '0';
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}

