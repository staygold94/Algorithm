import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n-1];

        int now, next;
        st = new StringTokenizer(br.readLine());
        now = Integer.parseInt(st.nextToken());
        for(int i=0; i<n-1; i++) {
            next = Integer.parseInt(st.nextToken());
            arr[i] = next - now;
            now = next;
        }

        Arrays.sort(arr);

        int answer = 0;
        for(int i=0; i<n-k; i++) {
            answer += arr[i];
        }
        System.out.println(answer);
    }
}
