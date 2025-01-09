import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[][] dp = new long[10][64];

        // 초기값
        for(int i=0; i<10; i++) {
            dp[i][0] = 1L;
        }
        for(int i=0; i<64; i++) {
            dp[0][i] = 1L;
        }
        
        for(int i=1; i<64; i++) {
            for(int j=1; j<10; j++) {
                dp[j][i] = dp[j-1][i] + dp[j][i-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            int num = Integer.parseInt(br.readLine()) - 1;
            long sum = 0;
            for(int j=0; j<10; j++) {
                sum += dp[j][num];
            }
            sb.append(sum + "\n");
        }
        System.out.print(sb.toString());
    }
}