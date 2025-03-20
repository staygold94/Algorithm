import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = 0;
        for(int i=0; i<arr.length; i++) {
            answer += Math.pow(arr[i], 2);
        }
        System.out.println(answer%10);
    }
}