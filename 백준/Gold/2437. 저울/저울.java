import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        /*
         * 누적합을 이용하여 측정가능한 최대 무게 찾기
         * 만약 추가 '1 1 2 3 6 7 30'라면
         * 1번째 : 0 1
         * 2번째 : 0 1 2
         * 3번째 : 0 1 2 3 4
         * 4번째 : 0 1 2 3 4 5 6
         * 5번째 : 0 1 2 3 4 5 6 7 8 9 10 11 12
         * 6번째 : 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
         * 7번째 : 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 < 30 로, 다음무게 20은 측정 불가
         */
        int sum = 0;
        for(int i=0; i<n; i++) {
            if(sum + 1 < arr[i]) {
                break;
            }
            sum += arr[i];
        }

        System.out.println(sum+1);
    }
}