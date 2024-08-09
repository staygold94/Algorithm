import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] nArr = new int[n];
        int[] mArr = new int[m];        

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int a = 0, b = 0;

        // 투포인터
        while(a < n && b < m) {
            if(nArr[a] <= mArr[b]) {
                sb.append(nArr[a++] + " ");
            } else {
                sb.append(mArr[b++] + " ");
            }
        }

        while(a < n) {
            sb.append(nArr[a++] + " ");
        }

        while(b < m) {
            sb.append(mArr[b++] + " ");
        }
        System.out.println(sb.toString());
    }
}