import java.io.*;

public class Main {
    public static boolean[][] arr;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new boolean[n][n*2 - 1];

        // 첫번째 꼭지점은 0, n-1에 있음
        dfs(0, n - 1, n);

        sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n*2 -1 ; j++) {
                if(arr[i][j]) sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    // x,y는 꼭지점 위치, n는 n
    public static void dfs(int x, int y, int n) {

        // n이 3인 기본형
        if(n == 3) {
            // 꼭대기
            arr[x][y] = true;
            // 중간
            arr[x+1][y-1] = arr[x+1][y+1] = true;
            // 마지막
            arr[x+2][y-2] = arr[x+2][y-1] = arr[x+2][y] = arr[x+2][y+1] = arr[x+2][y+2] = true;
            return;
        
        // 기타 더 큰 사이즈
        } else {
            // 3개의 삼각형으로 호출
            int newN = n/2;
            dfs(x, y, newN);
            dfs(x+newN, y-newN, newN);
            dfs(x+newN, y+newN, newN);
        }
    }
}