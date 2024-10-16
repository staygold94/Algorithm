import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        float total = 0.0f;
        float sum = 0.0f;

        HashMap<String, Float> map = new HashMap<>();
        map.put("A+", 4.5f);
        map.put("A0", 4.0f);
        map.put("B+", 3.5f);
        map.put("B0", 3.0f);
        map.put("C+", 2.5f);
        map.put("C0", 2.0f);
        map.put("D+", 1.5f);
        map.put("D0", 1.0f);
        map.put("F", 0.0f);
        
        for(int i=0; i<20; i++) {
            String[] arr = br.readLine().split(" ");
            if(arr[2].equals("P")) continue;
            total += Float.parseFloat(arr[1]);
            sum += (map.get(arr[2]) * Float.parseFloat(arr[1]));
        }

        System.out.println(sum / total);
    }
}