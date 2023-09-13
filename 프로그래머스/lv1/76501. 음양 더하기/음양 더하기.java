class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int idx = 0;  // absolutes의 인덱스값
        
        // sign이 true면 그대로 더하고, false면 -1를 곱해 더함
        for(boolean sign : signs) {
            answer += (sign) ? absolutes[idx] : absolutes[idx]*-1;
            idx++;
        }
        
        return answer;
    }
}