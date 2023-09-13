class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int len = phone_number.length();
        
        // 뒤의 네자리 제외하고 * 추가
        for(int i=0; i<len-4; i++)
            answer += "*";
        
        // 나머지 네자리 잘라서 
        answer += phone_number.substring(len-4, len);
        
        return answer;
    }
}