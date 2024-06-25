import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int idx = 0;
        int cnt = 0;
        int len = jobs.length;

        // 도착 순서대로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        // 소요시간대로 정렬하는 우선순위큐
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        // 요청이 모두 완료될 때까지
        while(cnt < len) {

            // 현재 시간 전에 도착한 요청이라면 큐에 넣는다
            while(idx < len && jobs[idx][0] <= time) {
                queue.offer(jobs[idx]);
                idx++;
            }

            // 큐가 비어있지 않다면 가장 금방 끝나는 요청이 빠져나옵니다
            if(!queue.isEmpty()) {
                int[] arr = queue.poll();
                time += arr[1];           // 현재 시간
                answer += time - arr[0];  // 요청 ~ 완료시간 까지 누적
                cnt++;
            } else {
                time = jobs[idx][0];
            }
        }

        return answer / len;
    }
}