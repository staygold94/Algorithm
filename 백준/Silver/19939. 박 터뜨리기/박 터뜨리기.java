import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int minSum = k * (k+1) / 2;

        // 최소 차이 합보다 작으면 -1 리턴
        if(n < minSum) {
            System.out.println("-1");
            return;
        }

        // 기본값 세팅
        int[] arr = new int[n];
        for(int i=0; i<k; i++) {
            arr[i] = i+1;
            n -= arr[i];
        }

        if(n % k == 0) {
            System.out.println(k-1);
        } else {
            System.out.println(k);
        }
    }
}