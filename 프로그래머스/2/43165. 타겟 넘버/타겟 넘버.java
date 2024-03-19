class Solution {
    public int count = 0;
    public int solution(int[] numbers, int target) {

        // 깊이우선탐색(DFS) - 재귀로 호출(stack)
        dfs(numbers, 0, target, 0);
        return count;
    }

    public void dfs(int[] numbers, int depth, int target, int sum) {
        // 마지막 depth 가면 return
        if(depth == numbers.length) {
            // 타겟값이면 count++
            if(target == sum) count++;
            return;
        }

        // 합/차 각각 dfs 접근
        dfs(numbers, depth+1, target, sum + numbers[depth]);
        dfs(numbers, depth+1, target, sum - numbers[depth]);
    }
}