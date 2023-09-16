class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        // char 배열로 변환
        char[] chars = s.toCharArray();
        
        // for문 돌면서 숫자가 아닌 경우, false 대입 후 break로 반복문 빠져나옴
        if(chars.length == 4 || chars.length == 6) {
            for(char c:chars) {
                if(c < '0' || c > '9') {
                    answer = false;
                    break;
                }
            }
        } else {
            answer = false;
        }
        
        
        return answer;
    }
}