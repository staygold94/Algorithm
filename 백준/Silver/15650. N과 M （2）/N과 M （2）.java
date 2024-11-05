import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static boolean[] visited;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        sb = new StringBuilder();

        dfs("", 0, 1);
        System.out.print(sb.toString());
    }

    public static void dfs(String str, int depth, int num) {
        if(depth == m) {
            sb.append(str + "\n");
            return;
        }

        for(int i=num; i<=n; i++) {
            dfs(str + i + " ", depth + 1, i+1);
        }
    }
}