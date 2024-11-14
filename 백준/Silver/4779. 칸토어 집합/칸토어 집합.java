import java.util.*;
import java.io.*;

public class Main {
    public static int num;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        sb = new StringBuilder();

        while((s = br.readLine()) != null) {
            num = Integer.parseInt(s);
            dfs("-", 0);
        }
        System.out.print(sb.toString());
    }

    public static void dfs(String kanto, int depth) {

        // depth에 도달한 경우
        if(depth == num) {
            sb.append( kanto + "\n");
            return;
        }

        String tmp = kanto + String.format("%" + kanto.length() + "s", "") + kanto;
        dfs(tmp, depth+1);
    }
}