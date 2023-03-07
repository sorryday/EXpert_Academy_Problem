package swTest;

import java.io.*;
import java.util.*;

public class TreasureBoxPassword {
    static int N, K; // N : 숫자의 개수, K : k번째로 큰수를 출력해야 한다
    static Set<String> set; // 수를 저장할 set
    static List<Integer> resultList; // 16 -> 10진수로 바꾼 수를 저장할 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            String input = br.readLine();
            set = new LinkedHashSet<>();

            // 회전을 했을 때 만들어지는 수를 저장하자
            int time = N / 4;
            while (time-- > 0) {
                // 회전
                char[] spinedArr = spinNum(input);

                // 회전했다면 만들 수 있는 수를 set에 저장
                for (int j = 0; j < spinedArr.length; j += N / 4) {
                    StringBuilder sb = new StringBuilder();
                    for (int k = j; k < j + N / 4; k++) {
                        sb.append(spinedArr[k]);
                    }
                    set.add(sb.toString());
                }

                // 수를 저장했다면 input을 회전한 것으로 바꿔준다.
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < spinedArr.length; j++) {
                    sb.append(spinedArr[j]);
                }

                input = sb.toString();
            }

            // set 변환
            resultList = new ArrayList<Integer>();
            for (String s : set) {
                resultList.add(Integer.parseInt(s, 16));
            }

            // list 정렬
            Collections.sort(resultList, Collections.reverseOrder());
            bw.write("#" + i +" " + resultList.get(K - 1) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    // 회전하는 함수
    private static char[] spinNum(String input) {
        char[] ch = input.toCharArray();
        // 마지막 수 저장
        char last = ch[ch.length - 1];

        for (int i = ch.length - 1; i >= 1; i--) {
            ch[i] = ch[i - 1];
        }

        // 첫번째에 last 저장
        ch[0] = last;

        return ch;
    }
}















