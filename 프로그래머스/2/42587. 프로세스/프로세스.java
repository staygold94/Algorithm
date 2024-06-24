import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<priorities.length; i++) {
            queue.offer(i);
        }

        int[] sortedArr = Arrays.copyOf(priorities, priorities.length);
        Arrays.sort(sortedArr);             // 우선순위 정렬
        int idx = sortedArr.length - 1;     // 현재 가장 높은 우선순위

        while(!queue.isEmpty()) {
            int num = queue.peek();

            // 우선순위가 가장 높다면
            if(priorities[num] == sortedArr[idx]) {
                answer++;
                // 현재 프로세스가 특정 프로세스라면 정답이므로 break
                if(num == location) {
                    break;
                }
                queue.poll();
                idx--;
            } else {
                queue.offer(queue.poll());
            }
        }

        return answer;
    }
}