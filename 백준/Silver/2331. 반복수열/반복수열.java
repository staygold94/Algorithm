import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long now = Long.parseLong(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        HashMap<Long, Integer> map = new HashMap<>();

        int idx = 0;

        while(!map.containsKey(now)) {
            map.put(now, idx++);
            long tmp = now;
            long sum = 0;
            while(tmp > 0) {
                sum += Math.pow(tmp%10, e);
                tmp /= 10;
            }
            now = sum;
        }

        long answer = map.get(now);
        System.out.println(answer);
    }
}