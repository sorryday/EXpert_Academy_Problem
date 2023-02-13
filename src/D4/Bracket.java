package D4;

import java.io.*;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= 10; i++) {
            int charLength = Integer.parseInt(br.readLine());
            String inputChar = br.readLine();
            Stack<Character> characterStack = new Stack<>();
            boolean flag = true;

            for (int j = 0; j < charLength; j++) {
                if (!flag) {
                    break;
                } else {
                    switch (inputChar.charAt(j)) {
                        case '(' :
                            characterStack.push('(');
                            break;
                        case ')' :
                            if (characterStack.isEmpty() || characterStack.peek() != '(') {
                                flag = false;
                            } else if (characterStack.peek() == '('){
                                characterStack.pop();
                            }
                            break;

                        case '[' :
                            characterStack.push('[');
                            break;
                        case ']' :
                            if (characterStack.isEmpty() || characterStack.peek() != '[') {
                                flag = false;
                            } else if (characterStack.peek() == '['){
                                characterStack.pop();
                            }
                            break;

                        case '{' :
                            characterStack.push('{');
                            break;
                        case '}' :
                            if (characterStack.isEmpty() || characterStack.peek() != '{') {
                                flag = false;
                            } else if (characterStack.peek() == '{'){
                                characterStack.pop();
                            }
                            break;

                        case '<' :
                            characterStack.push('<');
                            break;
                        case '>' :
                            if (characterStack.isEmpty() || characterStack.peek() != '<') {
                                flag = false;
                            } else if (characterStack.peek() == '<'){
                                characterStack.pop();
                            }
                            break;
                    }
                }
            }
            if (flag) {
                bw.write("#" + i + " " + 1 + "\n");
            } else {
                bw.write("#" + i + " " + 0 + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}