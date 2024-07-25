import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, k;
    public static String str;
    public static char[][] board;
    public static int[][][] dp;     // -1: 미방문, 0:방문하였으나 유효x, 1: 방문하였고 유효
    public static int[] moveX = {-1, 0, 1, 0};
    public static int[] moveY = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 행
        m = Integer.parseInt(st.nextToken());   // 열
        k = Integer.parseInt(st.nextToken());   // 이동 가능한 수

        // 배열 초기화 및 입력
        board = new char[n][m];
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<m; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        
        // 타겟팅 문자열 입력
        str = br.readLine();

        // dp 초기화
        dp = new int[n][m][str.length()];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // 배열 순회하면서 dfs 실행하여 answer 구함
        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                // 첫 시작 글자인 경우
                if(board[i][j] == str.charAt(0)) {
                    answer += dfs(i, j, 0);
                }
            }
        }

        // 정답 출력
        System.out.println(answer);
    }

    public static int dfs(int x, int y, int idx) {
        
        // 이미 방문한 경로인 경우
        if(dp[x][y][idx] != -1) {
            return dp[x][y][idx];
        }

        // 마지막 경로인 경우
        if(idx == str.length() - 1) {
            dp[x][y][idx] = 1;
            return dp[x][y][idx];
        }


        // 경로 초기화
        dp[x][y][idx] = 0;

        // 이동 가능한 글자 더하기
        for(int i=1; i<=k; i++) {
            for(int j=0; j<4; j++) {
                int newX = x + moveX[j] * i;
                int newY = y + moveY[j] * i;

                // 보드판 바깥으로 넘어가는 경우 패스
                if(newX < 0 || newY < 0 || newX >= n || newY >= m) {
                    continue;
                }

                // 이동할 곳이 다음 인덱스와 글자가 일치하는 경우
                if(board[newX][newY] == str.charAt(idx + 1)) {
                    dp[x][y][idx] += dfs(newX, newY, idx+1);
                }
            }
        }
        return dp[x][y][idx];
    }
}