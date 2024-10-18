import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        boolean[] isValid = new boolean[300001];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        for(int i=0; i<n-2; i++) {
            for(int j=i+1; j<n-1; j++) {
                for(int k=j+1; k<n; k++) {
                    if(arr[i] + arr[j] + arr[k] <= 300000) isValid[arr[i] + arr[j] + arr[k]] = true;
                }
            }
        }

        int answer = -1;
        for(int i=m; i>0; i--) {
            if(isValid[i]) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}