class Solution {
    public boolean solution(int x) {
        boolean answer = false;  // 기본값
        
        int tmp = x; // x값을 담아둔 변수
        int sum = 0; // x의 자릿수 더한 값
        
        while(tmp > 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        
        if(x % sum == 0) {
            answer = true;
        }
        
        return answer;
    }
}