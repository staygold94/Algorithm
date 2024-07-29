import java.io.*;
import java.util.*;

public class Main {
    public static int n, c;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];

        // 배열 입력 받기
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);   // 정렬

        // 초기값 (공유기간 거리이므로 1부터 arr[n-1] - arr[0]) 
        int left = 1;
        int right = arr[n-1] - arr[0];
        int answer = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            int cnt = getWifiCnt(mid);

            if(cnt >= c) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        System.out.println(answer);
    }

    public static int getWifiCnt(int mid) {
        int cnt = 1;
        int prev = arr[0];

        for(int i=1; i<n; i++) {
            if(arr[i] - prev >= mid) {
                prev = arr[i];
                cnt++;
            }
        }
        return cnt;
    }
}