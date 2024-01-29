import java.util.*;

class Solution {
   public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        // 해시맵에 참가자 명단을 넣는다.
        for(Integer i=0; i<participant.length; i++) {
            map.put(participant[i], i);
        }

        // 해시맵에서 참가자 명단을 제거한다.
        for(Integer i=0; i<completion.length; i++) {
            map.remove(completion[i]);
        }

        for(String key: map.keySet()) {
            answer = key;
        }

        return answer;
    }
}