import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        // 배열 값 받기
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        Arrays.sort(arr);

        int answer = 0;

        if(n == 1) {
            answer += arr[0];
        } else {
            // 양수 조합
            int rightIdx = arr.length - 1;
            // 인덱스 범위이며 배열[인덱스가] 값이 양수인 경우
            while(rightIdx >= 0 && arr[rightIdx] > 0) {
                if(rightIdx > 0 && arr[rightIdx - 1] > 0) {
                    // 양수의 경우 곱하는 것보다 더하는 게 클 수도 있다! 1인 경우
                    answer += Math.max(arr[rightIdx] + arr[rightIdx -1], arr[rightIdx] * arr[rightIdx - 1]);
                    rightIdx -= 2;
                } else {
                    answer += arr[rightIdx];
                    rightIdx--;
                }
            }

            // 음수 조합
            int leftIdx = 0;
            while(leftIdx < arr.length && arr[leftIdx] <= 0) {
                if(leftIdx < arr.length - 1 && arr[leftIdx + 1] <= 0) {
                    answer += arr[leftIdx] * arr[leftIdx + 1];
                    leftIdx += 2;
                } else {
                    answer += arr[leftIdx];
                    leftIdx++;
                }
            }
        }

        System.out.println(answer);

    }
}