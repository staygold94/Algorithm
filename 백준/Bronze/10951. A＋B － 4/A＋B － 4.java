import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            int answer = 0;

            while(st.hasMoreTokens()) {
                answer += Integer.parseInt(st.nextToken());
            }

            System.out.println(answer);
        }
    }
}
