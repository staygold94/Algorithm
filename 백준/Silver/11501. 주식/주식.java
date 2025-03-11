import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];

            for(int j=0; j<n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            int max = arr[n-1];
            for(int j=n-2; j>=0; j--) {
                if(max >= arr[j]) {
                    answer += (max - arr[j]);
                } else {
                    max = arr[j];
                }
            }
            sb.append(answer + "\n");
        }
        System.out.print(sb.toString());
    }
}