import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 배열 입력 받음
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);   // 이진 탐색을 위해 정렬 처리

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int left = findLeftIdx(num);
            // 수가 존재하지 않는다면
            if(left < 0) {
                sb.append("0 ");
                continue;
            }
            int right = findRightIdx(num);
            sb.append((right - left + 1) + " ");
        }
        System.out.println(sb.toString());
    }

    public static int findLeftIdx(int num) {

        int left = 0;
        int right = n-1;
        int mid  = (left + right) / 2;
        int result = -1;
        
        while(left <= right) {
            mid = (left + right) / 2;

            if(arr[mid] < num) {
                left = mid + 1;
            } else if(arr[mid] > num) {
                right = mid - 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }
        return result;
    }

    public static int findRightIdx(int num) {

        int left = 0;
        int right = n-1;
        int mid  = (left + right) / 2;
        int result = -1;
        
        while(left <= right) {
            mid = (left + right) / 2;

            if(arr[mid] < num) {
                left = mid + 1;
            } else if(arr[mid] > num) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }
        return result;
    }
}