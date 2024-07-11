import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        // 배열 입력 받음
        for(int i=0; i<n; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        long answer = 0;

        // 3개의 직사각형으로 나누는 경우는 총 6가지임
        // 가로세로가 섞인 방식 1~4가지
        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                long case1_1 = sum(0, i, 0, j);
                long case1_2 = sum(i, n, 0, j);
                long case1_3 = sum(0,n, j, m);
                answer = Math.max(answer, case1_1 * case1_2 * case1_3);

                long case2_1 = sum(0, n, 0, j);
                long case2_2 = sum(0, i, j, m);
                long case2_3 = sum(i,n, j, m);
                answer = Math.max(answer, case2_1 * case2_2 * case2_3);

                long case3_1 = sum(0, i, 0, j);
                long case3_2 = sum(0, i, j, m);
                long case3_3 = sum(i,n, 0, m);
                answer = Math.max(answer, case3_1 * case3_2 * case3_3);

                long case4_1 = sum(0, i, 0, m);
                long case4_2 = sum(i, n, 0, j);
                long case4_3 = sum(i,n, j, m);
                answer = Math.max(answer, case4_1 * case4_2 * case4_3);
            }
        }

        // 오로지 가로로, 세로로만 나누는 방식 -> 2가지
        for(int i=1; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                long case1_1 = sum(0, i, 0, m);
                long case1_2 = sum(i, j, 0, m);
                long case1_3 = sum(j,n, 0, m);
                answer = Math.max(answer, case1_1 * case1_2 * case1_3);
            }
        }

        for(int i=1; i<m; i++) {
            for(int j=i+1; j<m; j++) {
                long case2_1 = sum(0, n, 0, i);
                long case2_2 = sum(0, n, i, j);
                long case2_3 = sum(0,n, j, m);
                answer = Math.max(answer, case2_1 * case2_2 * case2_3);
            }
        }

        System.out.println(answer);
    }

    // 직사각형 내에 있는 숫자의 합
    public static long sum(int r1, int r2, int c1, int c2) {
        long result = 0L;
        for(int i=r1; i<r2; i++) {
            for(int j=c1; j<c2; j++) {
                result += arr[i][j];
            }
        }
        return result;
    }
}