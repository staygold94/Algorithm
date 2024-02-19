import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 작업배열을 들어오는 순으로 정렬
        Arrays.sort(jobs, (a, b) -> (a[0] - b[0]));

        // 우선순위 큐 생성 (소요시간에 따라 정렬)
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        int idx = 0;    // jobs idx
        int cnt = 0;    // 작업완료된 job 개수
        int time = 0;   // 현재 시간
        int answer = 0; // 소요 시간

        // 배열 인덱스를 다 읽지 않았거나 큐가 비어있지 않은 경우 반복문 실행
        while(cnt < jobs.length) {

            // 인덱스가 배열 길이를 넘지 않는 경우
            // 이미 들어온 요청에 대해서 큐에 작업을 넣는다.
            while(idx < jobs.length && time >= jobs[idx][0]) {
                queue.add(jobs[idx++]);
            }
            // 큐에 값이 없는 경우 새로 들어오는 job의 도착시간을 현재 시간으로 맞춘다.
            if(queue.isEmpty()) {
                time = jobs[idx][0];
            
            // 큐에 값이 있는 경우 현재 시간에 작업시간을 더한다.
            } else {
                int[] job = queue.poll();
                answer += time - job[0] + job[1];
                time += job[1];
                cnt++;
            }
        }

        return answer / jobs.length;
    }
}