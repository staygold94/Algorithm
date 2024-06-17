class Solution {
    public int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, 0);

        return answer;
    }

    public void dfs(int[] numbers, int target, int depth, int total) {

        if(depth == numbers.length) {
            if (total == target) {
                answer++;
            }
            return;
        }

        dfs(numbers, target, depth+1, total + numbers[depth]);
        dfs(numbers, target, depth+1, total + (numbers[depth] * -1));
    }
}