class Solution {
    public int[] solution(long n) {
        
        // Long 타입을 String으로 변환하여 길이 구함
        int[] answer = new int[Long.toString(n).length()];
        int i = 0;
        
        while(n > 0) {
            answer[i] = (int) (n % 10);
            n /= 10;
            i++;
        }
        
        return answer;
    }
}