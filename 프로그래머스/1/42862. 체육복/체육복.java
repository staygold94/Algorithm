import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 시작값 : 도난당하지 않은 학생수
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 전체 학생
        int[] arr = new int[n];
        
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {      
                // 가지고 왔는데 도난당한 경우
                if(lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                }
            }
        }
        
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {      
                if(lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                }
            }
        }
        
        return answer;
    }
}