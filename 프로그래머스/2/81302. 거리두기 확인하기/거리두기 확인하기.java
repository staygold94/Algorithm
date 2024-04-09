import java.util.*;

class Solution {
    public Queue<int[]> queue;
    public boolean[][] visited;
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for(int k=0; k<places.length; k++) {
            // 대기실 선언
            char[][] place = new char[5][5];

            // 대기실 구성 요소 넣기
            for(int j=0; j<5; j++) {
                place[j] = places[k][j].toCharArray();
            }

            visited = new boolean[5][5];

            boolean result = true;

            // P인 경우 queue에 넣어 탐색
            for(int i=0; i<place.length; i++) {
                for(int j=0; j<place[i].length; j++) {
                    if(place[i][j] == 'P') {
                        // 거리두기 결과값을 넣어준다
                        if((!bfs(place, i, j, 0))) {
                            result = false;
                            break;
                        }
                        
                    }
                }
            }
            
            answer[k] = !result ? 0 : 1;
        }  

        return answer;
    }

    public boolean bfs(char[][] place, int x, int y, int dep) {

        queue = new LinkedList<>();

        // 현재 위치 넣어주기
        queue.offer(new int[] {x, y, dep});
        visited[x][y] = true;

        // 큐에 값이 있는 동안 탐색
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int row = arr[0];
            int col = arr[1];
            int depth = arr[2];

            // depth가 2 초과라면 그냥 지나갈게요
            if(depth > 2) continue;

            // 시작값이 아니고 P인 경우 false 리턴
            if(depth != 0 && place[row][col] == 'P') {
                return false;
            }

            // 상하 좌우
            for(int i=0; i<4; i++) {
                int newRow = row + dx[i];
                int newCol = col + dy[i];

                // 배열 접근 범위 내에 들어가고, 파티션이 아닌 경우 탐색 대상에 추가한다
                if(newRow >= 0 && newRow < 5 && newCol >= 0  && newCol < 5 &&
                    place[newRow][newCol] != 'X' &&
                    !visited[newRow][newCol]) {
                        queue.offer(new int[] {newRow, newCol, depth+1});
                        visited[newRow][newCol] = true;
                }
            }
        }

        return true;
    }

}