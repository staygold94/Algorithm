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

        // 가변하는 슬라이딩 윈도우
        int start = 0;
        int end = 0;
        int sum = 0;
        int answer = 0;

        while(end < n) {
            
            sum += arr[end];

            // 오른쪽으로 범위를 넓혀가다가 기준을 초과하면 왼쪽을 줄여줌 (start가 end를 넘지 않도록!)
            while(sum > s && start <= end) {
                sum -= arr[start];
                start++;
            }

            if(sum == s) {
                answer++;
            }

            end++;
        }
        
        System.out.println(answer);
    }
}