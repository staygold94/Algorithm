import java.io.*;
import java.util.*;

public class Main {
    static class Regt {
        int x1, y1, x2, y2;

        public Regt(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
    public static int n;
    public static Regt[] arr;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new Regt[n];
        visited = new boolean[n];
        int answer = 0;

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            arr[i] = new Regt(x1, y1, x2, y2);          
        }

        dfs(new Regt(0, 0, 0, 0));

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                answer++;
                dfs(arr[i]);
            }
        }
        System.out.println(answer);
    }

    public static void dfs(Regt r) {

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                Regt tmp = arr[i];

                // 완전히 떨어져 있는 경우
                if(tmp.x2 < r.x1 || tmp.x1 > r.x2 || tmp.y2 < r.y1 || tmp.y1 > r.y2) continue;

                // 하나의 사각형이 다른 사각형 안에 들어가 있는 경우 (겹치지 않는다고 판단)
                if((r.x1 < tmp.x1 && r.x2 > tmp.x2 && r.y1 < tmp.y1 && r.y2 > tmp.y2)
                || (tmp.x1 < r.x1 && tmp.x2 > r.x2 && tmp.y1 < r.y1 && tmp.y2 > r.y2)) continue;

                visited[i] = true;
                dfs(tmp);
            }
        }
    }
}