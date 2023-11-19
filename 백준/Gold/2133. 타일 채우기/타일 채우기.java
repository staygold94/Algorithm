import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];

        dp[0] = 1;

        for(int i=2; i<n+1; i++) {
            // 1) 이전에 만들어진 짝수번째 타일의 개수 X 3
            dp[i] = dp[i-2] * 3;
            for(int j=i-4; j>=0; j-=2) {
                // 2) 그 전전의 전체 타일 개수 X 이전타일의 특별한 타일 개수
                // 3) 해당 위치에서 만들어지는 특별한 타일 개수 (j가 0일 때)
                dp[i] += dp[j] * 2;
            }
        }

        System.out.println(dp[n]);
    }
}
