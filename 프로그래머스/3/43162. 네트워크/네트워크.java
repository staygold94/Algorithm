import java.util.*;

class Solution {
    public int answer = 0;                          // 네트워크 갯수
    public boolean[] visited;                       // 방문여부
    public HashMap<Integer, List<Integer>> map;     // 연결된 네트워크 해시맵
    public int solution(int n, int[][] computers) {

        // 방문여부 초기화
        visited = new boolean[n];

        // computers 해시맵 생성
        map = new HashMap<>();

        // 해시맵에 연결된 네트워크 저장
        for(int i=0; i<computers.length; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<computers[i].length; j++) {
                if(computers[i][j] == 1 && i != j) list.add(j);
            }
            map.put(i, list);
        }

        // dfs로 갯수 세기
        for(int i=0; i<computers.length; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        return answer;
    }

    public void dfs(int idx) {

        // 방문처리
        visited[idx] = true;

        // 더 방문할 곳이 있다면 방문
        List<Integer> list = map.get(idx);
        for(int i=0; i<list.size(); i++) {
            int nextIdx = list.get(i);
            if(!visited[nextIdx]) {
                dfs(nextIdx);
            }
        }
    }
}