import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 스코빌 지수 넣기
        for(int i : scoville) {
            queue.offer(i);
        }

        // 스코빌 지수가 1개 남을 때까지 섞어본다
        while(queue.size() > 1) {
            // 모든 음식이 K 스코빌을 넘긴 경우 리턴
            if(queue.peek() >= K) {
                break;
            }

            int x = queue.poll();
            int y = queue.poll();
            int newScoville = x + y * 2;
            queue.offer(newScoville);
            answer++;
        }

        // 한 번도 섞지 않아도 모두 K 이상이라면 answer가 0인 리턴 값도 필요함
        return queue.peek() >= K ? answer : -1;
    }
}