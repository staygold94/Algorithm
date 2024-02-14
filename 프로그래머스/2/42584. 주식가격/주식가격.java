import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // 주식가격 길이만큼 정답배열 선언
        int len = prices.length;
        int[] answer = new int[len];

        // 주식가격이 떨어지지 않고 유지되는 경우의 인덱스를 담을 스택
        Stack<Integer> stack = new Stack<>();

        // 주식가격 배열을 돌면서 인덱스 push
        for(int i=0; i<len; i++) {

            // 스택에 인덱스가 저장되어 있고,
            // 최근 저장된 인덱스보다 가격이 떨어진 경우라면
            // i - 최근인덱스값을 정답배열[최근인덱스값]에 넣어준다.
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        // 주식가격 배열을 다 돌고 난 후
        // 스택에 값이 없을 때까지 걸린 시간을 정답 배열에 넣어준다.
        // 마지막 인덱스 기준으로 값을 넣어주어야 하는데, 이미 for문을 빠져나왔으므로
        // 마지막 인덱스 값은 len - 1인 셈이다. 여기에 스택에 있던 인덱스 값을 빼주면 된다.
        while(!stack.isEmpty()) {
            answer[stack.peek()] = len - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }
}