import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        int answer = 0;

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            if(s.equals("ENTER")) {
                set.clear();
                continue;
            }
            if(!set.contains(s)) {
                set.add(s);
                answer++;
            }
        }

        System.out.println(answer);
    }
}