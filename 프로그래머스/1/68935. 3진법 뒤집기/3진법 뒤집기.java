class Solution {
    public int solution(int n) {
        String answer = "";

        while(n >= 3) {
            answer += n % 3;
            n /= 3;
        }
        answer += n;

        return Integer.parseInt(answer, 3);
    }
}