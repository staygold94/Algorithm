import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];

        long left = 1;
        long right = 0;

        for(int i=0; i<k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(arr[i], right);
        }

        long answer = 0;

        while(left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;

            for(int i=0; i<arr.length; i++) {
                cnt += arr[i] / mid;
            }

            if(cnt >= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}