class Solution {
    public String solution(String[] seoul) {

        // 배열 인덱스 위치
        int idx = 0;
        
        for(String str : seoul) {
            if(str.equals("Kim")) break;  // 문자열 비교함수 equals
            idx++;
        }
        
        return "김서방은 " + String.valueOf(idx) + "에 있다";
    }
}