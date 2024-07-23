import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            // n만큼 배열 입력
            int[] arr = new int[n];
            for(int j=0; j<n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            // 최소공약수의 합 구하기
            long sum = 0;
            for(int j=0; j<arr.length-1; j++) {
                for(int k=j+1; k<arr.length; k++) {
                    sum += gcd(arr[j], arr[k]);
                }
            }
            System.out.println(sum);
        }
    }

    public static int gcd(int a, int b) {
        
        while(b > 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}