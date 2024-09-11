import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for(int i=0; i<n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (s1, s2) -> {

            if(s1.length() != s2.length()) {
                return Integer.compare(s1.length(), s2.length());
            }

            return s1.compareTo(s2);
        });

        int idx = 0;
        StringBuilder sb = new StringBuilder();
        String str = "";

        while(idx < n) {
            if(!str.equals(arr[idx])) {
                str = arr[idx];
                sb.append(str + "\n");
            } else {
                idx++;
            }
        }

        System.out.print(sb.toString());
    }   
}
