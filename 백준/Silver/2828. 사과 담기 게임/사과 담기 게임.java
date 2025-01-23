import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = 1 + m - 1;

        int j = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i=0; i<j; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num >= left && num <= right) {
                continue;
            } else {
                if(num < left) {
                    answer += left - num;
                    right -= left - num;
                    left = num;
                } else {
                    answer += num - right;
                    left += num - right;
                    right = num;
                }
            }
        }
        System.out.println(answer);
    }
}