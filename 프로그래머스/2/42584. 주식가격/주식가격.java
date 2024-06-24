import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int time = 0;

        // 스택에 쌓기
        while(idx < prices.length) {
            // 주식가격이 내려가는 경우 pop
            while(!stack.isEmpty() && prices[stack.peek()] > prices[idx]) {
                int popInx = stack.pop();
                answer[popInx] = time - popInx;
            }
            stack.push(idx);
            idx++;
            time++;
        }

        // 스택값이 있는 경우 pop
        while(!stack.isEmpty()) {
            int popInx = stack.pop();
            answer[popInx] = time - popInx - 1;
        }

        return answer;
    }
}