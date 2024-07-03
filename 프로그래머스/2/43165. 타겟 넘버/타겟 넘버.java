class Solution {
    public int answer = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int now, int depth) {
        if(numbers.length == depth) {
            if(now == target) answer++;
            return;
        }
        
        dfs(numbers, target, now - numbers[depth], depth + 1);
        dfs(numbers, target, now + numbers[depth], depth + 1);
    }
}