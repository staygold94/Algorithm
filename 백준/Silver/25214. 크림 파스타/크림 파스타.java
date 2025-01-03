import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }

            max = Math.max(max, arr[i] - min);
            sb.append(max + " ");
        }
        System.out.println(sb.toString());
    }
}