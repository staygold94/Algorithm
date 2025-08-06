import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        StringTokenizer st = new StringTokenizer(sb.toString());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();

        
        for(int i=1; i<=a; i++) {
            String str = br.readLine();
            map.put(str, String.valueOf(i));
            map.put(String.valueOf(i), str);
        }

        sb = new StringBuilder();
        for(int i=0; i<b; i++) {
            String str = br.readLine();
            sb.append(map.get(str) + "\n");
        }

        System.out.println(sb.toString());
    }
}