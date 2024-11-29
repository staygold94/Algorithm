import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        arr = Arrays.stream(arr)
                .boxed()
                .sorted((a, b) -> b - a)
                .mapToInt(Integer::intValue).toArray();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
    }
}