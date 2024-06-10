import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int total = 0;
        int idx = 0;
        Queue<Integer> queue = new LinkedList<>();

        // 다리를 0으로 가득 채움 (0은 트럭 없음)
        for(int i=0; i<bridge_length; i++) {
            queue.offer(0);
        }

        // 트럭 리스트만큼 반복
        while(idx < truck_weights.length) {
            // 가장 앞에 있는 것 빼기
            int num = queue.poll();
            total -= num;           // 토탈 무게 빼기
            time++;                 // 시간 증가

            // 무게가 추가 되어도 되는 경우
            if(weight >= total + truck_weights[idx]) {
                total += truck_weights[idx];
                queue.offer(truck_weights[idx]);    // 현재 인덱스의 트럭 추가
                idx++;                              // 인덱스 이동
            } else {
                queue.offer(0);
            }
        }
        // 마지막으로 들어온 트럭에 대해서 다리길이만큼 시간 증가
        time += bridge_length;

        return time;
    }
}