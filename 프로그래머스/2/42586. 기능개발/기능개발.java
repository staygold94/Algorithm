import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++) {
            queue.offer(i);
        }
        
        int day = 1;
        int cnt = 0;
        
        while(!queue.isEmpty()) {
            // 완료된 작업이 있다면 큐에서 제거
            int idx = queue.peek();
            if(progresses[idx] + speeds[idx] * day >= 100) {
                queue.poll();
                cnt++;
            } else {
                if(cnt != 0) {
                    list.add(cnt);
                    cnt = 0;
                }
                day++;
                             
            }
        }
        if(cnt != 0) list.add(cnt);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}