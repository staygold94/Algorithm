import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        // 중요 포인트! 인덱스만 저장해도 prices 값에 접근 가능하다는 점 (기존 풀이에는 인덱스까지 저장함)
        Stack<Integer> stack = new Stack<>();
        stack.push(0);  // 0번째 인덱스 push
        for(int i=1; i<prices.length; i++) {
            // stack에 값이 있다면 현재가가 더 높다면
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i); 
        }
        
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - 1 - idx;
        }
        
        return answer;
    }
}