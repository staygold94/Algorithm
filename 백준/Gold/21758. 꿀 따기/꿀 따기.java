import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] sum = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i == 0) sum[i] = arr[i];
            else sum[i] = sum[i-1] + arr[i];
        }

        int answer = -1;

        // 벌 - 벌 - 꿀
        for(int i=1; i<n-1; i++) {
            answer = Math.max(answer, (sum[n-1] - arr[0] - arr[i]) + (sum[n-1] - sum[i]));
        }

        // 벌 - 꿀 - 벌
        for(int i=1; i<n-1; i++) {
            answer = Math.max(answer, (sum[i] - arr[0]) + (sum[n-2] - sum[i-1]));
        }

        // 꿀 - 벌 - 벌
        for(int i=1; i<n-1; i++) {
            answer = Math.max(answer, sum[i-1] + (sum[n-2] - arr[i]));
        }

        System.out.println(answer);
    }
}