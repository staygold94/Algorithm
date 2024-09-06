import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int len = str.length();
        int n = Integer.parseInt(st.nextToken());
        double sum = 0;

        for(int i=0; i<len; i++) {
            char ch = str.charAt(i);
            int num;
            if(ch >= 65 && ch <= 90) {
                num = ch - 55;
            } else {
                num = ch - 48;
            }
            sum += Math.pow(n, len-i-1) * num;
        }
        System.out.printf("%.0f", sum);
    }
}