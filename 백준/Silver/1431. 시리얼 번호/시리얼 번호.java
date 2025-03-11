import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //System.out.println((int)'0');
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for(int i=0; i<n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1.length() == o2.length()) {
                if(sum(o1) == sum(o2)) {
                    return o1.compareTo(o2);
                } else {
                    return sum(o1) - sum(o2);
                }
            } else {
                return o1.length() - o2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            sb.append(s + "\n");
        }
        System.out.print(sb.toString());
    }

    public static int sum(String s) {
        int sum = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9') sum += ch - 48;
        }
        return sum;
    }
}