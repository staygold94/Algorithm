import java.io.*;
import java.util.*;

public class Main {
    public static HashSet<Integer> set;
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        // 초기화
        br = new BufferedReader(new InputStreamReader(System.in));
        set = new HashSet<>();
        sb = new StringBuilder(br.readLine());
        st = new StringTokenizer(sb.toString());

        // 원소 갯수
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        addSet(a);
        addSet(b);

        System.out.println(set.size());
    }

    public static void addSet(int x) throws IOException {
        sb = new StringBuilder(br.readLine());
        st = new StringTokenizer(sb.toString());

        for(int i=0; i<x; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(set.contains(tmp)) {
                set.remove(tmp);
            } else {
                set.add(tmp);
            }
        }
    }
}
