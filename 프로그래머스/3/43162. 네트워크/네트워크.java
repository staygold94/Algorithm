class Solution {
    public static boolean[] visited; // 방문 배열
    public int solution(int n, int[][] computers) {
        int answer = 0; // 네트워크 개수
        
        // 방문 배열 및 카운트 초기화
        visited = new boolean[n];

        // dfs 호출
        for(int i=0; i<computers.length; i++) {
            // 방문되지 않은 네트워크에 대한 dfs 호출하여 연결된 네트워크 방문
            // 네트워크 개수 증가
            if(!visited[i]) {
                dfs(computers, i);
                answer++;
            }
        }

        return answer;
    }

    // 깊이우선탐색을 이용하여 연결된 네트워크 찾기
    public static void dfs(int[][] computers, int num) { // num = 현재 네트워크

        for(int i=0; i<computers[num].length; i++) {
            // 현재 네트워크와 연결되어 있고(1), 아직 방문하지 않은 경우 
            if(computers[num][i] == 1 && !visited[i]) {
                visited[num] = true; // 방문 true 처리
                dfs(computers, i);   // dfs 탐색 
            }
        }
    }
}