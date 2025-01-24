import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        int min = Math.abs(a - b);
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(min > Math.abs(b - num)) {
                min = Math.abs(b - num);
                answer = 1;
                a = num;
            }
        }
        answer += Math.abs(a - b);
        System.out.println(answer);
    } 
}