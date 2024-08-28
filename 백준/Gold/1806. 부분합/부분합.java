import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;
        long sum = 0;

        while(right < n) {
            sum += arr[right];

            while(sum >= s && left <= right) {
                if(sum >= s) {
                    answer = Math.min(answer, right - left + 1);
                }

                sum -= arr[left];
                left++;
            }

            right++;
        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}