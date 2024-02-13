import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int second = 0;

        Queue<Integer> queue = new LinkedList<>();

        // 다리 길이만큼 큐 기본값 0 채우기
        for(int i=0; i<bridge_length; i++) {
            queue.offer(0);
        }
        
        int sum = 0;    // 현재 무게
        int idx = 0;    // 다리에 진입할 트럭 인덱스

        // 마지막 트럭(인덱스)가 진입할 때까지 반복
        while(idx < truck_weights.length) {
            // 다리길이 유지를 위해
            // 큐에 이미 들어온 건 빼주고 시간은 더해준다.
            while(queue.size() >= bridge_length) {
                sum -= queue.poll();
                second++;
            }

            // 들어올 트럭
            int truck = truck_weights[idx];
            // 총량을 넘지 않는다면 트럭을 넣고, 총량을 넘지 않으면 0을 넣어준다.
            if(weight >= sum + truck) {
                sum += truck;
                queue.offer(truck);
                idx++;
            } else {
                queue.offer(0);
            }  
        }

        // 마지막 트럭이 나갈 수 있도록 다리 길이만큼 시간을 더해준다.
        second += bridge_length;
        
        return second;
    }
}