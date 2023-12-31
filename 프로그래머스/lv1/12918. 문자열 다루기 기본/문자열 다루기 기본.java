class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        /*
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
        */
        
        // 정규식 풀이도 있다. 엄청 간단하고 좋은 듯!
        answer = s.matches("[0-9]{4}|[0-9]{6}");
        
        
        return answer;
    }
}