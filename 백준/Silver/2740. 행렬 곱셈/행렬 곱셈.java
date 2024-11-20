import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 행렬
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr1 = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 두 번째 행렬
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr2 = new int[m][k];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<k; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 정답 행렬 구하기 (곱셈)
        int[][] answer = new int[n][k];

        for(int i=0; i<k; i++) {
            for(int j=0; j<n; j++) {
                for(int p=0; p<m; p++) {
                    answer[j][i] += arr1[j][p] * arr2[p][i];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<k; j++) {
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}