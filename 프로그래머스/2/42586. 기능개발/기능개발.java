import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        // 총 걸리는 시간을 queue에 push
        for(int i=0; i<progresses.length; i++) {
            queue.offer((int)Math.ceil((100 - progresses[i]) / (double)speeds[i]));
        }
        
        // queue에 값이 있다면 poll
        while (!queue.isEmpty()) {
            int num = queue.poll();
            int cnt = 1;
            // 선출 작업보다 빨리 끝난 작업이 있다면 같이 poll
            while(!queue.isEmpty() && num >= queue.peek()) {
                queue.poll();
                cnt++;
            }
            list.add(cnt);
        }   
        
        int[] answer = new int[list.size()];
        for(int i=0 ;i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}