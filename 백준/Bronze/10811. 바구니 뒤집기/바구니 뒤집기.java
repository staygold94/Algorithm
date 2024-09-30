import java.util.*;
import java.io.*;

public class Main {
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];

        for(int i=0; i<=n; i++) {
            arr[i] = i;
        }

        for(int k=0; k<m; k++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int i=a; i<=(a+b)/2; i++) {
                int j = a + b - i;
                swap(i, j);
            }
        }

        for(int i=1; i<=n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}