import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        // 들어온 배열 정렬 처리
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 도난 당하지 않은 친구 수
        int answer = n - lost.length;

        // 도난 당했으나 여벌이 있는 친구 순 구해서 answer에 더함
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

        // 빌릴 수 있는 친구 카운트
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