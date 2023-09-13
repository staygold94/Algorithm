class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        // a < b 라는 대소 관계 만들기
        if(a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        // a부터 b까지 합산
        for(int i=a; i<=b; i++)
            answer += Long.valueOf(i);
        
        return answer;
    }
}