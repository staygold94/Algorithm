import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 나무의 수
        long m = Long.parseLong(st.nextToken());   // 가져갈 나무의 길이
        long[] arr = new long[n];

        long left = 0;
        long right = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        long answer = 0;
        while(left <= right) {
            long mid = (left + right) / 2;

            long sum = 0;
            for(int i=0; i<arr.length; i++) {
                // 벌목할 나무가 있을 때만 더함
                if(arr[i] - mid > 0) sum += arr[i] - mid;
            }

            if(sum >= m) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}