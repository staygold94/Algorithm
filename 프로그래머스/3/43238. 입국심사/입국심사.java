import java.util.*;

class Solution {
    // 이분탐색을 통해 최솟값 구하기
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times); // 정렬

        // 시작점과 끝점 지정 (끝점 = 사람 수 * 오래 걸리는 심사대)
        long start = 0;
        long end = (long)n * times[times.length-1];

        while(start <= end) {
            // 중간값
            long mid = (start + end) / 2;
            // 검사 수
            long count = 0;
            for(int i=0; i<times.length; i++) {
                count += mid / times[i];
            }
            // 검사수가 부족한 경우
            if(count < n) {
                start = mid + 1;

            // 검사수가 차는 경우
            } else {
                end = mid - 1;
                answer = mid;   // 더 최솟값이 있을 수 있다
            }
        }
        return answer;
    }
}