import java.util.*;

class Solution {
    public int solution(String before, String after) {
        int answer = 1;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<before.length(); i++) {
            map.put(before.charAt(i), map.getOrDefault(before.charAt(i), 0) + 1);
        }

        for(int i=0; i<after.length(); i++) {
            map.put(after.charAt(i), map.getOrDefault(after.charAt(i), 0) - 1);
        }

        for(char ch : map.keySet()) {
            if(map.get(ch) != 0) {
                answer = 0;
                break;
            }
        }
        
        return answer;
    }
}