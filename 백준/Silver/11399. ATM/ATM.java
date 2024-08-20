import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] sumArr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 빠른 순서대로 정렬
        Arrays.sort(arr);

        // 누적합 구하기
        int answer = 0;
        for(int i=0; i<n; i++) {
            sumArr[i] = arr[i];
            if(i > 0) sumArr[i] += sumArr[i-1];
            answer += sumArr[i];
        }
        System.out.println(answer);
    }
}