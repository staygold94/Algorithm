import java.io.*;

public class Main {
    public static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new boolean[n][n];

        dfs(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sb.append(arr[i][j] ? "*" : " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void dfs(int x, int y, int size) {

        if(size == 1) {
            arr[x][y] = true;
            return;
        }

        int newSize = size / 3;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(i == 1 && j == 1) continue;
                dfs(x + newSize * i, y + newSize * j, newSize);
            }
        }
    }
}