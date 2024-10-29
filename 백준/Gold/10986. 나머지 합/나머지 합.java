import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] remain = new long[m];
        long answer = 0;
        int sum = 0;

        // 나머지 갯수 배열 갱신 (0인 경우 답 갱신)
        for(int i=0; i<n; i++) {
            sum = (sum + arr[i]) % m;
            if(sum == 0) answer++;
            remain[sum]++;
        }

        // 나머지 갯수 배열로 카운팅
        for(int i=0; i<m; i++) {
            if(remain[i] > 0) {
                answer += remain[i] * (remain[i] - 1) / 2;
            }
        }
        System.out.println(answer);
    }
}