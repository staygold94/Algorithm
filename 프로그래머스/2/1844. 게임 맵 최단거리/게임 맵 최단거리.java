import java.util.*;

class Solution {
    public int solution(int[][] maps) {

        // 가로 세로
        int n = maps.length;
        int m = maps[0].length;

        // 거리 길이 재기
        int[][] distances = new int[n][m];

        // bfs를 위한 queue 준비
        Queue<int[]> queue = new LinkedList<>();

        // 시작점 넣기
        queue.offer(new int[] {0, 0});
        distances[0][0] = 1;

        // 동서남북 이동을 위한 배열
        int[][] moves = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            // 도착지점인 경우 반환
            if(now[0] == n-1 && now[1] == m-1) {
                return distances[n-1][m-1];
            }

            // 동서남북 이동
            for(int i=0; i<moves.length; i++) {
                int x = now[0] + moves[i][0];
                int y = now[1] + moves[i][1];

                // nxm 범위를 넘어가는 경우 pass
                if(x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }

                // 벽이 경우 pass
                if(maps[x][y] == 0) {
                    continue;
                }

                // 아직 접근하지 않았고, 길인 경우 (동서남북을 보므로 이미 할당한 거리에 대해서는 보지 않는다)
                if(distances[x][y] == 0 && maps[x][y] == 1) {
                    distances[x][y] = distances[now[0]][now[1]] + 1;
                    queue.offer(new int[] {x, y});
                }
            }
        }

        // 접근 불가한 경우
        return -1;
    }
}