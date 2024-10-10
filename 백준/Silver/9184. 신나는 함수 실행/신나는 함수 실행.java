import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][][] dp = new int[21][21][21];

        // 기본값
        dp[0][0][0] = 1;

        // a, b, c 중 0이 있는 경우 1로 초기값
        for(int i=0; i<=20; i++) {
            for(int j=0; j<=20; j++) {
                for(int k=0; k<=20; k++) {
                    if(i == 0 || j == 0 || k == 0) {
                        dp[i][j][k] = 1;
                    }
                }
            }
        }

        // bottom-up 방식으로 dp 구함
        for(int i=1; i<=20; i++) {
            for(int j=1; j<=20; j++) {
                for(int k=1; k<=20; k++) {
                    if(i<j && j<k) {
                        dp[i][j][k] = dp[i][j][k-1] + dp[i][j-1][k-1] - dp[i][j-1][k];
                    } else {
                        dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-1][k] + dp[i-1][j][k-1] - dp[i-1][j-1][k-1];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1) {
                break;
            }

            sb.append("w(" + a + ", " + b + ", " + c + ") = ");

            if(a <= 0 || b <= 0 || c <= 0) {
                sb.append("1");
            } else if (a > 20 || b > 20 || c > 20) {
                sb.append(dp[20][20][20]);
            } else {
                sb.append(dp[a][b][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}