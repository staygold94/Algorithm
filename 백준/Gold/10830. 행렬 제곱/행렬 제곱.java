import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        // 배열 생성
        arr = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        StringBuilder sb = new StringBuilder();
        int[][] result = dfs(b);
        for(int i=0; i<n ;i++) {
            for(int j=0; j<n; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static int[][] dfs(long cnt) {

        if(cnt == 1) return arr;

        int[][] tmp = dfs(cnt/2);
        int[][] result = multi(tmp, tmp);
        if(cnt % 2 == 1) result = multi(result, arr);   // 홀수인 경우 원본 행렬 한 번 더 곱하기

        return result;
    }

    public static int[][] multi(int[][] arr1, int[][] arr2) {

        int[][] tmp = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                for(int p=0; p<n; p++) {
                    tmp[i][j] = (tmp[i][j] + arr1[i][p] * arr2[p][j]) % 1000;
                }
            }
        }

        return tmp;
    }
}
