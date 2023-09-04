class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        // 더할 숫자를 long 타입으로 맞춰주는 게 이번 문제의 키포인트다.
        // int로 할 경우 오버플로우가 발생한다.
        long num = 0;
        
        for(int i=0; i<n; i++) {
            num += x;
            answer[i] = num;
        }
        
        return answer;
    }
}