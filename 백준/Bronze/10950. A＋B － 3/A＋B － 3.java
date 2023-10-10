import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());  // 입력받을 횟수

        for(int i=0; i<num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int answer = 0;

            while(st.hasMoreTokens()) {
                answer += Integer.parseInt(st.nextToken());
            }
            
            System.out.println(answer);
        }
    } 
}
