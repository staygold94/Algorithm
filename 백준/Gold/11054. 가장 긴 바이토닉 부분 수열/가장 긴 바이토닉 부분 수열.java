import java.util.*;
import java.io.*;

public class Main {

    static int num;
    static int[] arr;
    static Integer[] dp1;
    static Integer[] dp2;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        arr = new int[num];
        dp1 = new Integer[num];
        dp2 = new Integer[num];

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 테스트 값 입력받음
        for(int i=0; i<num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순, 내림차순 부분 배열 수 구함
        for(int i=0; i<num; i++) {
            solveUp(i);
            solveDown(i);
        }

        int answer = 0;

        // 바이토닉 수열 = 오름차순 + 내림차순 - 중복값 1개
        for(int i=0; i<num; i++) {
            answer = Math.max(answer, dp1[i] + dp2[i]);
        }

        // 오름차순과 내림차순 배열을 더하면 중복되는 값이 1개 있으므로 빼준다.
        System.out.print(answer - 1);
    }

    static Integer solveUp(int n) {

        if(dp1[n] == null) {

            dp1[n] = 1;

            for(int i=n-1; i>=0; i--) {
                if(arr[i] < arr[n]) {
                    dp1[n] = Math.max(dp1[n], solveUp(i) + 1);
                }   
            }
        }
        return dp1[n];
    }

    static Integer solveDown(int n) {

        if(dp2[n] == null) {

            dp2[n] = 1;

            for(int i=num-1; i>=n; i--) {
                if(arr[i] < arr[n]) {
                    dp2[n] = Math.max(dp2[n], solveDown(i) + 1);
                }   
            }
        }
        return dp2[n];
    }
}
