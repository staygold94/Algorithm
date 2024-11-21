import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String condition = st.nextToken();
            if(condition.equals("enter")) set.add(name);
            else set.remove(name);
        }

        List<String> list = new ArrayList<>(set);
        Collections.sort(list, Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++) {
            sb.append(list.get(i) + "\n");
        }
        System.out.print(sb.toString());
    }
}