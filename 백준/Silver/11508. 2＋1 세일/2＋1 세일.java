import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long answer = 0;
        for(int i=0; i<n; i++) {
            if((i+1) % 3 == 0) continue;
            else answer += arr[n-i-1];
        }
        System.out.println(answer);
    }
}