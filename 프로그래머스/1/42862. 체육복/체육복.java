import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 전체수 - 도난당한수
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 도난당했으나 여별이 있는 친구
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

        // 빌릴 수 있는 친구
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i] == reserve[j] -1 || lost[i] == reserve[j] +1) {
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