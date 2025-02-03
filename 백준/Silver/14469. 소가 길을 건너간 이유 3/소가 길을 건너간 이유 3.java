import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];        
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }
        Arrays.sort(arr, (a, b) -> {
            return a[0] - b[0];
        });

        int now = 0;

        for(int i=0; i<n; i++) {
            if(now < arr[i][0]) {
                now = arr[i][0] + arr[i][1];
            } else {
                now += arr[i][1];
            }
        }

        System.out.println(now);
    }
}