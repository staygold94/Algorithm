import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String s = br.readLine();
            boolean isValid = true;
            if(s.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            for(int i=0; i<s.length(); i++) {
                char ch = s.charAt(i);
                if(ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if(ch == ')') {
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        isValid = false;
                        break;
                    }
                } else if(ch == ']') {
                    if(!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }
            if(isValid && stack.isEmpty()) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.print(sb.toString());
    }
}