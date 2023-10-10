import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        // 토큰이 있는지 확인
        while(st.hasMoreTokens()) {
            answer += Integer.parseInt(st.nextToken());
        } 

        System.out.println(answer);
    }
}
