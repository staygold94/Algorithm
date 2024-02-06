import java.util.*;

class Solution {
    boolean solution(String s) {

        // 스택 생성
        Stack<Character> stack = new Stack<>();

        // 들어온 변수가 홀수인 경우 무조건 false 반환
        if(s.length() % 2 != 0) {
            return false;
        } else {
            for(int i=0; i<s.length(); i++) {
                // 효율성을 위해 split 하지 않고, charAt 메서드를 사용하여 Char형으로 접근
                Character c = s.charAt(i);
    
                // 처음부터 닫는괄호가 나오면 false 리턴
                if(stack.isEmpty() && c.equals(')')) {
                    return false;
    
                // 여는 괄호면 스택에 쌓고, 닫는 괄호면 스택에서 여는 괄호를 하나 제거한다
                } else {
                    if(c.equals('(')) {
                        stack.push(c);
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        return stack.isEmpty() ? true : false;
    }
}