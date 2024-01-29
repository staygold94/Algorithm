import java.util.*;

class Solution {
   public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        // 해시맵에 참가자 명단을 넣는다.
        for(Integer i=0; i<participant.length; i++) {
            map.put(participant[i], map.containsKey(participant[i]) ? map.get(participant[i]) + 1 : 1);
        }

        // 해시맵에서 참가자 명단을 제거한다.
        for(Integer i=0; i<completion.length; i++) {
            if(map.get(completion[i]) > 1)
                map.put(completion[i], map.get(completion[i]) - 1);
            else
                map.remove(completion[i]);
        }

        for(String key: map.keySet()) {
            answer = key;
        }
        return answer;
    }
}