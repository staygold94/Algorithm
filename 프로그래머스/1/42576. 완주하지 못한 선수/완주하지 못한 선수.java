import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        // 참여자 명단 put
        for(int i=0; i<participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        
        // 완주자 명단 update
        for(int i=0; i<completion.length; i++) {
            if(map.get(completion[i]) > 1) {
                map.put(completion[i], map.getOrDefault(completion[i], 0) - 1);
            } else {
                map.remove(completion[i]);
            }
        }
        
        // 남아있는 key가 완주하지 못한 선수
        for(String str : map.keySet()) {
            answer = str;
        } 
        
        return answer;
    }
}