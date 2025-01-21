import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];

            StringTokenizer st;
            for(int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

            int cnt = 0;
            int max = n+1;
            for(int j=0; j<n; j++) {
                if(arr[j][1] < max) {
                    max = arr[j][1];
                    cnt++;
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.print(sb.toString());
    }
}