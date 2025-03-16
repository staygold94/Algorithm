import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String s = br.readLine();
        int answer = 0;

        while(str.indexOf(s) > -1) {
            int idx = str.indexOf(s);
            str = str.substring(Math.min((idx + s.length()), str.length()));
            answer++;
        }
        System.out.println(answer);
    }
}