class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a) {
            // n의 몫만큼 교환하고 
            int trade = (n / a) * b;
            n = n % a + trade;
            answer += trade;
        }

        return answer;
    }
}