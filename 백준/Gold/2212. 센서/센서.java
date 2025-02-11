import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dist = new int[n-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0; i<n-1; i++) {
            dist[i] = arr[i+1] - arr[i];
        }

        Arrays.sort(dist);

        long answer = 0;
        for(int i=0; i<n-k; i++) {
            answer += dist[i];
        }
        System.out.println(answer);
    }
}