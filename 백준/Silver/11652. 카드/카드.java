import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        long answer = 0;
        int max = 0;
        for(long key : map.keySet()) {
            int num = map.get(key);
            if(max < num || (max == num && answer > key)) {
                answer = key;
                max = num;
            }
        }
        System.out.println(answer);
    }
}