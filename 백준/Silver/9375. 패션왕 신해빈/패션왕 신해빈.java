import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int m = Integer.parseInt(br.readLine());
            for(int j=0; j<m; j++) {
                String[] arr = br.readLine().split(" ");
                map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
            }

            int total = 1;
            for(String s : map.keySet()) {
                total *= (map.get(s) + 1);
            }
            total -= 1;
            sb.append(total + "\n");
        }
        System.out.print(sb.toString());
    }
}