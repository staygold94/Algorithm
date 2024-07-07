import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];     // 순회 정보 배열
            visited = new boolean[n+1];   // 방문정보 배열
            st = new StringTokenizer(br.readLine());

            // 순회 정보 구성
            for(int j=1; j<=n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            
            // 사이클 수
            int cnt = 0;
            for(int j=1; j<=n; j++) {
                if(!visited[j]) {
                    dfs(arr, j);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

    public static void dfs(int[] arr, int idx) {

        visited[idx] = true;

        if(!visited[arr[idx]]) {
            dfs(arr, arr[idx]);
        }
    }
}