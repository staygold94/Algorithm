import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int tmp = arr[0] + arr[1];
        int answer = tmp + (tmp > arr[2] ? arr[2] : tmp - 1);
        System.out.println(answer);
    }
}