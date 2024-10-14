import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /****************************************************************************************************

        LCS (Xn, Ym) = Xn, Ym의 최장길이 공통 부분 문자열의 길이
        : 가장 마지막 문자가 1) 같은 경우와 2) 다른 경우를 나누어서 점화식을 만들 수 있다.

        LCS(i, j) = Xi와 Yj의 LCS의 길이

        1) 같은 경우 (Xi == Yj)
        LCS(i, j) = LCS(i-1, j-1) + 1 (마지막 문제를 선택해서 길이가 1 증가)

        2) 다른 경우 (Xi != Yj)
        LCS(i, j-1) : X의 i 값이 포함되고, Y의 j 값이 포함되지 않는 경우
        LCS(i-1, j) : X의 i 값이 포함되지 않고, Y의 j 값이 포함되는 경우
        두 가지 경우 중 Maximum 값이 LCS가 된다

        (참고) 둘 다 포함되지 않는 경우는 
        max(LCS(i−1,j),LCS(i,j−1))의 계산 과정에서 자연스럽게 처리되므로 별도로 고려할 필요가 없음

        ****************************************************************************************************/
        
        String[] s1 = br.readLine().split("");
        String[] s2 = br.readLine().split("");
        int n = s1.length;
        int m = s2.length;

        int[][] dp = new int[n + 1][m +1];

        // 초기값
        for(int i=0; i<=n; i++) {
            dp[i][0] = 0;
        }

        for(int i=0; i<=m; i++) {
            dp[0][i] = 0;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(s1[i-1].equals(s2[j-1])) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}