import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];


        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }


        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            int rank = 1;
            for(int j=0; j<n; j++) {
                // 내 순서는 패스
                if(i == j) continue;


                // 나보다 큰 갯수 세기
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) rank++;
            }
            sb.append(rank + " ");
        }
        System.out.print(sb.toString());
    }
}