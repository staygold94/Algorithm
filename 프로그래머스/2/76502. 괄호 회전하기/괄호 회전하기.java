import java.util.*;

class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = 0;

        for(int i=0; i<len; i++) {
            if(isValid(s)) {
                answer++;
            }
            s = s.substring(1) + s.charAt(0);
        }
        
        return answer;
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    stack.push(ch);
                    break;
                } else {
                    char tmp = stack.peek();
                    if ((tmp == '(' && ch == ')') || (tmp == '{' && ch == '}') || (tmp == '[' && ch == ']')) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
}