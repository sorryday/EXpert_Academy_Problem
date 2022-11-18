package D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ThreeSixNineGame {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (Integer.toString(i).contains("3") || Integer.toString(i).contains("6")
                    || Integer.toString(i).contains("9")) {
                String numToString = Integer.toString(i);
                for (int j = 0; j < numToString.length(); j++) {
                    if (numToString.charAt(j) == '3' || numToString.charAt(j) == '6' ||
                            numToString.charAt(j) == '9') {
                        bw.write("-");
                    }
                }

                bw.write(" ");
            }

            else {
                bw.write(Integer.toString(i) + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}