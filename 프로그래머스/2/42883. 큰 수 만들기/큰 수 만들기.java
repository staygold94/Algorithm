import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        Stack<Character> stack = new Stack<>();

        // 앞에 최대한 큰 숫자가 오는 게 이 문제의 핵심!
        for(int i=0; i<number.length(); i++) {
            char ch = number.charAt(i);
            // 제거할 숫자가 남아있고
            // 스택이 비어있지 않으며
            // 스택에 들어간 값이 더 작은 경우 pop
            while(cnt < k
                && !stack.isEmpty()
                && stack.peek() < ch) {
                    stack.pop();
                    cnt++;
            }
            stack.push(ch);
        }

        // 제거가 안된 만큼 더 제거
        while(cnt < k) {
            stack.pop();
            cnt++;
        }

        for(char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}