import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 도난 당하지 않은 인원
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 도난 당했으나 가져온 인원 구하기
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }

        // 빌릴 수 인원 구하기
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}