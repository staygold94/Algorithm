class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 약수는 나머지가 0으로 떨어지는 수다.
        // 하지만 for문을 돌면서 구한다면? 수가 클수록 비용이 증가한다.
        
        // 약수를 구할 때 시간복잡도를 줄이기 위해서는
        // 제곱근까지만 보면 된다.
        for(int i=1; i * i <= n; i++) {
            
            // 제곱근일 때
            if(i * i == n) {
                answer += i;
            } else if(n % i == 0) { // 약수를 찾았을 때, 반대약수까지 더하기
                answer += i + n / i;
            }
        }
        
        System.out.println(answer);
        
        return answer;
    }
}