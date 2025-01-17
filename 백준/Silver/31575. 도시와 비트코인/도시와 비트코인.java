import java.util.*;
import java.io.*;

public class Main {
    public static class Road {
        int x, y;

        Road(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];
        int[][] visited = new int[m][n];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(visited[i], -1); 
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Road> queue = new LinkedList<>();
        // 초기값
        queue.offer(new Road(0,0));
        visited[0][0] = 1;

        while(!queue.isEmpty()) {
            Road r = queue.poll();
            
            if(r.x + 1 < m && visited[r.x + 1][r.y] == -1) {
                if(arr[r.x + 1][r.y] == 1) {
                    visited[r.x + 1][r.y] = 1;
                    queue.offer(new Road(r.x+1, r.y));
                }
            }

            if(r.y + 1 < n && visited[r.x][r.y + 1] == -1) {
                if(arr[r.x][r.y + 1] == 1) {
                    visited[r.x][r.y + 1] = 1;
                    queue.offer(new Road(r.x, r.y+1));
                }
            }
        }
        
        System.out.println(visited[m-1][n-1] == 1 ? "Yes" : "No");
    }
}