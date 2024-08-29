import java.io.*;
import java.util.*;

public class Main {
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            // 프로그램 종료
            if(w == 0 && h == 0) break;

            arr = new int[h][w];

            for(int i=0; i<h; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int answer = 0;

            for(int i=0; i<arr.length; i++) {
                for(int j=0; j<arr[i].length; j++) {
                    if(arr[i][j] == 1) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    public static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        int[][] moves = {{0, 1} , {0, -1}, {1, 0}, {-1, 0}, {-1, 1},  {-1, -1}, {1, 1}, {1, -1}};

        arr[x][y] = 0;
        queue.offer(new int[] {x, y});

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            for(int i=0; i<moves.length; i++) {
                int newX = tmp[0] + moves[i][0];
                int newY = tmp[1] + moves[i][1];

                // 범위를 넘어가는 경우 넘어감
                if(newX < 0 || newX >= arr.length || newY < 0 || newY >= arr[0].length) continue;

                if(arr[newX][newY] == 1) {
                    arr[newX][newY] = 0;
                    queue.offer(new int[] {newX, newY});
                }
            }
        }
    }
}