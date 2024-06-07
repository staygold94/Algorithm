import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<prices.length; i++) {
            // stack에 값이 있다면
            while (!stack.isEmpty()) {
                int[] arr = stack.peek();
                // 이전 주식가격이 더 높다면
                if(prices[i] < arr[0]) {
                    answer[arr[1]] = i - arr[1];
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(new int[] {prices[i], i}); 
        }
        
        while(!stack.isEmpty()) {
            int[] arr = stack.pop();
            answer[arr[1]] = prices.length - 1 - arr[1];
        }
        
        return answer;
    }
}