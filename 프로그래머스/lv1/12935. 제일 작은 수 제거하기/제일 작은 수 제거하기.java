import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        // 최소값
        int minVal = Arrays.stream(arr).min().orElse(Integer.MAX_VALUE);
        
        // 배열 길이가 1인 경우 -1 리턴
        // 이외에는 최소값 필터링 해서 리턴
        int[] answer = (arr.length == 1) ? ( new int[] {-1} ) : (Arrays.stream(arr).filter(val -> val != minVal).toArray());
        
        return answer;

    }
}