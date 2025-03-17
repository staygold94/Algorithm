import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int setMin = Integer.MAX_VALUE;
        int sepMin = Integer.MAX_VALUE;
        int answer = Integer.MAX_VALUE;

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            setMin = Math.min(setMin, Integer.parseInt(st.nextToken()));
            sepMin = Math.min(sepMin, Integer.parseInt(st.nextToken()));
        }

        answer = Math.min(answer, n % 6 == 0 ? setMin * (n / 6) : setMin * (n / 6 + 1)); // 세트
        answer = Math.min(answer, sepMin * n); // 낱개
        answer = Math.min(answer, setMin * (n / 6) + sepMin * (n % 6)); // 세트 + 낱개
        
        System.out.println(answer);
    }
}