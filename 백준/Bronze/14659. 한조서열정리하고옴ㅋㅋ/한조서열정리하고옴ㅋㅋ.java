import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = toi(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = toi(st.nextToken());
        }

        int answer = 0;
        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=i+1; j<n; j++) {
                if(arr[i] < arr[j]) break;
                count++;
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }

    public static int toi(String s) {
        return Integer.parseInt(s);
    }
}