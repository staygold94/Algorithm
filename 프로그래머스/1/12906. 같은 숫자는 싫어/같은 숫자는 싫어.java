import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        // 스택 생성
        Stack<Integer> stack = new Stack<>();
        for(int i:arr) {
            // 빈 스택이 아닌 경우
            if(!stack.isEmpty()) {
                if(stack.peek() != i) stack.push(i);  // 후입과 동일한 숫자가 아닌 경우 push
            // 빈 스택인 경우
            } else {
                stack.push(i);
            } 
        }

        // 스택 길이만큼 answer 배열 선언
        int[] answer = new int[stack.size()];
        for(int i=answer.length-1; i >= 0; i--) {  // 배열 맨뒤부터 스택 pop 하여 저장
            answer[i] = stack.pop();
        }

        return answer;
    }
}