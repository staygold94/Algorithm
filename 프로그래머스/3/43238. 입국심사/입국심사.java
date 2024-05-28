import java.util.*;

class Solution {
    public long solution(int n, int[] times) {

        Arrays.sort(times);

        long left = 1;
        long right = (long) n * times[times.length - 1]; // 가장 최대치

        // left < right 조건
        while(left < right) {
            long mid = (left + right) / 2;  // 중간 초
            long count = 0;                 // 심사 가능한 사람 수

            // 반복문으로 심사 가능한 사람 수 계산
            for(int i=0; i<times.length; i++) {
                count += mid / times[i];
            }
            
            // 필요 인원 초과시
            if(count >= n) {
                right = mid;

            // 필요인원 이하인 경우
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}