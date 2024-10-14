import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            String[] arr = br.readLine().split(" ");
            int r = Integer.parseInt(arr[0]);
            String s = arr[1];

            for(int j=0; j<s.length(); j++) {
                for(int k=0; k<r; k++) {
                    sb.append(s.charAt(j));
                }
            }

            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}