import java.util.*;
import java.io.*;

public class Main {
    public static class Robot {
        int x;
        int y;
        int d;

        public Robot(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Robot> queue = new LinkedList<>();
        int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        // 시작값 입력
        queue.offer(new Robot(x, y, d));

        while(!queue.isEmpty()) {
            Robot r = queue.poll();

            // 1. 현재 칸이 아직 청소되지 않은 경우 현재 칸을 청소한다.
            if(arr[r.x][r.y] == 0 && !visited[r.x][r.y]) {
                answer++;
                visited[r.x][r.y] = true;
            }

            // 갈 길이 있는지 확인
            boolean noWay = true;
            for(int i=0; i<4; i++) {
                int newD = (r.d + 3 - i) % 4;
                int newX = r.x + moves[newD][0];
                int newY = r.y + moves[newD][1];

                // 갈 길이 있는 경우
                if(newX >= 0 &&  newX < n && newY >= 0 && newY < m && arr[newX][newY] == 0 && !visited[newX][newY]) {
                    queue.offer(new Robot(newX, newY, newD));
                    noWay = false;
                    break;
                }
            }

            // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
            // 2-2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
            if(noWay) {
                // 2-1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                int newX = r.x - moves[r.d][0];
                int newY = r.y - moves[r.d][1];

                // 후진할 수 없는 경우 break
                if(newX < 0 || newX >= n || newY < 0 || newY >= m || arr[newX][newY] == 1) {
                    break;
                }

                queue.offer(new Robot(newX, newY, r.d));
            }
        }
        System.out.println(answer);
    }
}