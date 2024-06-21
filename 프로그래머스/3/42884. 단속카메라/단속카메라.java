import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        // 도착지점을 기준으로 오름차순 정렬
        Arrays.sort(routes, (o1, o2) -> (o1[1] - o2[1]));

        int cam = Integer.MIN_VALUE;

        for(int i=0; i<routes.length; i++) {
            // 캠이 출발지점보다 이전에 있다면
            // 도착지점 캠을 추가 설치
            if(cam < routes[i][0]) {
                cam = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}