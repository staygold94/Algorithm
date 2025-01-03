import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>();

        HashSet<String> map = new HashSet<>();

        for(int i=0; i<n; i++) {
            map.add(br.readLine());
        }

        for(int i=0; i<m; i++) {
            String s = br.readLine();
            if(map.contains(s)) {
                list.add(s);
            }
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size() + "\n");
        for(String s : list) {
            sb.append(s + "\n");
        }
        System.out.print(sb.toString());
    }
}