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

        // 최대공약수 구하기
        int num = 0;
        for(int i=0; i<n-1; i++) {
            int distance = arr[i+1] - arr[i];   // 나무 사이의 간격
            num = gcd(distance, num);
        }

        System.out.println((arr[n-1] - arr[0]) / num - n + 1);
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;

        return gcd(b, a%b);
    }
}
