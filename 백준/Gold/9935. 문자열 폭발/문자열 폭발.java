import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        int strLen = str.length();
        int bombLen = bomb.length();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<strLen; i++) {
            stack.push(str.charAt(i));

            if(stack.size() >= bombLen) {
                boolean isBomb = true;
                for(int j=0; j<bombLen; j++) {

                    if(stack.get(stack.size() - bombLen + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                if(isBomb) {
                    for(int j=0; j<bombLen; j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character ch : stack) {
            sb.append(ch);
        }
        System.out.println(stack.isEmpty() ? "FRULA" : sb.toString());
    }
}