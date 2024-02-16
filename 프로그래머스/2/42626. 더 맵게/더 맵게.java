import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0; // 횟수

        // 우선순위 큐 생성
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i:scoville) {
            queue.offer(i);
        }

        // 목표지수 K보다 낮은 경우 우선순위 큐에서 요소를 꺼내어 계산한다.
        while(queue.peek() < K) {
            // 만약 하나 남았는데도 k보다 작다면 -1를 리턴한다
            if(queue.size() == 1) return -1;
            queue.offer(queue.poll() + (queue.poll() * 2));
            answer++;
        }
        return answer;
    }
}