import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[][] answer = new int[n][m];

        for(int i=0; i<n; i++) {
            Arrays.fill(answer[i], Integer.MAX_VALUE);
        }

        for(int i=0; i<n; i++) {
            String[] tmp = br.readLine().split("");
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        Deque<int[]> deque = new LinkedList<>();
        int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // 초기값 넣기
        deque.offerFirst(new int[] {0, 0});
        answer[0][0] = 0;
 
        while(!deque.isEmpty()) {
            int[] room = deque.poll();
            int x = room[0];
            int y = room[1];

            for(int[] move : moves) {
                int newX = x + move[0];
                int newY = y + move[1];

                if(newX < 0 || newX >= n || newY < 0 || newY >= m) continue;

                // 방이면서, 탐색할 가치가 있는 곳(현재 횟수가 더 적은 경우)
                if(arr[newX][newY] == 0 && answer[newX][newY] > answer[x][y]) {
                    answer[newX][newY] = answer[x][y];
                    deque.offerFirst(new int[] {newX, newY});
                }

                // 벽이면서, 탐색할 가치가 있는 곳(현재 횟수가 더 적은 경우)
                if(arr[newX][newY] == 1 && answer[newX][newY] > answer[x][y] + 1) {
                    answer[newX][newY] = answer[x][y] + 1;
                    deque.offerLast(new int[] {newX, newY});
                }
            }
        }
        System.out.println(answer[n-1][m-1]);
    }
}