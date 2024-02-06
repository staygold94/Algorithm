import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0; // 순서

        // 우선순위 큐를 사용하는 문제
        // PriorityQueue 생성자에 Comparator 인터페이스를 구현한 Collections.reverseOrder()를 인수로 넣어준다.
        // => 내림차순 우선순위 큐
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        // 들어온 대기 배열을 우선순위 큐에 넣는다
        for(int i:priorities) {
            queue.offer(i);
        }

        // 우선순위 큐에 값이 있는 동안 반복문 수행
        while(!queue.isEmpty()) {
            for(int i=0; i<priorities.length; i++) {
                // 우선순위 큐에서 가장 높은 값과 대기 배열의 값이 일치하는 경우
                // 순서를 1 더해지고, 우선순위 큐에서 비교한 값을 제거한다
                if(priorities[i] == queue.peek()) {
                    answer++;
                    queue.poll();
                    // i번째와 알고 싶은 프로세스 위치가 일치하는 경우
                    if(i == location) return answer;
                }
            }
        }

        return answer;
    }
}