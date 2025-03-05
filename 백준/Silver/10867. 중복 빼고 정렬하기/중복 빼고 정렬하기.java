import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
        int now = -1001;
        Arrays.sort(arr);

        for(int i=0; i<n; i++) {
            if(now != arr[i]) {
                sb.append(arr[i] + " ");
                now = arr[i];
            }
        }
        System.out.print(sb.toString());
    }
}