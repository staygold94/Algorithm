import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        // 도착지점을 기준으로 오름차순 정렬
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        // 캠 위치
        int cam = Integer.MIN_VALUE;

        for(int i=0; i<routes.length; i++) {
            // 현재 캠의 위치가 출발 지점보다 작다면 새로 캠을 설치한다
            if(cam < routes[i][0]) {
                cam = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}