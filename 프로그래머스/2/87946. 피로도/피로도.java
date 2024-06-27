class Solution {
    public int answer = 0;
    public boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length]; 
        dfs(k, dungeons, 0);

        return answer;
    }

    public void dfs(int k, int[][] dungeons, int depth) {

        if(depth > answer) answer = depth;

        for(int i=0; i<dungeons.length; i++) {
            // 방문하지 않았고, 현재 남은 체력이 최소 피로도 이상이면
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, depth+1);
                visited[i] = false;
            }
        }
    }
}