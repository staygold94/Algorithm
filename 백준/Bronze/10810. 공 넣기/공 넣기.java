import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];

        for(int k=0; k<m; k++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            for(int i=x; i<=y; i++) {
                arr[i] = num;
            }
        }

        for(int i=1; i<=n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}