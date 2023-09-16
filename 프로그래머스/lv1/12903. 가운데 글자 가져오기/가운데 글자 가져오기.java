class Solution {
    public String solution(String s) {
        String answer = "";
        int half = s.length()/2;
        
        // 짝수인 경우, 홀수인 경우 substring 범위 다름
        answer = (s.length()%2 == 0) ? (s.substring(half-1, half+1)) : (s.substring(half, half+1));
        
        return answer;
    }
}