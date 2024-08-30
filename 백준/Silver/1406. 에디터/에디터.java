import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        StringTokenizer st;
        int n = sb.length();
        int cursor = n;
        int cnt = Integer.parseInt(br.readLine());

        for(int i=0; i<cnt; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(s.equals("L")) {
                if(cursor > 0) cursor--;
            } else if(s.equals("D")) {
                if(cursor < sb.length()) cursor++;
            } else if(s.equals("B")) {
                if(cursor > 0) sb.deleteCharAt(--cursor);
            } else {
                String tmp = st.nextToken();
                sb.insert(cursor++, tmp);
            }
        }
        System.out.println(sb.toString());
    }
}