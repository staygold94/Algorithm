import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[201];

        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[num + 100]++;
        }

        int q = Integer.parseInt(br.readLine()) + 100;
        System.out.println(arr[q]);
    }
}