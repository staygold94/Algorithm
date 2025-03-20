import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean isTag = false;

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '<') isTag = true;

            if(!isTag && ch != ' ') {
                stack.push(ch);
            } else {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(ch);
                if(ch == '>') isTag = false;
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.print(sb.toString());
    }
}