class Solution {
    public int answer = 0;                          // 네트워크 갯수
    public boolean[] visited;                       // 방문여부
    public int solution(int n, int[][] computers) {

        // 방문여부 초기화
        visited = new boolean[n];

        // dfs로 갯수 세기
        for(int i=0; i<computers.length; i++) {
            if(!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    public void dfs(int idx, int[][] computers) {

        // 방문처리
        visited[idx] = true;

        // 더 방문할 곳이 있다면 방문
        for(int i=0; i<computers[idx].length; i++) {
            if(!visited[i] && computers[idx][i] == 1) {
                dfs(i, computers);
            }
        }
    }
}