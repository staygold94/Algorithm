import java.util.*;

class Solution {
    public static boolean[] visited;
    public static ArrayList<String> paths;
    public String[] solution(String[][] tickets) {
        // 방문 티켓 배열 초기화
        visited = new boolean[tickets.length];

        // 방문 경로 배열 초기화
        paths = new ArrayList<>();

        // 너비우선탐색 호출
        bfs(tickets, "ICN", 0, "ICN");

        // 방문 경로 오름차순 정렬
        Collections.sort(paths);
        
        // 오름차순 첫번째 경로 리턴
        return paths.get(0).split(" ");
    }

    public void bfs(String[][] tickets, String begin, int depth, String route) {

        // 마지막까지 왔다면
        if(depth == tickets.length) {
            paths.add(route);
            return;
        }

        // 티켓 출발지가 begin 과 같다면 bfs 호출
        for(int i=0; i<tickets.length; i++) {
            // 방문한 적 없고
            // 출발지가 begin인 경우
            if(!visited[i] && tickets[i][0].equals(begin)) {
                visited[i] = true;      // 방문 처리
                bfs(tickets, tickets[i][1], depth+1, route + " " + tickets[i][1]);
                visited[i] = false;
            }
        }
        return;
    }
}