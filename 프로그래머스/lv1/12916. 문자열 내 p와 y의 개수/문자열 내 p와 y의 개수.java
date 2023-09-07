class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        // 대소문자 구분 없기 위해 모두 대문자로 변경
        s = s.toUpperCase();
        // 각 문자의 개수
        int countP = 0;
        int countY = 0;

        // 문자열 길이만큼 for문 
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);   // 문자열 i번째의 문자
            
            if(c == 'P') countP++;
            if(c == 'Y') countY++;        
        }
        
        // 문자열에 P와 Y가 포함되고, 그 값이 동일한 경우 true
        if(countP == countY) {
                answer = true;
        }

        return answer;
    }
}