import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        // 바위 정렬
        Arrays.sort(rocks);

        // 이분 탐색 범위
        int left = 0;
        int right = distance;

        // 최소구간을 찾아보자!
        while(left <= right) {
            int mid = (left + right) / 2;
            int brokenRocks = getBrokenRocks(rocks, mid, distance);
            // 돌은 주어진 갯수보다 많이 부순 경우 최소구간 줄이기
            if(brokenRocks > n) {
                right = mid - 1;
            // 주어진 수보다 적거나 같은 경우 -> 다시 탐색
            } else {
                left = mid + 1;
                answer = mid;   // 최대 값을 찾기 위해 계속 갱신
            }
        }

        return answer;
    }

    // 최소 구간값(min)보다 작은 경우 돌을 부순다.
    public int getBrokenRocks(int[] rocks, int min, int distance) {
        int cnt = 0;
        int prev = 0;   // 출발지점부터 첫번째 돌까지의 거리
        for(int rock : rocks) {
            // 최소 구간값(min) 보다 적으면 돌을 부순다
            if(rock - prev < min) {
                cnt++;
            } else {
                prev = rock;
            }
        }

        // 마지막돌부터 도착지점까지 거리 비교
        if(distance - prev < min) cnt++;

        return cnt;
    }
}