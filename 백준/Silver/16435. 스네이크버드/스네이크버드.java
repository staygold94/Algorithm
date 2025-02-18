import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = toi(st.nextToken());
        int l = toi(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = toi(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0; i<n; i++) {
            if(arr[i] <= l) {
                l++;
            } else {
                break;
            }
        }
        System.out.println(l);
    }

    public static int toi(String s) {
        return Integer.parseInt(s);
    }
}