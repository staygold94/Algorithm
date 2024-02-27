class Solution {
    public static boolean[] visit;  // 방문한 던전 (인덱스 저장)
    public static int max = 0;      //  방문최댓값

    public int solution(int k, int[][] dungeons) {

        visit = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return max;
    }

    public static void dfs(int depth, int remain, int[][] dungeons) {

        for(int i=0; i<dungeons.length; i++) {
            // 이미 방문했거나, 남은 체력보다 소모량이 크다면 방문하지 않는다.
            if(visit[i] == true || remain < dungeons[i][0]) continue;
            
            // 방문처리
            visit[i] = true;
            // 재귀로 depth를 깊게 들어간다.
            dfs(depth+1, remain-dungeons[i][1], dungeons);
            // 다 돌았으면 false 처리
            visit[i] = false;
        }
        // 현재 depth가 방문최댓값보다 크다면, 방문최댓값을 변경해준다.
        if(depth > max) max = depth;
        // 이미 방문최댓값이 나왔다면 return 해준다.
        if(depth == dungeons.length) return;
    }
}