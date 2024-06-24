import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        int idx = 0;
        int total = 0;

        // 모든 트럭을 다리로 올리기
        while(idx < truck_weights.length) {
            time++;

            // 다리를 다 건넌 트럭이 있는지 확인 -> 있는 경우 빠져나옴
            if(!queue.isEmpty()) {
                int[] arr = queue.peek();
                if(time - arr[0] == bridge_length) {
                    total -= arr[1];
                    queue.poll();
                }
            }

            // 다리가 비어있거나 무게를 초과하지 않는 경우
            if(queue.isEmpty() || weight >= total + truck_weights[idx]) {

                int[] arr = new int[2];
                arr[0] = time;
                arr[1] = truck_weights[idx];
                total += arr[1];
                queue.offer(arr);
                idx++;
            }
        }

        // 다리를 다 건널 때까지
        while(!queue.isEmpty()) {
            time++;

            int[] arr = queue.peek();
            if(time - arr[0] == bridge_length) {
                queue.poll();
            }
        }

        return time;
    }
}