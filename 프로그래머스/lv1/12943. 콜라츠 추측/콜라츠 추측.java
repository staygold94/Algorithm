class Solution {
    public int solution(int num) {
        int answer = 0;  // 기본값 (1 입력시 해당 값 리턴)
        
        // 입력값이 1이 아니고, 500번 미만 반복한 경우
        while(num != 1 && answer < 500) {
            // 1-1. 입력된 수가 짝수라면
            if(num % 2 == 0) {
                num /= 2;
            // 1-2. 입력된 수가 홀수라면
            } else {
                num = num * 3 + 1;
            }
            answer++;
            
            // 반복횟수가 500번을 넘거나 num(int형)의 오버플로우가 발생하여 num이 음수가 된 경우
            // answer는 -1로 지정, 반복문 break
            if(answer > 500 || num < 0) {
                answer = -1;
                break;
            }
        }
        
        return answer;
    }
}