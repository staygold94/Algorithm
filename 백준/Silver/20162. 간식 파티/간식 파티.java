import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[t];
        int[] dp = new int[t];

        for(int i=0; i<t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for(int i=0; i<t; i++) {
            int max = 0;
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j]) max = Math.max(max, dp[j]);
            }
            dp[i] = max + arr[i];
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}