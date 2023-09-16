import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        // 문자 배열로 변환
        char[] chars = s.toCharArray();
        
        // 오름차순 정렬
        Arrays.sort(chars);
        
        // 맨끝부터 answer에 더함
        for(int i=chars.length-1; i>=0; i--) answer += chars[i];
        
        return answer;
    }
}