import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);

        int left = 0;
        int right = distance;

        while(left <= right) {
            int mid = (left + right)  / 2;
            int bronkenRocks = getBrokenRocks(distance, rocks, mid);

            if(bronkenRocks <= n) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public int getBrokenRocks(int distance, int[] rocks, int mid) {
        int cnt = 0;
        int prev = 0;

        for(int i=0; i<rocks.length; i++) {
            if(rocks[i] - prev < mid) {
                cnt++;
            } else {
                prev = rocks[i];
            }
        }
        if(distance - prev < mid) cnt++;

        return cnt;
    }
}