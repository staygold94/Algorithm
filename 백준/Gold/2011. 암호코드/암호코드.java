import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int[] dp = new int[len+1];

        // 0으로 시작하는 경우 해석 불가능
        if(str.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        // 초기값
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=len; i++) {
            int oneDigit = Integer.parseInt(str.substring(i-1, i));
            int twoDigit = Integer.parseInt(str.substring(i-2, i));

            if(oneDigit > 0) {
                dp[i] = dp[i-1] % 1000000;
            }

            if(twoDigit >= 10 && twoDigit <= 26) {
                dp[i] = (dp[i] + dp[i-2]) % 1000000;
            }
        }

        System.out.println(dp[len]);
    }
}