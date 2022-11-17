package D2;

import java.io.*;
import java.util.Scanner;

public class View {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int order = 1;
        for (int k = 0; k < 10; k++) {
            int T = sc.nextInt();
            int[] building = new int[T];
            for (int i = 0; i < T; i++) {
                building[i] = sc.nextInt();
            }

            int result = 0;
            for (int i = 2; i <= T - 3; i++) {
                int target = building[i];
                if (building[i - 2] <= target && building[i - 1] <= target &&
                        building[i + 1] <= target && building[i + 2] <= target) {
                    result += building[i] - Math.max(Math.max(building[i + 1], building[i + 2]), Math.max(building[i - 2], building[i - 1]));
                }
            }

            bw.write("#" + order + " " + Integer.toString(result) + "\n");
            order += 1;
        }

        bw.flush();
        bw.close();
    }
}
